package com.core.core.discount;

import com.core.core.AutoAppConfig;
import com.core.core.member.Grade;
import com.core.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class FixDiscountPolicyTest {

    ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);

    DiscountPolicy discountPolicy=ac.getBean("fixDiscountPolicy", DiscountPolicy.class);

    @Test
    @DisplayName("VIP 인 경우 1000원 고정 할인")
    void vip_o(){
        //given
        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);

        //when
        int discount=discountPolicy.discount(member,20000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아닌 경우 할인 X")
    void vip_x(){
        //given
        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.BASIC);

        //when
        int discount=discountPolicy.discount(member,20000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}
