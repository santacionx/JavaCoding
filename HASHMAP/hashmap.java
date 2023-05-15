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
public class hashmap<k, v> {
    // note : array can't store generic @ compile time so use arraylist
    // array list / bucket array stores in the form of seperate chaining (linked
    // list used intenally if collision occurs )
    // so class node linked list created
    // size of bucket default set to 20

    ArrayList<node<k, v>> bucket;
    int count, nbuckets;

    hashmap() {

        bucket = new ArrayList<>();
        // default set bucket size and place all null inside the bucket
        nbuckets = 20;
        for (int i = 0; i <= nbuckets; i++) {
            bucket.add(null);
        }

    }
    // to insert string key into array particular index use hash function ex: a[0]
    // place the value similar action for strings we need

    private int getBucketIndex(k key) {
        // hash function -> hash code + compression to place into bucked
        // hashcode : converts strings into integer
        int hcode = key.hashCode();
        // compress so the key is placed within the bucket/ array size
        int compress = hcode % nbuckets;
        return compress;
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

    }

    public static void main(String[] args) {

    }
}
