package iot.lviv.ua.model;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket_passage")
public class TicketPassageEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "row")
    private int row;
    @Column(name = "number")
    private int number;
    @Column(name = "free")
    private boolean free;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "class")
    private String passageClass;
    @Column(name = "passage_id")
    private int passageId;

    public TicketPassageEntity() {
    }

    public TicketPassageEntity(int row, int number,
                               boolean free, BigDecimal price, String passageClass,
                               int passageId) {
        this.row = row;
        this.number = number;
        this.free = free;
        this.price = price;
        this.passageClass = passageClass;
        this.passageId = passageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPassageClass() {
        return passageClass;
    }

    public void setPassageClass(String passageClass) {
        this.passageClass = passageClass;
    }

    public int getPassageId() {
        return passageId;
    }

    public void setPassageId(int passageId) {
        this.passageId = passageId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s",
                id, row, number, free, price, passageClass, passageId);
    }
}
