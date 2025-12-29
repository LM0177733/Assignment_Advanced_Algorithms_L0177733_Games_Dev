public class HashmapAssignment_2{
 public static void main(String[] args) {
        Hash_Map_1 h = new Hash_Map_1();
        h.insertNode(1, 1);
        h.insertNode(2, 2);
        h.insertNode(3, 3);
    h.display();
        System.out.println(h.sizeofMap());
        System.out.println(h.deleteNode(2));
        System.out.println(h.Search(2));
        System.out.println(h.loadfactor());
        h.resizing();
    }
}