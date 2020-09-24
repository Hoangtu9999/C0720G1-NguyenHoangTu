package _11_DSA_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_tu_trong_chuoi_sd_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WordCountAppears {
    public static void main(String[] args) {
        String str = "hello words hello t tu tu tu tu";
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }

        Set set = map.keySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            key = (String) i.next();
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
        }
    }
}
