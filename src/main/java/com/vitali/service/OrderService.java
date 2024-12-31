package com.vitali.service;

import com.vitali.domain.OrderType;
import com.vitali.modal.Coin;
import com.vitali.modal.Orders;
import com.vitali.modal.OrderItem;
import com.vitali.modal.User;

import java.util.List;

public interface OrderService {

    Orders createOrder(User user, OrderItem orderItem, OrderType orderType);

    Orders getOrderById(long orderId) throws Exception;

    List<Orders> getAllOrdersOfUser(Long userId, OrderType OrderType, String assetSymbol);

    Orders processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
}
