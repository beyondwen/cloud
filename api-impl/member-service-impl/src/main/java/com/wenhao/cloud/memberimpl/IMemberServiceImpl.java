package com.wenhao.cloud.memberimpl;


import com.wenhao.cloud.BaseApiService;
import com.wenhao.cloud.ResponseBase;
import com.wenhao.cloud.member.enity.UserEntity;
import com.wenhao.cloud.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMemberServiceImpl extends BaseApiService implements IMemberService {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/")
    public String index() {
        return "我是会员服务"+"==="+serverPort;
    }

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(20);
        userEntity.setName(name + "==" + serverPort);
        return userEntity;
    }

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setResultSuccess("订单服务接口调用会员服务接口成功" + "==" + serverPort);
    }
}
