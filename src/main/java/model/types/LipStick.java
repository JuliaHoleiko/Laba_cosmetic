package model.types;

import model.Assignment;
import model.Cosmetic;

public class LipStick extends Cosmetic {
    private String color;

    public LipStick(String name, String brand, int volumeInMl, int priceInUah, Assignment assignment, String color) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.color = color;
    }
}
