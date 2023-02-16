package com.core.core.order;

import com.core.core.discount.DiscountPolicy;
import com.core.core.member.Member;
import com.core.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, int itemPrice, String itemName) {
        Member member=memberRepository.findById(memberId);
        int discount=discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemPrice,itemName,discount);
    }
}
