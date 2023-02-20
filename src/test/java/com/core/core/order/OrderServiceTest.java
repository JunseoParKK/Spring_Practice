package com.core.core.order;

import com.core.core.AutoAppConfig;
import com.core.core.member.Grade;
import com.core.core.member.Member;
import com.core.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

    ApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
    OrderService orderService=ac.getBean("orderServiceImpl", OrderService.class);
    MemberService memberService=ac.getBean("memberService",MemberService.class);

    @Test
    void createOrder(){
        //given
        Long memberId=1L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order=orderService.createOrder(memberId,10000,"itemA");

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1500);
    }
}
