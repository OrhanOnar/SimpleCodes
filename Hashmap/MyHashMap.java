package odev3;


public class MyHashMap<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;          
    private int m;          
    private Key[] keys;      
    private Value[] vals;    


   
    public MyHashMap() {
        this(INIT_CAPACITY);
    }

    
    public MyHashMap(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

   
    public int size() {
        return n;
    }

   
    public boolean isEmpty() {
        return size() == 0;
    }

   
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("key yok");
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
    	MyHashMap<Key, Value> temp = new MyHashMap<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

   
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("ilk girdi null");

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    
    public Value get(Key key) {
        if (key == null) 	
        	throw new IllegalArgumentException("keye karsilik gelen value yok");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

  
    public void delete(Key key) {
        if (key == null) 
        	throw new IllegalArgumentException("silinecek deger yok");
        if (!contains(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        if (n > 0 && n <= m/8) resize(m/2);

        assert check();
    }

  
   

  
    private boolean check() {

       
        if (m < 2*n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (keys[i] == null) continue;
            else if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }


  
 
}