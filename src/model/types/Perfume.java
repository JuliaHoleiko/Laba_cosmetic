package model.types;

import model.Assignment;
import model.Cosmetic;

public class Perfume extends Cosmetic {
    private String notes;
    private String typeOfScent;

    public Perfume(String name, String brand, int volumeInMl, int priceInUah, Assignment assignment, String notes, String typeOfScent) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.notes = notes;
        this.typeOfScent = typeOfScent;
    }
}
