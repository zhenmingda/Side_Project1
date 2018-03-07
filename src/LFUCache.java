import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by dashu on 2017/1/1.
 */
public class LFUCache {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    TreeMap<Integer, Integer> treeMapForCount = new TreeMap<>();
    int capacitiy;
    int count = 0;

    public LFUCache(int i) {
        capacitiy = i;
    }

    public void set(int key, int value) {
        if (count < capacitiy) {
            Object count1 = treeMapForCount.get(key);
            if (count1 == null) {
                treeMapForCount.put(key, 1);
            }
            treeMap.put(key, value);
            treeMapForCount.put(key, (Integer) count1 + 1);
            count++;
        } else {
           // Collection collection = treeMapForCount.values();
            Iterator iter=treeMapForCount.entrySet().iterator();
            iter.next().;
            treeMap.remove(key);
            treeMap.put(key, value);
        }
    }

    public int get(int key) {
        Object value = treeMap.get(key);
        if (value == null) {
            return -1;
        } else
            return (int) value;
    }
}
