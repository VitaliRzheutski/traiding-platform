package com.vitali.service;

import com.vitali.domain.OrderType;
import com.vitali.modal.Coin;
import com.vitali.modal.Order;
import com.vitali.modal.OrderItem;
import com.vitali.modal.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId, OrderType OrderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user);
}
