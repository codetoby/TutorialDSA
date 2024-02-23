package Week2;

public class HashMap {

    private static class Entry {

        String key;
        int value;
        Entry next;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value;
        }

    }

    Entry[] entrys;
    int N = 10;

    public HashMap() {
        entrys = new Entry[N];
    }

    public void put(String key, int value) {
        int hash = hash(key);
        Entry entry = new Entry(key, value);
        Entry hashAtIndex = entrys[hash];
        if (hashAtIndex == null) {
            entrys[hash] = entry;
            return;
        } else if (hashAtIndex.key.equals(key)) {
            hashAtIndex.value = value;
            return;
        }
        Entry current = hashAtIndex;
        while (current.next != null) {
            current = current.next;
        }
        current.next = entry;
        System.out.println("Hi");
    }

    public Entry get(String key) {

        int hash = hash(key);
        Entry hashAtIndex = entrys[hash];

        if (hashAtIndex == null) {
            return null;
        }
        Entry current = hashAtIndex;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;

    }

    private int hash(String key) {
        int hashValue = 0;
        int prime = 31;
        for (int i = 0; i < key.length(); i++) {
            hashValue = (prime * hashValue + key.charAt(i)) % N;
        }
        System.out.println(hashValue);
        return hashValue;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Hello", 0);
        map.put("Iello", 1);
        map.put("Gello", 2);
        map.put("a", 3);
        map.put("b", 4);
        map.put("help", 5);
        map.put("world", 6);
        map.put("orange", 7);
        map.put("melon", 9);

    }

}
