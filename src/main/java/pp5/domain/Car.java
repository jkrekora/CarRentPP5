package pp5.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Rafał on 2016-02-18.
 */
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String segment;

    @NotNull
    private double price;
    private String imageUrl;

    private Timestamp reservationEnd;
    private Timestamp rentEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Timestamp reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public Timestamp getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Timestamp rentEnd) {
        this.rentEnd = rentEnd;
    }
}
