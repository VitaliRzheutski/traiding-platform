package com.vitali.repository;

import com.vitali.modal.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

   List<Order> findByUserId(long userId);
}
