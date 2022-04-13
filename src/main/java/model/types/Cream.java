package main.java.model.types;

import main.java.model.Assignment;
import main.java.model.Cosmetic;

public class Cream extends Cosmetic {
    private String typeOfSkin;

    public Cream(String name, String brand, int volumeInMl, int priceInUah, Assignment assignment, String typeOfSkin) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.typeOfSkin = typeOfSkin;
    }
}
