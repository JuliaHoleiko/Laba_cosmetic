package com.company;
import manager.impl.ShopManager;
import model.Assignment;
import model.Cosmetic;
import model.types.Cream;
import model.types.LipStick;
import model.types.Perfume;
import model.types.SortType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Perfume eclat = new Perfume("Eclat","Lanvin", 500, 1000, Assignment.fragrance, "roses", "flowers" );
        Perfume my_way = new Perfume("My way Armani","Armani", 500, 1350, Assignment.fragrance, "roses", "flowers" );
        Perfume paco_1million = new Perfume("1 million lucky","Paco Rabanne", 500, 1000, Assignment.fragrance, "roses", "flowers" );

        Cream cream1 = new Cream("la creme","Versace", 200,120, Assignment.skincare, "dry");
        Cream cream2 = new Cream("Effaclar ","La Roche-Posay", 200,300, Assignment.skincare, "dry");
        Cream cream3 = new Cream("collagen cream","Bioderma", 200,120, Assignment.skincare, "dry");

        LipStick lipStick = new LipStick("lip gloss", "Maybelline", 45, 150, Assignment.makeup, "red");

        ShopManager shop = new ShopManager();
        shop.addProduct(eclat,40);
        shop.addProduct(my_way,12);
        shop.addProduct(cream1, 39);
        shop.addProduct(lipStick,21);
        shop.addProduct(cream1, 39);
        shop.addProduct(cream2, 36);
        shop.addProduct(cream3, 2);
        shop.addProduct(paco_1million, 3);

        shop.showAssortment();
        shop.deleteProductByCount(cream1, 70);
        System.out.println();
        shop.showAssortment();


        System.out.println();
        shop.sortByName(SortType.Descending).forEach(((k,v)-> System.out.println(k.getName() + " ,count = "+ v)));

        System.out.println();
        shop.sortByCount(SortType.Ascending).forEach(((k,v)-> System.out.println(k.getName() + " ,count = "+ v)));

        System.out.println();
        shop.searchByBudget(50);

    }
}

