package com.core.core;

import com.core.core.member.Member;
import com.core.core.member.MemberRepository;
import com.core.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basciScan(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberRepository memberRepository=ac.getBean(MemberRepository.class);
        System.out.println("memberRepository = " + memberRepository);
        MemberService memberService=ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
