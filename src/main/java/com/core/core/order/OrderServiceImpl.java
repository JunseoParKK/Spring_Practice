package com.core.core.order;

import com.core.core.discount.DiscountPolicy;
import com.core.core.member.Member;
import com.core.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
