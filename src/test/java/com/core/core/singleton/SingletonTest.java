package com.core.core.singleton;

import com.core.core.AutoAppConfig;
import com.core.core.member.MemberRepository;
import com.core.core.member.MemberService;
import com.core.core.member.MemberServiceImpl;
import com.core.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig=new AppConfig();

        MemberService memberService1= appConfig.memberService();
        MemberService memberService2= appConfig.memberService();

        System.out.println("memberService1: "+memberService1);
        System.out.println("memberService2: "+memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    static class AppConfig{
        @Bean
        MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
        }

        @Bean
        MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }
    }
}
