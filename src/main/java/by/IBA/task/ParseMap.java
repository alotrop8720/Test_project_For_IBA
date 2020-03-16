package by.IBA.task;

import java.util.*;

/**
 * Class for save key-value with duplicate keys.
 * @param <K> - keys type.
 * @param <V> - keys value.
 */
public class ParseMap<K,V>{
    List<V> values = new ArrayList<>();
    List<K> keys = new ArrayList<>();

    public int size() {
        return keys.size();
    }

    public boolean put(K key, V value) {
        values.add(value);
        keys.add(key);
        return true;
    }

    public List<K> getKeys(){
        return keys;
    }
}
