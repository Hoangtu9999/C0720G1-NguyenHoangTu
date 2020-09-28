package _12_java_collections_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection.array_list;

import java.util.Comparator;

public class DescendingArrangement implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getPrice() > o2.getPrice()){
            return -1;
        }else if(o1.getPrice() == o2.getPrice()){
            return 0;
        }else{
            return 1;
        }
    }
}

