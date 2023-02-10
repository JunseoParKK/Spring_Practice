package com.core.core.discount;

import com.core.core.AutoAppConfig;
import com.core.core.member.Grade;
import com.core.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class RateDiscountPolicyTest {

    ApplicationContext ac=new AnnotationConfigApplicationContext(TestAppConfig.class);
    DiscountPolicy discountPolicy=ac.getBean("discountPolicy",DiscountPolicy.class);

    @Test
    @DisplayName("VIP 인 경우 15% 할인")
      void vip_o(){
        //given
        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        int price=20000;
        //when
        int discount=discountPolicy.discount(member,price);

        //then
        assertThat(discount).isEqualTo(3000);
    }

    @Configuration
    static class TestAppConfig{
        @Bean
        DiscountPolicy discountPolicy(){
            return new RateDiscountPolicy();
        }
    }
}
