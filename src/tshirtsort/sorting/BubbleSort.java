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
public class BubbleSort {

    // boolean sortType, sortType == true, ASC -- sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1, Size 
    // sortByProperty == 2, Color 
    // sortByProperty == 3, Fabric
    public void sort(List<TShirt> arr, boolean sortType, int sortByProperty) {
        int n = arr.size();

        switch (sortByProperty) {
            case 1:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (sortType) {
                            if (arr.get(j).getSize().ordinal() > arr.get(j + 1).getSize().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else {
                            if (arr.get(j).getSize().ordinal() < arr.get(j + 1).getSize().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (sortType) {
                            if (arr.get(j).getColor().ordinal() > arr.get(j + 1).getColor().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else {
                            if (arr.get(j).getColor().ordinal() < arr.get(j + 1).getColor().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (sortType) {
                            if (arr.get(j).getFabric().ordinal() > arr.get(j + 1).getFabric().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        } else {
                            if (arr.get(j).getFabric().ordinal() < arr.get(j + 1).getFabric().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            }
                        }
                    }
                }
                break;
        }
    }
}
