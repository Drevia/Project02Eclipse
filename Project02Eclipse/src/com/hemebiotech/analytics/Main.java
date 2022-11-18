package com.hemebiotech.analytics;


import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception
    {
        AnalyticsCounter counter = new AnalyticsCounter();
        TreeMap<String, Integer> countedSymptoms = counter.countSymptoms();
        AnalyticsWriter.writeSymptoms(countedSymptoms);
    }
}