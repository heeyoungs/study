package sourcecode.hashtable;

public class Test {
    public static void main(String[] args) {
        HashTable ht = new HashTable(193);

        ht.SHT_Set(418,"Hello");
        ht.SHT_Set(9,"I'm");
        ht.SHT_Set(27,"Hash");
        ht.SHT_Set(1031,"Table");

        System.out.println("Key:" + 418 + ", "  + "Value:" + ht.SHT_Get(418));
        System.out.println("Key:" + 9 + ", "  + "Value:" + ht.SHT_Get(9));
        System.out.println("Key:" + 27 + ", "  + "Value:" + ht.SHT_Get(27));
        System.out.println("Key:" + 1031 + ", "  + "Value:" + ht.SHT_Get(1031));

        ht.SHT_DestroyHashTable();
    }
}
