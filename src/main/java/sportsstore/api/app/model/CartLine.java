package sportsstore.api.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cartline")
public class CartLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartLineID;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    @Column
    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    public CartLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return int return the cartLineID
     */
    public int getCartLineID() {
        return cartLineID;
    }

    /**
     * @param cartLineID the cartLineID to set
     */
    public void setCartLineID(int cartLineID) {
        this.cartLineID = cartLineID;
    }

    /**
     * @return Product return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return int return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Order return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}