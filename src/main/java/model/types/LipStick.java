package model.types;

import lombok.*;
import model.Assignment;
import model.Cosmetic;
@Getter
@Setter
@ToString(callSuper = true)



public class LipStick extends Cosmetic {
    private final String color;
    public LipStick(final String name, final String brand, final int volumeInMl, final int priceInUah, final Assignment assignment, final String color) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.color = color;
    }
    @Override
    public String toCSV() {
        return super.toCSV() + ", " + getColor();
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", color";
    }
}
