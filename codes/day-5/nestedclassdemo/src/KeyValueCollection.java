
import java.util.Set;
import java.util.TreeSet;

public class KeyValueCollection<K, V> {
    public class KeyValuePair {
        private final K key;
        private final V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private final Set<KeyValuePair> items;

    public KeyValueCollection() {
        this.items = new TreeSet<>();
    }

    public Set<KeyValuePair> getItems() {
        return this.items;
    }

    public boolean addItem(K key, V value) {
        KeyValuePair keyValuePair = new KeyValuePair(key, value);
        return items.add(keyValuePair);
    }
}
