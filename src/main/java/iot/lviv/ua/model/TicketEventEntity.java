package iot.lviv.ua.model;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "address")
public class TicketEventEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private int number;
    @Column(name = "row")
    private int row;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "free")
    private boolean free;
    @Column(name = "place")
    private int place;
    @Column(name = "event_id")
    private int eventId;

    public TicketEventEntity() {
    }

    public TicketEventEntity(int number, int row,
                             BigDecimal price, boolean free, int place,
                             int eventId) {
        this.number = number;
        this.row = row;
        this.price = price;
        this.free = free;
        this.place = place;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s",
                id, number, row, price, free, place, eventId);
    }
}
