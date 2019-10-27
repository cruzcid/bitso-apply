package com.bitso.challenge.model.ram;

import com.bitso.challenge.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
