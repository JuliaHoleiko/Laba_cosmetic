package writer;

import manager.impl.ShopManager;
import model.Assignment;
import model.types.Cream;
import model.types.LipStick;
import model.types.Perfume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class WriterTest {


    @BeforeEach
    void setUp (){
        ShopManager managerTest = new ShopManager();
        Perfume eclat = new Perfume("Eclat","Lanvin", 500, 1000, Assignment.fragrance, "roses", "flowers" );
        Cream cream1 = new Cream("la creme","Versace", 200,120, Assignment.skincare, "dry");
        LipStick lipStick = new LipStick("lip gloss", "Maybelline", 45, 150, Assignment.makeup, "red");
        Perfume my_way = new Perfume("My way Armani","Armani",  500, 1350, Assignment.fragrance, "roses", "flowers" );
        Cream cream2 = new Cream("Effaclar ","La Roche-Posay", 200,300, Assignment.skincare, "dry");
        Cream cream3 = new Cream("collagen cream","Bioderma", 200,120, Assignment.skincare, "dry");

        managerTest.addProduct(eclat,1);
        managerTest.addProduct(lipStick,3);
        managerTest.addProduct(my_way,4);
        managerTest.addProduct(cream1, 2);
        managerTest.addProduct(cream2,5);
        managerTest.addProduct(cream3,7);
        Writer.writeCSV(managerTest.getMapOfExistingProducts(),"results");

    }
    @Test
    void testWriteToCSV  () throws IOException {
       try( FileReader expectedReader = new FileReader(new File("src//test//resources//", "expected.csv"));
            FileReader actualReader = new FileReader(new File("src//main//resources//", "results.csv"));
            BufferedReader expectedBufferReader = new BufferedReader(expectedReader);
            BufferedReader actualBufferReader = new BufferedReader(actualReader) ){
            String line = "";
            while ((line = expectedBufferReader.readLine()) != null) {
                Assertions.assertEquals(line, actualBufferReader.readLine());
            }
        }
    }
}

