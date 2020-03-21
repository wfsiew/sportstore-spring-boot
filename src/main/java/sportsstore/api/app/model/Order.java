package sportsstore.api.app.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @Column
    private String name;

    @Column
    @NotNull
    private String line1;

    @Column(nullable = true)
    private String line2;

    @Column(nullable = true)
    private String line3;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String state;

    @Column(nullable = true)
    private String zip;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    private boolean giftWrap;

    @Column
    @NotNull
    private boolean shipped;

    @Transient
    @JsonIgnore
    private Collection<CartLine> lines;

    public Order() {
    }

    /**
     * @return int return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * @param line1 the line1 to set
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * @return String return the line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     * @param line2 the line2 to set
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     * @return String return the line3
     */
    public String getLine3() {
        return line3;
    }

    /**
     * @param line3 the line3 to set
     */
    public void setLine3(String line3) {
        this.line3 = line3;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return String return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return boolean return the giftWrap
     */
    public boolean isGiftWrap() {
        return giftWrap;
    }

    /**
     * @param giftWrap the giftWrap to set
     */
    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    /**
     * @return boolean return the shipped
     */
    public boolean isShipped() {
        return shipped;
    }

    /**
     * @param shipped the shipped to set
     */
    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    /**
     * @return Collection<CartLine> return the lines
     */
    public Collection<CartLine> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(Collection<CartLine> lines) {
        this.lines = lines;
    }
}