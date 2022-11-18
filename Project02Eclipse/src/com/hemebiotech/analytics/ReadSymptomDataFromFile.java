package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentations de l'interface ISymptomReader pour avoir accés a la fonction getSymptoms
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filepath;

    /**
     * Constructor.
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Enregistre chaque ligne du fichier dans un String. Le string
     * est ensuite ajouté a la liste de String afin d'obtenir tout
     * les symptoms dans une seule variable
     *
     * @return List de String lus des symptoms dans filepath
     */
    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();
        if (filepath != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();
                while (line != null) {
                    //ajout du symptoms lus par le bufferreader dans la list de String créé précedemment
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException e) {
                //on catch la possibilité que le fichier indiqué ne soit pas trouvé
                System.err.println("The path to the find is incorrect or the file is missing");
            } catch (IOException e) {
                //On catch tout autre exceptions de type IOException
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }
        return result;
    }
}