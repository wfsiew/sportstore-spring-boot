package sportsstore.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sportsstore.api.app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    Order findByOrderID(int orderID);
}