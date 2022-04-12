package model;

public abstract class Cosmetic {
    protected String name;
    private String brand;
    private int volumeInMl;
    private int priceInUah;
    private Assignment assignment;



    public Cosmetic(String name, String brand, int volumeInMl, int priceInUah, Assignment assignment) {
        this.name = name;
        this.brand = brand;
        this.volumeInMl = volumeInMl;
        this.priceInUah = priceInUah;
        this.assignment = assignment;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolumeInMl() {
        return volumeInMl;
    }

    public void setVolumeInMl(int volumeInMl) {
        this.volumeInMl = volumeInMl;
    }

    public int getPriceInUah() {
        return priceInUah;
    }

    public void setPriceInUah(int priceInUah) {
        this.priceInUah = priceInUah;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }



    @Override
    public String toString() {
        return name +
                ",brand='" + brand  +
                ", volumeInMl=" + volumeInMl +
                ", priceInUah=" + priceInUah +
                ", assignment=" + assignment;
    }
}
