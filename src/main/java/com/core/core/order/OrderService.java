package com.core.core.order;

public interface OrderService {
    Order createOrder(Long memberId,int itemPrice,String itemName);
}
