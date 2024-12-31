package com.vitali.repository;

import com.vitali.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

   List<Orders> findByUserId(long userId);
}
