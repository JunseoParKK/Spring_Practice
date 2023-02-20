package com.core.core.discount;

import com.core.core.annotation.MainDiscountPolicy;
import com.core.core.member.Grade;
import com.core.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRatePercent=10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountRatePercent / 100;
        }else{
            return 0;
        }
    }
}
