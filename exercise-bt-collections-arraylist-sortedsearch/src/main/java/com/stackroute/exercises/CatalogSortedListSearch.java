package com.stackroute.exercises;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogSortedListSearch {

    private static List<String> sortedCatalog;


    //write here logic to get sorted Array List which is a global class variable
    public String catalogListSorter(List<String> unSortedCatalogList) {
        if(unSortedCatalogList == null) return "The catalog list is null";
        if(unSortedCatalogList.size() == 0) return "The catalog List is empty";

        if(unSortedCatalogList.contains(null) || unSortedCatalogList.contains(" ") || unSortedCatalogList.contains(""))
            return "The catalog List contains empty or null or blank space as a value";

        sortedCatalog = new ArrayList<>(unSortedCatalogList);
        Collections.sort(sortedCatalog);

        return sortedCatalog.toString();
    }

    //write here logic to search the input value in sorted Array List
    public String catalogListSearcher(String value) {
        if(value == null || value.equals(" ") || value.equals(""))
            return "Input is not accepted";

        value = Character.toUpperCase(value.charAt(0)) + value.substring(1);

        if(sortedCatalog.contains(value) )
            return "Found: " + value;

        return "Not Found";
    }

    public static void main(String[] args){
        CatalogSortedListSearch cs = new CatalogSortedListSearch();
        List<String> catalogListDemo = new ArrayList<>();
        catalogListDemo.add("Nike");
        catalogListDemo.add("Puma");
        catalogListDemo.add("Adidas");
        catalogListDemo.add("Reebok");
        catalogListDemo.add("UnderArmour");
        catalogListDemo.add("NBalance");
        catalogListDemo.add("SuperDry");

        System.out.println(cs.catalogListSorter(catalogListDemo));
        System.out.println(cs.catalogListSearcher("reebok"));
    }
}

