package com.imjava.dbshow.dbutils;

public class IndexData {
    String year;
    Double data;
    String country;
    String indexName;

    public IndexData(String year, Double data, String country, String indexName) {
        this.year = year;
        this.data = data;
        this.country = country;
        this.indexName = indexName;
    }

    public String getString() {
        return String.format("year: %s, data: %f, country: %s, index: %s", year, data, country, indexName);
    }
}
