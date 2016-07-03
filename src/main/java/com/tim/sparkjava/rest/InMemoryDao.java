package com.tim.sparkjava.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by tim on 03/07/16.
 */
public class InMemoryDao<V> implements Dao<V> {

    private final Map<Integer, V> map;
    private final AtomicInteger index = new AtomicInteger();
    private final Logger LOGGER = LoggerFactory.getLogger(InMemoryDao.class);

    public InMemoryDao() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public V get(int i) {
        return map.get(i);
    }

    @Override
    public List<V> get() {
        return map.keySet().stream()
                .sorted()
                .map(i -> map.get(i))
                .collect(Collectors.toList());
    }

    @Override
    public int put(V item) {
        final int key = index.getAndIncrement();
        map.put(key, item);
        LOGGER.info("saved item {} with id {}", item, key);
        return key;
    }
}
