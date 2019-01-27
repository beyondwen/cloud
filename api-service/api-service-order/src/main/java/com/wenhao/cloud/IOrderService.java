
package com.wenhao.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface IOrderService {

    // 实体类是存放接口项目还是 存放在实现项目 实体类存放在接口项目里面
    // 实体类和定义接口信息存放在接口项目
    // 代码实现存放在接口实现类里面

    @RequestMapping("/orderToMember")
    String orderToMember(@RequestParam("name") String name);

    @RequestMapping("/orderToMemberUserInfo")
    ResponseBase orderToMemberUserInfo();

    @RequestMapping("/orderInfo")
    ResponseBase orderInfo();

}
