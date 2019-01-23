package com.wenhao.cloud.impl.impl;

import com.wenhao.cloud.member.enity.UserEntity;
import com.wenhao.cloud.member.service.IMemberService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMemberServiceImpl implements IMemberService {

    @Override
    public UserEntity getMember(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(20);
        userEntity.setName(name);
        return userEntity;
    }
}
