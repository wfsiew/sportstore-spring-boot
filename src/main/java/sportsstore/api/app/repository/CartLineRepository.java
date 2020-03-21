package sportsstore.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sportsstore.api.app.model.CartLine;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Integer> {

}