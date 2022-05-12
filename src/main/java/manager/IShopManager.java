package manager;

import model.Cosmetic;
import model.types.SortType;

import java.util.Map;

public interface IShopManager {


     Map<Cosmetic, Integer> sortByCount(SortType sortType);
     Map<Cosmetic, Integer> sortByName(SortType sortType);
     Map<Cosmetic, Integer> searchByBudget(int budget);
     void deleteProductByCount(Cosmetic product, int count);
     void deleteProduct(Cosmetic product);
     void addProduct(Cosmetic product, int count);
     void deleteManager();



}
