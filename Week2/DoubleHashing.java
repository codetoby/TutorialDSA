package Week2;

public class DoubleHashing {

    private static class Entry {

        String key;
        int value;

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

    public DoubleHashing() {
        entrys = new Entry[N];
    }

    public void put(String key, int value) {
        int hash = hash(key);
        int stepSize = secondaryHash(key);
        int initialHash = -1;
        while (entrys[hash] != null) {
            if (initialHash == -1) {
                initialHash = hash;
            } else if (initialHash == hash) {
                return;
            }
            hash = (hash + stepSize) % N;
        }

        Entry entry = new Entry(key, value);
        entrys[hash] = entry;
    }

    public Entry get(String key) {

        int hash = hash(key);
        int stepSize = secondaryHash(key);
        int initialHash = -1;

        while (entrys[hash] != null) {

            if (entrys[hash].key.equals(key)) {
                return entrys[hash];
            }

            if (initialHash == -1) {
                initialHash = hash; 
            } else if (hash == initialHash) {
                return null;
            }

            hash = (hash + stepSize) % N;
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

    private int secondaryHash(String key) {
        int hashValue = 1 + (key.hashCode() % (N - 1));
        return (hashValue < 0) ? hashValue + N - 1 : hashValue;
    }

    public static void main(String[] args) {
        DoubleHashing map = new DoubleHashing();
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
