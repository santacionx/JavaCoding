package HASHMAP;

import java.util.*;

public class removeduplicates {
    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 3, 4, 3, 5, 5, 6 };
        ArrayList<Integer> out = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                continue;
            }
            out.add(a[i]);
            map.put(a[i], true);
        }
        System.err.println(out);

    }
}
// o/p
// [1, 2, 3, 4, 5, 6]