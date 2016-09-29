package org.apache.cassandra.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yasuharu on 2016/09/29.
 */
public class LinkedHashCache<K, V> extends LinkedHashMap<K, V>
{
    protected final int limit;

    public LinkedHashCache(int limit, int capacity, boolean lru) {
        super(capacity, 0.75F, lru);
        this.limit = limit;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}
