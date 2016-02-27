package pp5.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Rafał on 2016-02-20.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car carId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User username;
    @NotNull
    private boolean confirmed;
    @NotNull
    private Timestamp dateOfRent;
    @NotNull
    private Timestamp endDateOfRent;
    @NotNull
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Timestamp getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Timestamp dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public Timestamp getEndDateOfRent() {
        return endDateOfRent;
    }

    public void setEndDateOfRent(Timestamp endDateOfRent) {
        this.endDateOfRent = endDateOfRent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
