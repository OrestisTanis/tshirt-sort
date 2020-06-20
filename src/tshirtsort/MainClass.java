package tshirtsort;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.factories.TShirtFactory;
import tshirtsort.models.TShirt;
import tshirtsort.sorting.BubbleSort;
import tshirtsort.sorting.BucketSort;
import tshirtsort.sorting.QuickSort;

/**
 *
 * @author Walter
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TShirtFactory tFactory = new TShirtFactory();
        List<TShirt> shirts = tFactory.tShirtGenerateX(40
        );
        printTShirtList(shirts);
        
        // TODO: use factory
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        BucketSort bus = new BucketSort();
//        performQuickSort(qs, shirts);
//        performBubbleSort(bs, shirts);
//        performBucketSort(bus, shirts);
        performBucketSortPerProperty(bus, shirts);
    }

    static void printTShirtList(List<TShirt> tshirts) {
        for (TShirt ts : tshirts) {
            System.out.println(ts);
        }
    }

    // boolean sortType, sortType == true, ASC -- sortType == false, DESC
    // int sortByProperty 
    // sortByProperty == 1, Size 
    // sortByProperty == 2, Color 
    // sortByProperty == 3, Fabric
    static void quickSort(QuickSort qs, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        long startTime = System.currentTimeMillis();
        qs.sort(shirts, 0, shirts.size() - 1, sortType, sortByProperty);
        long endTime = System.currentTimeMillis();

        String sortTypeStr = sortType == true ? "ASC" : "DESC";
        String sortByPropertyStr = "";
        switch (sortByProperty) {
            case 1:
                sortByPropertyStr = "SIZE";
                break;
            case 2:
                sortByPropertyStr = "COLOR";
                break;
            case 3:
                sortByPropertyStr = "FABRIC";
                break;
        }
        System.out.println("**************** QUICKSORT BY " + sortByPropertyStr + " " + sortTypeStr + ", ELAPSED TIME: " + (endTime - startTime) + " MS ******************");
        printTShirtList(shirts);
    }
    
    static void performQuickSort(QuickSort qs, List<TShirt> shirts){
        quickSort(qs, shirts, true, 1); // Size ASC
        quickSort(qs, shirts, false, 1); // Size DESC
        quickSort(qs, shirts, true, 2); // Color ASC
        quickSort(qs, shirts, false, 2); // Color DESC
        quickSort(qs, shirts, true, 3); // Fabric ASC
        quickSort(qs, shirts, false, 3); // Fabric DESC
    }
    
    // bubbleSort
    static void bubbleSort(BubbleSort bs, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        long startTime = System.currentTimeMillis();
        bs.sort(shirts, sortType, sortByProperty);
        long endTime = System.currentTimeMillis();

        String sortTypeStr = sortType == true ? "ASC" : "DESC";
        String sortByPropertyStr = "";
        switch (sortByProperty) {
            case 1:
                sortByPropertyStr = "SIZE";
                break;
            case 2:
                sortByPropertyStr = "COLOR";
                break;
            case 3:
                sortByPropertyStr = "FABRIC";
                break;
        }
        System.out.println("**************** BUBBLESORT BY " + sortByPropertyStr + " " + sortTypeStr + ", ELAPSED TIME: " + (endTime - startTime) + " MS ******************");
        printTShirtList(shirts);
    }
    
    static void performBubbleSort(BubbleSort bs, List<TShirt> shirts){
        bubbleSort(bs, shirts, true, 1); // Size ASC
        bubbleSort(bs, shirts, false, 1); // Size DESC
        bubbleSort(bs, shirts, true, 2); // Color ASC
        bubbleSort(bs, shirts, false, 2); // Color DESC
        bubbleSort(bs, shirts, true, 3); // Fabric ASC
        bubbleSort(bs, shirts, false, 3); // Fabric DESC
    }
    
    // bucketSort
    static void bucketSort(BucketSort bus, List<TShirt> shirts, boolean sortType, int sortByProperty) {
        long startTime = System.currentTimeMillis();
        shirts = bus.sort(shirts, sortType, sortByProperty);
        long endTime = System.currentTimeMillis();

        String sortTypeStr = sortType == true ? "ASC" : "DESC";
        String sortByPropertyStr = "";
        switch (sortByProperty) {
            case 1:
                sortByPropertyStr = "SIZE";
                break;
            case 2:
                sortByPropertyStr = "COLOR";
                break;
            case 3:
                sortByPropertyStr = "FABRIC";
                break;
        }
        System.out.println("**************** BUCKETSORT BY " + sortByPropertyStr + " " + sortTypeStr + ", ELAPSED TIME: " + (endTime - startTime) + " MS ******************");
        
        printTShirtList(shirts);
    }
    
    static void performBucketSort(BucketSort bus, List<TShirt> shirts){
        bucketSort(bus, shirts, true, 1); // Size ASC
        bucketSort(bus, shirts, false, 1); // Size DESC
        bucketSort(bus, shirts, true, 2); // Color ASC
        bucketSort(bus, shirts, false, 2); // Color DESC
        bucketSort(bus, shirts, true, 3); // Fabric ASC
        bucketSort(bus, shirts, false, 3); // Fabric DESC
    }
    
    static void performBucketSortPerProperty(BucketSort bus, List<TShirt> shirts){
       /*
        1. Make a BUS per Size
        2. Find which TShirts have the same Size on the sorted (previous)list
        3. Get the ones of the same Size in a sublist
        4. Make a BUS per Color on the previous sublist
        5. Find which TShirts have the same Color on the previous sorted list (from step 4)
        6. Make a BUS per Fabric
        */
        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>(); // instantiate a List of Lists!
        
        // step 1 - Make a BUS per Size
        List<TShirt> shirtsBySize = bus.sort(shirts, true, 1);
        
        // step 2 - Find which TShirts have the same Size on the sorted (previous)list
        int[] sBySize = new int[7];
        for(int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++; //sBySize[0] == 2
        }
