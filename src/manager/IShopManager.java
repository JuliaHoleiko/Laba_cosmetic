package manager;

import model.Cosmetic;

import java.util.List;

public interface IShopManager {
     List<Cosmetic> sortByPrice ();
     List<Cosmetic> sortByName();
     List<Cosmetic> searchByBudget (int budget);


}
