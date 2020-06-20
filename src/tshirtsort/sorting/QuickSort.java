/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.sorting;

import java.util.List;
import tshirtsort.models.TShirt;

/**
 *
 * @author Walter
 */
public class QuickSort {

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    // low = arr.get(low)
    // high = arr.get(high)
    // boolean sortType, sortType == true, ASC -- sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1, Size 
    // sortByProperty == 2, Color 
    // sortByProperty == 3, Fabric
    public void sort(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, sortType, sortByProperty);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1, sortType, sortByProperty);
            sort(arr, pi + 1, high, sortType, sortByProperty);
        }
    }

    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    // boolean sortType, sortType == true, ASC -- sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1, Size 
    // sortByProperty == 2, Color 
    // sortByProperty == 3, Fabric
    private int partition(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        TShirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot 
            switch (sortByProperty) {
                // Size
                case 1:
                    if (sortType) {
                        if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                // Color
                case 2:
                    if (sortType) {
                        if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                // Fabric
                case 3:
                    if (sortType) {
                        if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        TShirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }
}
