package com.tim.sparkjava.rest;

import java.util.List;

/**
 * Created by tim on 03/07/16.
 */
public interface Dao<T> {
    T get(int i);
    List<T> get();
}
