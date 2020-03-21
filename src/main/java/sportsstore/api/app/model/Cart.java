package sportsstore.api.app.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartLine> lineCollection;

    public Cart() {
        lineCollection = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        CartLine line = lineCollection.stream()
        .filter(p -> p.getProduct().getProductID() == product.getProductID())
        .findAny()
        .orElse(null);

        if (line == null) {
            lineCollection.add(new CartLine(product, quantity));
        }

        else {
            line.setQuantity(line.getQuantity() + quantity);
        }
    }

    public void removeLine(Product product) {
        lineCollection.removeIf(p -> p.getProduct().getProductID() == product.getProductID());
    }

    public double computeTotalValue() {
        return lineCollection.stream()
        .mapToDouble(x -> x.getProduct().getPrice().doubleValue() * x.getQuantity())
        .sum();
    }

    public void clear() {
        lineCollection.clear();
    }

    public Iterable<CartLine> getLines() {
        return lineCollection;
    }
}