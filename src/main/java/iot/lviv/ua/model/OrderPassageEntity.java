package iot.lviv.ua.model;

import javax.persistence.*;

@Entity
@Table(name = "order_passage")
public class OrderPassageEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "payed")
    private boolean payed;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "delivery")
    private String delivery;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "passage_id")
    private int passageId;

    public OrderPassageEntity() {
    }

    public OrderPassageEntity(boolean payed, int userId,
                              String delivery, String paymentMethod, int passageId) {
        this.payed = payed;
        this.userId = userId;
        this.delivery = delivery;
        this.paymentMethod = paymentMethod;
        this.passageId = passageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPassageId() {
        return passageId;
    }

    public void setPassageId(int passageId) {
        this.passageId = passageId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                id, payed, userId, delivery, paymentMethod, passageId);
    }
}
