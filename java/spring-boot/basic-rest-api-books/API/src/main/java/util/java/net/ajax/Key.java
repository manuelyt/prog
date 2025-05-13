package util.java.net.ajax;

public class Key<K, V>{

    K key;
    V value;

    public Key() {

    }

    public Key(K key, V  value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }
    public K getKey() {
        return key;
    }

}