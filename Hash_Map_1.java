//Lorcan Murray
//Hash Map Implementation with Linear Probing
public class Hash_Map_1 {
    Hash_Value[] hash_arr;
    int capacity;
    int size;
    Hash_Value delete;

    // constructor
    public Hash_Map_1() {
        capacity = 10;
        size = 0;
        hash_arr = new Hash_Value[capacity];
        delete = new Hash_Value(-1, -1);
    }

    // hash function
   public int hashCode(int key_code) {
        return key_code % capacity;
    }

    // insert key-value pair
   public void insertNode(int key, int value) {
        Hash_Value new_value = new Hash_Value(key, value);
        int hash_index = hashCode(key);//get the hash index

        while (hash_arr[hash_index] != null && hash_arr[hash_index].key != key && hash_arr[hash_index].key != -1) {
            hash_index++;
            hash_index %= capacity;// giving circular nature to hash table by increasing this value moving up the potential values
        }

        if (hash_arr[hash_index] == null || hash_arr[hash_index].key == -1)
            size++;
        hash_arr[hash_index] = new_value;// insert new node
    }

    // delete key-value pair    
    public int deleteNode(int key) {
        int hash_index = hashCode(key);

        while (hash_arr[hash_index] != null) {
            if (hash_arr[hash_index].key == key) {// key found
                Hash_Value temp = hash_arr[hash_index];// store the value to be deleted
                hash_arr[hash_index] = delete;// assign a delete node
                size--;// decrease size
                return temp.value;// return deleted value
            }
            hash_index++;// move to next index
            hash_index %= capacity;// circular nature
        }

        return -1;// return -1 if not found
    }
// this method is to delete the value by keycode or key, this is the purpose of the delete hash_value object
    // get value by key
   public int Search(int key) {
        int hash_index = hashCode(key);
        int counter = 0;

        while (hash_arr[hash_index] != null) {
            if (counter++ > capacity)
                return -1;// to avoid infinite loop

            if (hash_arr[hash_index].key == key)
                return hash_arr[hash_index].value;
            hash_index++;
            hash_index %= capacity;
        }

        return -1;// return -1 if not found
    }

    // size of map
    public int sizeofMap() {
        return size;
    }
// load factor calculation
   public double loadfactor() {
        return (double)size / capacity;
    }
    // rehash calculation based on load factor thresholds
      public boolean calculate_rehash() {
        double loadFactor_SF = (25.0 / 100.0) * capacity+(50.0 / 100.0) * capacity; // 0.25 * capacity + 0.50 * capacity = 0.75 * capacity
        if (size >= loadFactor_SF) {
            return true; // Indicates rehashing is needed
        } else {
            return false; // No rehashing needed
        }
    }
    // resizing the hash map
    public void resizing() {
        if (calculate_rehash()) {
            capacity = capacity * 2;
        }   
        else {
            capacity = capacity;
        }
    }
    // Shows the key-value pairs in the map
    // tried to do a string representation but kept getting null pointer exception
    public void display()
    {
       for (int i = 0; i < hash_arr.length; i++) {
        if (hash_arr[i] != null && hash_arr[i].key != -1) {
            System.out.println("Key-value pairs{"+"key='"+hash_arr[i].key+", value="+hash_arr[i].value+'\''+ '}');            
        }
    } 
    if( size==0)              
    System.out.println("No key-value pairs found")  ;// to handle empty map case
    
    }
    
}
//used geeksforgeeks as reference https://www.geeksforgeeks.org/linear-probing-in-hashing-in-java/