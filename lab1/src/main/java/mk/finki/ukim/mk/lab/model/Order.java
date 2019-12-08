package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Order {
    protected String pizzaType;
    protected String clientName;
    protected String clientAddress;
    protected Long orderId;

    public Order() {
        this.pizzaType = null;
        this.clientName = null;
        this.clientAddress = null;
        this.orderId = null;
    }

    public Order(String pizzaTyp, String clientName, String clientAddress, Long orderId) {
        this.pizzaType = pizzaType;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
