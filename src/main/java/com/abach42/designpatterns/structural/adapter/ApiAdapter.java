package com.abach42.designpatterns.structural.adapter;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.StringReader;

public class ApiAdapter implements Target<Record> {

    private final ApiAdaptee<String> apiAdaptee;

    public ApiAdapter(ApiAdaptee<String> apiAdaptee) {
        this.apiAdaptee = apiAdaptee;
    }

    @Override
    public Record fetchData() {
        String jsonString = apiAdaptee.fetchDataFromApi();

        try (JsonReader jsonReader = Json.createReader(new StringReader(jsonString))) {
            JsonObject jsonObject = jsonReader.readObject();

            int id = jsonObject.getInt("id");
            String name = jsonObject.getString("name");

            return new Record(id, name);
        } catch (Exception e) {
            //todo log error
            e.printStackTrace();
        }

        return new Record(null, null);
    }
}
