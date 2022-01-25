package models;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EquipmentMap {
    public static HashMap<String, String> EquimentMap() throws IOException {
        Path fileName = Path.of("C:/Users/Olivier/Documents/GitHub/Diamond_Aloha/MSPR-Go-Securi/list.txt" );
        String[] fileString = Files.readString(fileName).split("\n");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < fileString.length; i++) {
            String[] lineString = fileString[i].split( " ", 1);
            map.put(lineString[0], lineString[1]);
        }
        return map;
    }
}
