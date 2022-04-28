package model.types;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Assignment;
import model.Cosmetic;
@Getter
@Setter
@ToString(callSuper = true)


public class Perfume extends Cosmetic {
    private final String notes;
    private final String typeOfScent;
    public Perfume(final String name, final String brand, final int volumeInMl, final int priceInUah, final Assignment assignment, final String notes, final String typeOfScent) {
        super(name, brand, volumeInMl, priceInUah, assignment);
        this.notes = notes;
        this.typeOfScent = typeOfScent;
    }
    @Override
    public String getHeaders() {
        return super.getHeaders() + ", notes, type of scent";
    }
    @Override
    public String toCSV() {
        return super.toCSV() + ", " + getNotes() + ", " + getTypeOfScent();
    }
}
