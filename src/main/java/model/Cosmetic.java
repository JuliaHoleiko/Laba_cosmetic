package model;

import lombok.*;

@Data
@AllArgsConstructor



public abstract class Cosmetic {
    private final String name;
    private final String brand;
    private final int volumeInMl;
    private final int priceInUah;
    private final Assignment assignment;
    public String getHeaders() {
        return  "name ," + "brand  ," + "volumeInMl ," + "priceInUah ," + "assignment";
    }
    public String toCSV() {
        return getName() + ", " + getBrand() + ", " +  getVolumeInMl() + ", " + getPriceInUah() + ", " + getAssignment();
    }

}
