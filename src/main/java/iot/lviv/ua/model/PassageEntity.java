package iot.lviv.ua.model;

import javax.persistence.*;

@Entity
@Table(name = "passage")
public class PassageEntity {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "number")
    private int number;
    @Column(name = "passage_type")
    private String passageType;
    @Column(name = "company")
    private String company;

    public PassageEntity() {
    }

    public PassageEntity(String arrivalCity, String departureCity,
                         String arrivalTime, String departureTime, int number,
                         String passageType, String company) {
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.number = number;
        this.passageType = passageType;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setarrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassageType() {
        return passageType;
    }

    public void setPassageType(String passageType) {
        this.passageType = passageType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s %s %s %s",
                id, arrivalCity, departureCity, number, arrivalTime,
                departureTime, number, passageType, company);
    }
}