//        for (int i : sBySize) {
//            System.out.println("i : " + i);
//        }
        
        // step 3 - Get the ones of the same Size in a sublist
        TStruct[] allSizes = new TStruct[7];
        int counter = 0; 
        for(int i = 0; i < 7; i++) {
            allSizes[i] = new TStruct();
            if(sBySize[i] == 0) {
                allSizes[i].start = -1;
                allSizes[i].end = -1;
            } else {
                allSizes[i].start = counter; // 0 
                allSizes[i].end = counter + sBySize[i] - 1;
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end + 1)); // this line isn't correct we need to correct it. SEEMS CORRECTED NOW
            }
           
            counter += sBySize[i];
        }
//        for (List<TShirt> sublist: subLists) {
//            System.out.println("SUBLIST: " + sublist);
//        }

        // step 4 - Make a BUS per Color on the previous sublist
        // step 5 - Find which TShirts have the same Color on the previous sorted list (from step 4) (TOGETHER because of the List of Lists
        List<Integer[]> sByColor = new ArrayList<Integer[]>();
        for(int i = 0; i < subLists.size(); i++) {
            sByColor.add(new Integer[7]);
            //Integer[] t = new Integer[7];
            for (Integer integer : sByColor.get(sByColor.size() - 1)) {
                integer = 0;
            }
        }
        
        int sByColorCounter = 0;
        List<List<TShirt>> shirtsByColorList = new ArrayList();
        for(int i = 0; i < subLists.size(); i++) {
            List<TShirt> sList = subLists.get(i);
            //System.out.println("sList : " + sList);
            List<TShirt> shirtsByColor = bus.sort(sList, true, 2);
            shirtsByColorList.add(shirtsByColor);
            //System.out.println("SORTED sList by COLOR: " + shirtsByColorList); 
            for(TShirt tShirt : sList) {
                Integer[] t =  sByColor.get(sByColorCounter);
                int currentColorOrdinal = tShirt.getColor().ordinal();
                if(t[currentColorOrdinal] == null) t[currentColorOrdinal] = 0;
                t[currentColorOrdinal]++;
            }
            sByColorCounter++;
        }
        
        List<List<TShirt>> listOfSortedByFabric = new ArrayList();
        for (int i = 0; i < sByColor.size(); i++){
            counter = 0;    
           System.out.println("counter: " + counter);
            Integer[] intArr = sByColor.get(i);
            List<TShirt> sizeSubList = new ArrayList();
            for (Integer noOfColorOccurences : intArr){
                
                // go to these subLists and make a sort
                if (noOfColorOccurences != null){
//                    System.out.println("noOfColorOccurences: " + noOfColorOccurences);
                    if (noOfColorOccurences > 1){
                        sizeSubList = shirtsByColorList.get(i);
//                        System.out.println("******SUBLISTS:  " + subLists);
//                        System.out.println("******SIZESUBLIST " + sizeSubList);
                        List<TShirt> sublOfSameColor = sizeSubList.subList(counter, counter + noOfColorOccurences); // finding shirts with same color and adding them in a new sublist
                        System.out.println("********** SIZESUBLIST.SUBLIST WITH SAME COLOR :" + sublOfSameColor);
                        
                        sublOfSameColor = bus.sort(sublOfSameColor, true, 3);
                        listOfSortedByFabric.add(sublOfSameColor);
                       System.out.println("*********SIZESUBLIST.SUBLIST WITH SAME COLOR SORTED BY FABRIC: " + sublOfSameColor);
                    }
                    counter += noOfColorOccurences;
//                    System.out.println("COUNTER AFTER INCREMENT: " + counter);
                }
            }
            //counter = 0;
        }
        System.out.println("*^$#^@*$^#@*(^#@$*(^#@*$(^#*$^$#@ ");
        for(List<TShirt> tsList : listOfSortedByFabric){
            System.out.println(tsList);
        }
       
        List<TShirt> finalList = new ArrayList();
        for (List<TShirt> sl : shirtsByColorList){
            finalList.addAll(sl);
        }
        System.out.println("SORTED BY PROPERTIES FINAL LIST: ");
        for (TShirt ts : finalList){
            System.out.println(ts);
        }
        // 0 (XS), 0 start, 1 end
        // 1 (S) , 2 start, 4 end
        // 2 (M) , 5 start, 8 end
        // 3 (L) , 9 start, 10 end 
        //shirtsBySize.subList(0, 1);
        
    }
    
    static class TStruct {
        public int start;
        public int end;
    }
}