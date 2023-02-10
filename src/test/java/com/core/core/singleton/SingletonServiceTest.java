package com.core.core.singleton;

import com.core.core.AutoAppConfig;
import com.core.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonServiceTest {

    @Test
    @DisplayName("싱클톤 패턴을 적용한 객체 사용")
    public void SingletonServiceTest(){
        SingletonService singletonService1=SingletonService.getInstance();
        SingletonService singletonService2=SingletonService.getInstance();

        System.out.println("singletonService1 : "+singletonService1);
        System.out.println("singletonService2 : "+singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService1=ac.getBean("memberService", MemberService.class);
        MemberService memberService2=ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 : "+memberService1);
        System.out.println("memberService2 : "+memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
        AutoAppConfig bean=ac.getBean(AutoAppConfig.class);

        System.out.println("bean : "+bean.getClass());
    }
}
