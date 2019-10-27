package com.bitso.challenge.model.ram;

import com.bitso.challenge.entity.Currency;
import com.bitso.challenge.entity.Order;
import com.bitso.challenge.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * RAM-based implementation of orders.
 */
public class OrderModelImpl implements OrderModel {

    private HashMap<Long,Order> orders = new HashMap<>(100);
    private AtomicLong seq = new AtomicLong();

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public long submit(Order order) {
        //order.setCreated(new Date());
        //order.setStatus(Order.Status.active);
        long orderId = insert(order);
        //order.setCreated(new Date());
        //order.setStatus(Order.Status.active);

        //return nOrder.getId();
        return orderId;
    }

    public long insert(Order order) {
        //TODO validate
        //order.setId(seq.incrementAndGet());
        order.setCreated(new Date());
        order.setStatus(Order.Status.active);

        Order nOrder;
        nOrder = ordersRepository.save(order);

        orders.put(nOrder.getId(), order);
        return nOrder.getId();
    }

    @Override
    public Optional<Order> get(long id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> ordersForUser(long userId, Order.Status status, Currency major, Currency minor) {
        return orders.values().stream().filter(o -> o.getUserId() == userId)
                .filter(o -> status == null || status == o.getStatus())
                .filter(o -> major == null || major == o.getMajor())
                .filter(o -> minor == null || minor == o.getMinor())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> book(Currency major, Currency minor) {
        // throw new UnsupportedOperationException("Implement me!");
        return orders.values().stream().filter(o ->  major == null ||  o.getMajor() == major)
                .filter(o -> minor == null || o.getMinor() == minor )
                .collect(Collectors.toList());
    }
}
