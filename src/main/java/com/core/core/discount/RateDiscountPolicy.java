package com.core.core.discount;

import com.core.core.member.Grade;
import com.core.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRatePercent=15;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountRatePercent / 100;
        }else{
            return 0;
        }
    }
}
