package sourcecode.hashtable;

public class HashTable {
    private int tableSize;
    private Node[] table;

    // 생성자
    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new Node[tableSize];
        for(int i=0;i<tableSize;i++){
            table[i] = new Node();
        }
    }

    // 삽입
    public void SHT_Set(int key, String value) {
        int address = SHT_Hash(key, tableSize);
        table[address].key = key;
        table[address].value = value;
    }

    // 얻기
    public String SHT_Get(int key) {
        int address = SHT_Hash(key, tableSize);
        return table[address].value;
    }

    // 초기화
    public void SHT_DestroyHashTable() {
        this.tableSize = 0;
        this.table = null;
    }

    // 해싱
    private int SHT_Hash(int key, int tableSize) {
        return key % tableSize;
    }
}
