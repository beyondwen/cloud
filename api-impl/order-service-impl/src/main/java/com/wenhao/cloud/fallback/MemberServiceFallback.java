package com.wenhao.cloud.fallback;

import com.wenhao.cloud.BaseApiService;
import com.wenhao.cloud.ResponseBase;
import com.wenhao.cloud.feign.MemberServiceFegin;
import com.wenhao.cloud.member.enity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFegin {

    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务降级通过类方式实现");
    }
}
