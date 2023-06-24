package org.example;


class Entry {
    String key;
    String value;
    Entry next;

    Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int SIZE = 16;
    Entry entries[] = new Entry[SIZE];

    public void put(String key, String value) {
        int bucket = Math.abs(key.hashCode() % SIZE);
        if (entries[bucket] == null) {
            entries[bucket] = new Entry(key, value);
        } else {
            if (entries[bucket] != null) {
                Entry ptr = entries[bucket];
                while (ptr.next != null) {
                    if (ptr.key.equals(key)) {
                        break;
                    }
                    ptr = ptr.next;
                }
                if (ptr.key.equals(key)) {
                    ptr.value = value;
                } else {
                    ptr.next = new Entry(key, value);
                }
            }
        }
    }

    public String get(String key) {
        int bucket = Math.abs(key.hashCode() % SIZE);
        Entry ptr = entries[bucket];
        while (ptr != null) {
            if (ptr.key.equals(key)) {
                return ptr.value;
            }
            ptr = ptr.next;
        }
        return null;
    }

}

public class App {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Sriram", "Backend");
        map.put("Sriram", "Backend-2");
        map.put("Bharani", "Frontend");

        System.out.println(map.get("Sriram"));
    }
}
