package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


/**
 * Permet d'écrire dans un nouveau fichier les symptoms obtenus grace
 * à AnalyticsCounter
 */
public class AnalyticsWriter {

    /**
     * Permet d'écrire dans un nouveau fichier les symptoms obtenus grace
     * à AnalyticsCounter
     * @param sorted, treemap contenant l'intégralité des symptoms et permettant
     * de les trier par ordre alphabétique
     * @throws IOException
     */
    public static void writeSymptoms(TreeMap<String, Integer> sorted) throws IOException {
        //création d'un fichier ou l'on va écrire les résultats de la lecture des symptoms
        FileWriter writer = new FileWriter ("results.out");

        //On utilise la treemap créé précedemment pour avoir les symptoms écrit dans l'ordre alphabétique
        for (Map.Entry<String, Integer> entry: sorted.entrySet()) {
            writer.write(entry.getKey() + " = " + entry.getValue() + "\n");
        }
        writer.close();
    }
}
