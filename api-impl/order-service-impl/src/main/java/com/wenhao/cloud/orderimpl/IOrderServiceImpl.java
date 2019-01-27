package com.wenhao.cloud.orderimpl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wenhao.cloud.BaseApiService;
import com.wenhao.cloud.IOrderService;
import com.wenhao.cloud.ResponseBase;
import com.wenhao.cloud.feign.MemberServiceFegin;
import com.wenhao.cloud.member.enity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOrderServiceImpl extends BaseApiService implements IOrderService {

    @Autowired
    private MemberServiceFegin memberServiceFegin;

    @RequestMapping("/")
    public String index() {
        return "我是订单服务";
    }

    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity user = memberServiceFegin.getMember(name);
        return user == null ? "没有找到用户" : user.toString();
    }

    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        ResponseBase userInfo = memberServiceFegin.getUserInfo();
        return userInfo;
    }

    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFegin.getUserInfo();
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级,服务器忙，请稍后重试!");
    }

    @RequestMapping("/orderToMemberUserInfoHystrixByClass")
    public ResponseBase orderToMemberUserInfoHystrixByClass() {
        System.out.println("orderToMemberUserInfoHystrix:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFegin.getUserInfo();
    }

    // 订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("orderInfo:" + "线程池名称:" + Thread.currentThread().getName());
        return setResultSuccess();
    }

}
