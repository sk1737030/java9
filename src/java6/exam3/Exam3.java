package java6.exam3;

import java.util.ArrayList;
import java.util.List;

public class Exam3<K, V> {

    private List<Entry<K, V>> entry;

    public Exam3() {
        this.entry = new ArrayList<>();
    }

    public Entry<K, V> put(K k, V v) {

        int i = findIndex(k);
        if (i > -1) {
            return entry.set(i, new Entry<>(k, v));
        } else {
            Entry<K, V> tempEntry = new Entry<>(k, v);
            entry.add(tempEntry);

            return tempEntry;
        }
    }

    public Entry<K, V> getEntry(K k) {
        return entry.get(findIndex(k));
    }

    public Entry<K, V> remove(K k) {
        int i = findIndex(k);
        if (i == -1) {
            return null;
        }
        return entry.remove(findIndex(k));
    }

    private int findIndex(K k) {
        for (int i = 0; i < entry.size(); i++) {
            Entry<K, V> tempEntry = entry.get(i);
            if (tempEntry.getKey().equals(k)) {
                return i;
            }
        }
        return -1;
    }
}
