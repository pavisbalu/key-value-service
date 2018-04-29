package in.ashwanthkumar.restvideos.module2.inMemory;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static final Map<String,String> storeValue=new HashMap<String,String>();

    public Map<String, String> setStoreValue(String Key, String value) {
       storeValue.put(Key, value);
       return storeValue;
    }

    public String getStoreValue(String key) {
        return storeValue.get(key);
    }
}
