package com.abach42.designpatterns.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    @DisplayName("Target of 'ApiAdapter' should result in expected 'Record'")
    public void testApiAdapter() {
        ApiAdaptee<String> fakeApiAdaptee = () -> "{\"id\": 42, \"name\": \"John Doe\"}";
        Target<Record> target = new ApiAdapter(fakeApiAdaptee);
        Record actualRecord = target.fetchData();

        Record expectedRecord = new Target.Record(42, "John Doe");

        assertEquals(expectedRecord, actualRecord);
    }

    @Test
    @DisplayName("Target of 'StreamAdapter' should result in expected 'Record'")
    public void testStreamAdapter() {
        StreamAdaptee<Stream<String>> fakeStreamAdaptee = () -> Stream.of("42,John Doe");
        Target<Record> target = new StreamAdapter(fakeStreamAdaptee);
        Record actualRecord = target.fetchData();

        Record expectedRecord = new Target.Record(42, "John Doe");

        assertEquals(expectedRecord, actualRecord);
    }
}
