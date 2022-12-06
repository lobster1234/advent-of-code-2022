package org.lobster1234.aoc2022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Utils class to hold common methods like parsing files etc.
 */
public class Utils {

    /**
     * Read a file and return a list of strings representing each line.
     * @param file The name of the file.
     * @return list of strings, one string for each line in the file
     * NOTE: I am eating the exception here and returning an empty list.
     */
    public static List<String> readFile(String file){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(Utils.class.getClassLoader().getResource(file).toURI())))){
            return reader.lines().toList();
        }catch(Exception e){
            System.out.println("Exception " + e.getMessage());
            return List.of();
        }
    }

}
