class LRUCache {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    ArrayList<Pair> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }

    public int get(int key) {

        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).key == key) {

                Pair p = list.get(i);

                // remove from current position
                list.remove(i);

                // add at end = most recently used
                list.add(p);

                return p.value;
            }
        }

        return -1;
    }

    public void put(int key, int value) {

        // Check if key already exists
        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).key == key) {

                // remove old pair
                list.remove(i);

                // add updated pair at end
                list.add(new Pair(key, value));

                return;
            }
        }

        // If cache is full
        if(list.size() == capacity) {

            // Remove least recently used
            list.remove(0);
        }

        // Add new pair at end
        list.add(new Pair(key, value));
    }
}