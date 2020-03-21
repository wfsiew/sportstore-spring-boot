package sportsstore.api.app.controller;

import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sportsstore.api.app.model.Checkout;
import sportsstore.api.app.model.Order;
import sportsstore.api.app.repository.OrderRepository;
import sportsstore.api.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public Iterator<Order> getList() {
        var q = orderRepository.findAll().stream().filter(p -> !p.isShipped());
        return q.iterator();
    }

    @PostMapping("/markshipped/{orderID}")
    public ResponseEntity<HashMap<String, Object>> arkShipped(@PathVariable("orderID") int orderID) {
        HashMap<String, Object> m = new HashMap<>();
        Order order = orderRepository.findByOrderID(orderID);
        if (order != null) {
            order.setShipped(true);
            orderRepository.save(order);
            m.put("success", 1);
        }

        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(m);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestBody Checkout checkout) {
        Order o = checkout.getOrder();
        o.setLines(checkout.getLines());
        
        orderService.save(o);

        return ResponseEntity.ok().body(o);
    }
}