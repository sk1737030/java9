package java6.exam4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exam4<K, V> {
    public class Entry {
        private K k;
        private V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }
    }

    private List<Entry> entry;

    public Exam4(List<Map.Entry<K, V>> entry) {
        this.entry = new ArrayList<Entry>();
    }

    public Entry put(K k, V v) {

        int i = findIndex(k);
        if (i > -1) {
            return entry.set(i, new Entry(k, v));
        } else {
            Entry tempEntry = new Entry(k, v);
            entry.add(tempEntry);

            return tempEntry;
        }
    }

    public Entry getEntry(K k) {
        return entry.get(findIndex(k));
    }

    public Entry remove(K k) {
        int i = findIndex(k);
        if (i == -1) {
            return null;
        }
        return entry.remove(findIndex(k));
    }

    private int findIndex(K k) {
        for (int i = 0; i < entry.size(); i++) {
            Entry tempEntry = entry.get(i);
            if (tempEntry.getKey().equals(k)) {
                return i;
            }
        }
        return -1;
    }
}
