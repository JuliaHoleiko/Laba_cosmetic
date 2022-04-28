package model.types;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Assignment;
import model.Cosmetic;
@Getter
@Setter
@ToString(callSuper = true)
public class Cream extends Cosmetic {
    private final String typeOfSkin;
    public Cream(final String name, final String brand, final int volumeInMl, final int priceInUah, final Assignment assignment, final String typeOfSkin) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.typeOfSkin = typeOfSkin;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ", type of skin";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + getTypeOfSkin();
    }
}
