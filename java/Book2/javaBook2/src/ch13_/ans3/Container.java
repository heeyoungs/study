package ch13_.ans3;

public class Container<K, V> {
    private K k;
    private V v;
    void set(K k,V v){
        this.k = k;
        this.v = v;
    }
    K getKey(){
        return k;
    }
    V getValue(){
        return v;
    }
}
