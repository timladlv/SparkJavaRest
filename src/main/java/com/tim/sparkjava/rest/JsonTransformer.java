package com.tim.sparkjava.rest;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by tim on 03/07/16.
 */

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}