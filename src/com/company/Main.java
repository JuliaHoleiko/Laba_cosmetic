package com.company;

import model.Assignment;
import model.types.Cream;
import model.types.LipStick;
import model.types.Perfume;

public class Main {

    public static void main(String[] args) {
        Perfume eclat = new Perfume("Eclat","Lanvin", 500, 1000, Assignment.fragrance, "roses", "flowers" );
        Cream cream1 = new Cream("la creme","Versace", 200,1200, Assignment.skincare, "dry");
        LipStick lipStick = new LipStick("lip gloss", "Maybelline", 45, 150, Assignment.makeup, "red");

    }
}

