package pp5.services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Rafał on 2016-02-20.
 */
public class OrderForm {
    @NotNull
    @Min(1)
    private int carId;

    @NotNull
    @Min(1)
    private int daysQuatity;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getDaysQuatity() {
        return daysQuatity;
    }

    public void setDaysQuatity(int daysQuatity) {
        this.daysQuatity = daysQuatity;
    }
}
