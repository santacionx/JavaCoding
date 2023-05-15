package HASHMAP;

import java.util.*;

// linked list to store inside bucket array  (collision avoidance )
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

// generic class
class Mapp<k, v> {
    // note : array can't store generic @ compile time so use arraylist
    // array list / bucket array stores in the form of seperate chaining (linked
    // list used intenally if collision occurs )
    // so class node linked list created
    // size of bucket default set to 20

    ArrayList<node<k, v>> bucket;
    int count, nbuckets;

    Mapp() {
        bucket = new ArrayList<>();
        nbuckets = 20;
        for (int i = 0; i < nbuckets; i++) {
            bucket.add(null);
        }
    }

    // to insert string key into array particular index use hash function ex: a[0]
    // place the value similar action for strings we need

    public double loadFactor() {
        return (1.0 * count) / nbuckets;
    }

    private void rehash() {
        System.out.println("Rehashing buckets " + nbuckets + " size " + count);
        ArrayList<node<k, v>> temp = bucket;
        bucket = new ArrayList<>();
        for (int i = 0; i < 2 * nbuckets; i++) {
            bucket.add(null);
        }
        count = 0;
        nbuckets *= 2;
        for (int i = 0; i < temp.size(); i++) {
            node<k, v> head = temp.get(i);
            while (head != null) {
                k key = head.key;
                v value = head.value;
                int newBucketIndex = getBucketIndex(key); // Get the new bucket index for rehashed key
                node<k, v> newNode = new node<>(key, value); // Create a new node
                newNode.next = bucket.get(newBucketIndex); // Attach the new node to the head of the linked list
                bucket.set(newBucketIndex, newNode); // Set the new node as the head of the linked list
                count++;
                head = head.next;
            }
        }
    }

    private int getBucketIndex(k key) {
        int hcode = key.hashCode();
        int index = hcode % nbuckets;
        // Handle negative hash codes
        index = index < 0 ? index + nbuckets : index;
        return index;
    }

    public void insert(k key, v value) {
        // ask the getbucketindex to get the index to store the key
        int BucketIndex = getBucketIndex(key);
        // search key is already present in linked list that is inside the bucket
        // access the bucketindex say ex: a[0] traverse inside the a[0] linked list to
        // check if key present : true then place the value again;
        // see bucket/arraylist holds node<k,v> type .get return the node<k,v> type arry
        // this was i got confused how integer returned array holds the node<k,v> head
        // but array return is **** node type ****

        node<k, v> head = bucket.get(BucketIndex);
        // array index
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;

        }
        // get the a[0] once i couldnt find the search till null again make the head
        // point to the initial index
        // say a[0] contains no key or linked list then
        // create list/node attach newnode next the head
        // place this newnode into the a[0]
        head = bucket.get(BucketIndex);
        node<k, v> newnode = new node<>(key, value);
        newnode.next = head;
        // *** this one i forgot so output was abc1 null and so on.....
        bucket.set(BucketIndex, newnode);
        count++;

        // load factor = n/b n: number of entries b:bucket size
        // load factor < 0.7
        double loadFactor = (1.0 * count) / nbuckets;
        if (loadFactor > 0.7) {
            rehash();
        }

    }

    public int size() {
        return count;
    }

    public v removeKey(k key) {
        int BucketIndex = getBucketIndex(key);
        node<k, v> head = bucket.get(BucketIndex);
        node<k, v> prev = null;
        // array index
        while (head != null) {
            if (head.key.equals(key)) {
                count--;
                // if only 1 node
                if (prev == null) {
                    bucket.set(BucketIndex, head.next);

                } else {

                    prev.next = head.next;
                    return head.value;
                }
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public v GetValue(k key) {
        int BucketIndex = getBucketIndex(key);
        node<k, v> head = bucket.get(BucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // each bucket index has placed o(n/b): load factor =n/b n: number of entries
    // b:bucket size
    // load factor < 0.7 maintain always;
    // only thing i can change is bucket size
    // every bucket index has const # entries this o(1) ensure to to this rehashing
    // if load factor !<=0.7 the rehasing increase the bucket size 2 * original size
    // copying doesnt help after rehasing linked list place the particular index
    // ex: abc: 21%20 ->1 def: 41 %20 -> 1
    // after rehasing bucketsize : 40 ex: abc: 21%40 ->21 def: 41 %40 -> 1 so this
    // is why we should not copy
    // thus insert delete search O(1)

}

public class hashmap {
    public static void main(String[] args) {
        Mapp<String, Integer> mapp = new Mapp<>();
        for (int i = 0; i < 20; i++) {
            mapp.insert("abc" + i, i + 1);
            System.out.println("i = " + i + " loadFactor: " + mapp.loadFactor());
        }
        mapp.removeKey("abc3");
        mapp.removeKey("abc4");
        System.out.println("---------------------------------");
        for (int i = 0; i < 20; i++) {
            System.out.println("abc" + i + " " + mapp.GetValue("abc" + i));
        }
    }
}
// output
// i = 0 loadFactor: 0.05
// i = 1 loadFactor: 0.1
// i = 2 loadFactor: 0.15
// i = 3 loadFactor: 0.2
// i = 4 loadFactor: 0.25
// i = 5 loadFactor: 0.3
// i = 6 loadFactor: 0.35
// i = 7 loadFactor: 0.4
// i = 8 loadFactor: 0.45
// i = 9 loadFactor: 0.5
// i = 10 loadFactor: 0.55
// i = 11 loadFactor: 0.6
// i = 12 loadFactor: 0.65
// i = 13 loadFactor: 0.7
// Rehashing buckets 20 size 15
// i = 14 loadFactor: 0.375
// i = 15 loadFactor: 0.4
// i = 16 loadFactor: 0.425
// i = 17 loadFactor: 0.45
// i = 18 loadFactor: 0.475
// i = 19 loadFactor: 0.5
// ---------------------------------
// abc0 1
// abc1 2
// abc2 3
// abc3 null
// abc4 null
// abc5 6
// abc6 7
// abc7 8
// abc8 9
// abc9 10
// abc10 11
// abc11 12
// abc12 13
// abc13 14
// abc14 15
// abc15 16
// abc16 17
// abc17 18
// abc18 19
// abc19 20