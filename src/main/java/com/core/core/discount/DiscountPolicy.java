package com.core.core.discount;

import com.core.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
