
package com.wenhao.cloud.feign;

import com.wenhao.cloud.fallback.MemberServiceFallback;
import com.wenhao.cloud.member.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "member",fallback = MemberServiceFallback.class)
public interface MemberServiceFegin extends IMemberService {



}
