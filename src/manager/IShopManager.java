package manager;

import model.Cosmetic;
import model.types.SortType;

import java.util.List;
import java.util.Map;

public interface IShopManager {


     Map<Cosmetic, Integer> sortByCount (SortType sortType);
     Map<Cosmetic, Integer> sortByName(SortType sortType);
     void searchByBudget (int budget);
     void deleteProductByCount(Cosmetic product, int count);
     void deleteProduct(Cosmetic product, int count);
     void addProduct(Cosmetic product, int count);
     void showAssortment ();


}
