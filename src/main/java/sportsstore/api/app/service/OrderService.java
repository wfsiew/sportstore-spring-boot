package sportsstore.api.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sportsstore.api.app.model.CartLine;
import sportsstore.api.app.model.Order;
import sportsstore.api.app.repository.CartLineRepository;
import sportsstore.api.app.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartLineRepository cartLineRepository;

    @Transactional
    public void save(Order order) {
        for (CartLine c : order.getLines()) {
            c.setOrder(order);
            cartLineRepository.saveAndFlush(c);
        }

        orderRepository.saveAndFlush(order);
    }
}