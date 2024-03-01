package com.abach42.designpatterns.structural.adapter;

import java.util.stream.Stream;

public class StreamAdapter implements Target<Record> {
    private StreamAdaptee<Stream<String>> streamAdaptee;

    public StreamAdapter(StreamAdaptee<Stream<String>> streamAdaptee) {
        this.streamAdaptee = streamAdaptee;
    }

    @Override
    public Record fetchData() {
        return streamAdaptee.fetchDataFromStream()
            .map(s -> s.split(","))
            .map(arr -> new Record(Integer.parseInt(arr[0]), arr[1]))
            .findFirst()
            .orElse(new Record(null, null));
    }
}