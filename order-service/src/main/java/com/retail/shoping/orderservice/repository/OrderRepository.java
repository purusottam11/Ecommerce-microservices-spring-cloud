package com.retail.shoping.orderservice.repository;

import com.retail.shoping.orderservice.model.OrderTb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTb, Long> {
}
