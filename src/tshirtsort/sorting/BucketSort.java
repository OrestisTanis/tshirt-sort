/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;

/**
 *
 * @author Walter
 */
public class BucketSort {
    List<TShirt>[] buckets;
    
    // sortType = true - ASC, false = DESC
    // int sortByProperty 
    // sortByProperty == 1 -- Size
    // sortByProperty == 2 -- Color 
    // sortByProperty == 3 -- Fabric 
    public List<TShirt> sort(List<TShirt> tshirts, boolean sortType, int sortByProperty) {
        // Bucket Sort
        int maxValue = 6;
        List<TShirt> sorted_tshirts = new ArrayList<>();
        List<TShirt>[] buckets = new ArrayList[6 + 1];
        for (int i = 0; i <= maxValue; i++) {
            buckets[i] = new ArrayList<TShirt>();
        }
        for(int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < tshirts.size(); j++) {
                switch(sortByProperty) {
                    case 1: // SIZE
                        if(i == tshirts.get(j).getSize().ordinal())
                            buckets[i].add(tshirts.get(j));
                        break;
                    case 2: // COLOR
                        if(i == tshirts.get(j).getColor().ordinal())
                            buckets[i].add(tshirts.get(j));
                        break;
                    case 3: // FABRIC
                        if(i == tshirts.get(j).getFabric().ordinal())
                    buckets[i].add(tshirts.get(j));
                        break;
                }
            }
        }
        if(sortType == true) {
            for(int i = 0; i <= maxValue; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_tshirts.add(buckets[i].get(j));
                }
            
            }
        } else {
            for(int i = maxValue; i >= 0; i--) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_tshirts.add(buckets[i].get(j));
                }
            
            }
        }
            
//        
//        for (int i = 0; i < tshirts.size(); i++) {
//            // buckets[0] <-- add XS
//            buckets[tshirts.get(i).getSize().ordinal()].add(tshirts.get(i));
//        }
        return sorted_tshirts;
    }
}
