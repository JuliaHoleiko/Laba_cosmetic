package model.types;

import model.Assignment;
import model.Cosmetic;

public class Cream extends Cosmetic {
    private String typeOfSkin;

    public Cream(String name, String brand, int volumeInMl, int priceInUah, Assignment assignment, String typeOfSkin) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.typeOfSkin = typeOfSkin;
    }
}
