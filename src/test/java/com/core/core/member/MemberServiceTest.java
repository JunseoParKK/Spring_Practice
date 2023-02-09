package com.core.core.member;

import com.core.core.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
    ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService=ac.getBean("memberServiceImpl",MemberService.class);

    @Test
    void join(){
        //given
        Member member=new Member(1L,"memberA",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(member.getId());

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
