package manager.impl;

import manager.IShopManager;
import model.Cosmetic;
import model.types.SortType;

import java.util.*;
import java.util.stream.Collectors;

public class ShopManager implements IShopManager{
    private Map <Cosmetic, Integer> mapOfExistingProducts = new HashMap<>();

    @Override
    public void deleteProductByCount(Cosmetic product, int count){
        if(mapOfExistingProducts == null)
            System.out.println("Your list of product is empty");
        else if (mapOfExistingProducts.keySet().contains(product)){
            int newCount = mapOfExistingProducts.get(product).intValue() - count;
            mapOfExistingProducts.remove(product);
            mapOfExistingProducts.put(product,newCount);
        }
        else System.out.println("this product is not in the list");
    }

    @Override
    public void deleteProduct(Cosmetic product, int count){
        if(mapOfExistingProducts == null)
            System.out.println("Your list of product is empty");
        else if (mapOfExistingProducts.keySet().contains(product)){
            mapOfExistingProducts.remove(product);
        }
        else System.out.println("this product is not in the list");
    }

    @Override
    public void addProduct(Cosmetic product, int count){
        if(mapOfExistingProducts == null)
            mapOfExistingProducts.put(product,count);
        else if (!mapOfExistingProducts.keySet().contains(product))
            mapOfExistingProducts.put(product,count);
        else mapOfExistingProducts.computeIfPresent(product, (k, v) -> v + count);
      }


    @Override
    public void showAssortment (){
        mapOfExistingProducts.forEach((k,v)-> System.out.println(k.toString() + " count = "+ v));
    }


    @Override
    public Map<Cosmetic, Integer> sortByCount(SortType sortType) {
        if (sortType == SortType.Descending)
            return mapOfExistingProducts.entrySet().stream()
                    .sorted((o1,o2)->
                            Integer.compare(o2.getValue(), o1.getValue()))
                    .collect(Collectors.toMap(a-> a.getKey(), a->a.getValue(),
                            (o1, o2)-> o1, LinkedHashMap:: new));
        else
            return mapOfExistingProducts.entrySet().stream()
                    .sorted((o1,o2)->
                            Integer.compare(o1.getValue(), o2.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry :: getValue,
                            (o1, o2)-> o1, LinkedHashMap:: new));


    }

    @Override
    public Map<Cosmetic, Integer>sortByName(SortType sortType) {
        if (sortType == SortType.Descending)
            return mapOfExistingProducts.entrySet().stream()
                    .sorted((o1,o2)->
                            CharSequence.compare(o1.getKey().getName().toLowerCase(Locale.ROOT), o2.getKey().getName().toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry :: getValue,
                            (o1, o2)-> o1, LinkedHashMap:: new));
        else return mapOfExistingProducts.entrySet().stream()
                .sorted((o1,o2)->
                        CharSequence.compare(o2.getKey().getName().toLowerCase(Locale.ROOT), o1.getKey().getName().toLowerCase(Locale.ROOT)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry :: getValue,
                        (o1, o2)-> o1, LinkedHashMap:: new));

    }

    @Override
    public void searchByBudget(int budget) {
        Map<Cosmetic, Integer> mapByBudget =  mapOfExistingProducts.entrySet().stream()
                .filter(x-> x.getKey().getPriceInUah() <= budget)
                .collect(Collectors.toMap(a-> a.getKey(), a->a.getValue()));
        if (mapByBudget.isEmpty())
            System.out.println("You can't buy any product");
        else  mapByBudget.forEach((k,v)-> System.out.println(k.getName()+ " "+ k.getPriceInUah()));
    }



}
