package sportsstore.api.app.model;

import java.util.List;

public class Checkout {

    private Order order;
    private List<CartLine> lines;

    public Checkout() {
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

    /**
     * @return List<CartLine> return the lines
     */
    public List<CartLine> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(List<CartLine> lines) {
        this.lines = lines;
    }
}