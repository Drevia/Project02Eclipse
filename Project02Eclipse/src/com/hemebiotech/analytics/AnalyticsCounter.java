package com.hemebiotech.analytics;

import java.util.*;

/**
 * Class contenant la méthode s'occupant de compter les symptoms qui ont été lus dans readSymptomsDataFromFile
 */
public class AnalyticsCounter {
    //variable indiquant le chemin du fichier a lire
    private final ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");

    /**
     * @return TreeMap des symptoms contenus dans symptomReader
     */
    public TreeMap<String, Integer> countSymptoms() {
        final TreeMap<String, Integer> symptomsMap = new TreeMap<>();
        for (String s : symptomReader.getSymptoms()) {
            symptomsMap.merge(s, 1, Integer::sum);
        }
        return symptomsMap;
    }
}
