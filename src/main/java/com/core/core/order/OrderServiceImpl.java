package com.core.core.order;

import com.core.core.discount.DiscountPolicy;
import com.core.core.member.Member;
import com.core.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderService")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, int itemPrice, String itemName) {
        Member member=memberRepository.findById(memberId);
        int discount=discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemPrice,itemName,discount);
    }
}
