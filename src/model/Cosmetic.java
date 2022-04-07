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
}
