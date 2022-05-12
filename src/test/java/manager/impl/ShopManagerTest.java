package manager.impl;

import model.Assignment;
import model.Cosmetic;
import model.types.Cream;
import model.types.LipStick;
import model.types.Perfume;
import model.types.SortType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class ShopManagerTest {
    final static ShopManager managerTest = new ShopManager();
    final static Perfume eclat = new Perfume("Eclat","Lanvin", 500, 1000, Assignment.fragrance, "roses", "flowers" );
    final static Cream cream1 = new Cream("la creme","Versace", 200,120, Assignment.skincare, "dry");
    final static LipStick lipStick = new LipStick("lip gloss", "Maybelline", 45, 150, Assignment.makeup, "red");
    final static Perfume my_way = new Perfume("My way Armani","Armani",  500, 1350, Assignment.fragrance, "roses", "flowers" );
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
      public void addCosmeticToMap (){
        managerTest.addProduct(eclat,1);
        managerTest.addProduct(cream1, 2);
        managerTest.addProduct(lipStick,3);
        managerTest.addProduct(my_way,4);

    }
    @AfterEach
    public void deleteTestManager(){
        managerTest.getMapOfExistingProducts().clear();
    }


    @Test
    void addProduct() {
        Map<Cosmetic, Integer> expectedMap = new HashMap<>();


        Map<Cosmetic, Integer> actual = managerTest.getMapOfExistingProducts();

        expectedMap.put(eclat,1);
        expectedMap.put(cream1,2);
        expectedMap.put(lipStick,3);
        expectedMap.put(my_way,4);

        assertEquals(4, actual.size());
        assertEquals(actual, expectedMap);
        managerTest.addProduct(my_way,5);
        assertEquals(4, actual.size());
        expectedMap.replace(my_way, 9);
        assertEquals(actual, expectedMap);


    }
    @Test
    void sortByCount(){

       List <Cosmetic> actual =  managerTest.sortByCount(SortType.Ascending).keySet().stream().toList();
       assertEquals(actual.indexOf(eclat), 0);
       assertEquals(actual.indexOf(cream1), 1);
       assertEquals(actual.indexOf(lipStick), 2);
       assertEquals(actual.indexOf(my_way), 3);
        List <Integer> actualAscendingValues =  managerTest.sortByCount(SortType.Ascending).values().stream().toList();
        assertEquals(actualAscendingValues.indexOf(1), 0);
        assertEquals(actualAscendingValues.indexOf(2), 1);
        assertEquals(actualAscendingValues.indexOf(3), 2);
        assertEquals(actualAscendingValues.indexOf(4), 3);
        List <Cosmetic> actualDesc =  managerTest.sortByCount(SortType.Descending).keySet().stream().toList();
        assertEquals(actualDesc.indexOf(eclat), 3);
        assertEquals(actualDesc.indexOf(cream1), 2);
        assertEquals(actualDesc.indexOf(lipStick), 1);
        assertEquals(actualDesc.indexOf(my_way), 0);

        List <Integer> actualDescendingValues =  managerTest.sortByCount(SortType.Descending).values().stream().toList();
        assertEquals(actualDescendingValues.indexOf(1), 3);
        assertEquals(actualDescendingValues.indexOf(2), 2);
        assertEquals(actualDescendingValues.indexOf(3), 1);
        assertEquals(actualDescendingValues.indexOf(4), 0);
    }
    @Test
    void sortByName(){
        List <Cosmetic> actualAscendingKeys =  managerTest.sortByName(SortType.Ascending).keySet().stream().toList();
        assertEquals(actualAscendingKeys.indexOf(eclat), 3);
        assertEquals(actualAscendingKeys.indexOf(cream1), 2);
        assertEquals(actualAscendingKeys.indexOf(lipStick), 1);
        assertEquals(actualAscendingKeys.indexOf(my_way), 0);
        List <Integer> actualAscendingValues =  managerTest.sortByName(SortType.Ascending).values().stream().toList();
        assertEquals(actualAscendingValues.indexOf(1), 3);
        assertEquals(actualAscendingValues.indexOf(2), 2);
        assertEquals(actualAscendingValues.indexOf(3), 1);
        assertEquals(actualAscendingValues.indexOf(4), 0);
        List <Cosmetic> actualDescendingKey =  managerTest.sortByName(SortType.Descending).keySet().stream().toList();
        assertEquals(actualDescendingKey.indexOf(eclat), 0);
        assertEquals(actualDescendingKey.indexOf(cream1), 1);
        assertEquals(actualDescendingKey.indexOf(lipStick), 2);
        assertEquals(actualDescendingKey.indexOf(my_way), 3);
        List <Integer> actualDescendingValues =  managerTest.sortByName(SortType.Descending).values().stream().toList();
        assertEquals(actualDescendingValues.indexOf(1), 0);
        assertEquals(actualDescendingValues.indexOf(2), 1);
        assertEquals(actualDescendingValues.indexOf(3), 2);
        assertEquals(actualDescendingValues.indexOf(4), 3);


    }
    @Test
    void searchByBudget(){
        assertTrue(managerTest.searchByBudget(60).isEmpty());
        Map<Cosmetic, Integer> actual=  managerTest.searchByBudget(200);
        assertTrue(actual.containsKey(lipStick) && actual.get(lipStick) == 3);

        assertFalse(actual.containsKey(eclat));
        assertTrue(actual.containsKey(cream1));
        assertFalse(actual.containsKey(my_way));
    }

    @Test
    void deleteProduct(){
        managerTest.deleteProduct(cream1);
        Map<Cosmetic, Integer> actual = managerTest.getMapOfExistingProducts();
        Map<Cosmetic, Integer> expected = new HashMap<>();
        expected.put(eclat,1);
        expected.put(lipStick,3);
        expected.put(my_way,4);
        assertEquals(actual, expected);


    }
    @Test
    void deleteProductByCount(){
        managerTest.deleteProductByCount(my_way, 2);
        Map<Cosmetic, Integer> actual = managerTest.getMapOfExistingProducts();
        Map<Cosmetic, Integer> expected = new HashMap<>();
        expected.put(eclat,1);
        expected.put(lipStick,3);
        expected.put(cream1,2);
        expected.put(my_way,2);
        assertEquals(actual, expected);
        managerTest.deleteProductByCount(my_way,9);
        expected.clear();
        expected.put(eclat,1);
        expected.put(lipStick,3);
        expected.put(cream1,2);
        assertEquals(actual, expected);

    }
    @Test
    void deleteManager(){
        managerTest.deleteManager();
        Map<Cosmetic, Integer> actual = managerTest.getMapOfExistingProducts();
        Map<Cosmetic, Integer> expected = new HashMap<>();
        assertEquals(actual, expected);

    }





}