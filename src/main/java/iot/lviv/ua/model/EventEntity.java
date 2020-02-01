package iot.lviv.ua.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class EventEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "artist_id")
    private int artistId;
    @Column(name = "event_type")
    private String eventType;

    public EventEntity() {
    }

    public EventEntity(String date, String description, int addressId,
                       int artistId, String eventType) {
        this.date = date;
        this.description = description;
        this.addressId = addressId;
        this.artistId = artistId;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                id, date, description, addressId, artistId, eventType);
    }
}
