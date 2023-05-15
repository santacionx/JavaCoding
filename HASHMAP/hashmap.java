package HASHMAP;

import java.util.*;

class node<k, v> {
    k key;
    v value;
    node<k, v> next;

    node(k key, v value) {
        this.key = key;
        this.value = value;
        next = null;
    }

}

public class hashmap<k, v> {
    ArrayList<node<k, v>> buckets;
    int count, nbuckets;

    hashmap() {

        buckets = new ArrayList<>();
        nbuckets = 20;
        for (int i = 0; i <= nbuckets; i++) {
            buckets.add(null);
        }

    }

    private int getBucketIndex(k key) {
        // hash function -> hash code + compression to place into bucked
        int hcode = key.hashCode();
        int compress = hcode % nbuckets;
        return compress;
    }

    public void insert(k key, v value) {
        int BucketIndex = getBucketIndex(key);
        // search key is already present in list
        node<k, v> head = buckets.get(BucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
            }
            head = head.next;

        }
        // create a new node if no element
        head = buckets.get(BucketIndex);
        node<k, v> newnode = new node<>(key, value);
        newnode.next = head;

    }

    public static void main(String[] args) {

    }
}
