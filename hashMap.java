public class hashMap {
    Hash_Value[] hash_arr;
    int capacity;
    int size;
    Hash_Value delete;

    // constructor
    public hashMap() {
        capacity = 10;
        size = 0;
        hash_arr = new Hash_Value[capacity];
        delete = new Hash_Value(-1, -1);
    }

    // hash function
    int hashCode(int key_code) {
        return key_code % capacity;
    }

    // insert key-value pair
    void insertNode(int key, int value) {
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
    int deleteNode(int key) {
        int hash_index = hashCode(key);

        while (hash_arr[hash_index] != null) {
            if (hash_arr[hash_index].key == key) {
                Hash_Value temp = hash_arr[hash_index];
                hash_arr[hash_index] = delete;
                size--;
                return temp.value;
            }
            hash_index++;
            hash_index %= capacity;// circular nature
        }

        return -1;// return -1 if not found
    }
// this method is to delete the value by keycode or key, this is the purpose of the delete hash_value object
    // get value by key
    int Search(int key) {
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
    int sizeofMap() {
        return size;
    }


    // display key-value pairs
    public String toString()
    {
       for (int i = 0; i < capacity; i++) {
        if (hash_arr[i] != null && hash_arr[i].key != -1) {
            return "Key-value pairs{"+
            "key='"+hash_arr[i].key+'\''+
            ", value="+hash_arr[i].value+'\''+  
            '}';
        }
    }               
    return "No key-value pairs found";
    }

    public static void main(String[] args) {
        hashMap h = new hashMap();
        h.insertNode(1, 1);
        h.insertNode(2, 2);
        h.insertNode(2, 3);
        System.out.println(h.toString());
        System.out.println(h.sizeofMap());
        System.out.println(h.deleteNode(2));
        System.out.println(h.Search(2));
    }
}