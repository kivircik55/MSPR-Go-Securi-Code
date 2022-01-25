package models;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EquipmentMap {
    public static HashMap<String, String> equipmentMap() throws IOException {
        Path fileName = Path.of("C:/Users/Olivier/Documents/GitHub/Diamond_Aloha/MSPR-Go-Securi/list.txt" );
        String[] fileString = Files.readString(fileName).split("\\r?\\n");
        HashMap<String, String> map = new HashMap<>();
        for (String s : fileString) {
            String[] lineString = s.split(" ");
            StringBuilder name = new StringBuilder();
            for (int j = 1; j < lineString.length; j++) {
                name.append(lineString[j]).append(" ");
            }
            map.put(lineString[0], name.toString());
        }
        return map;
    }

    public void printEquimentMap() throws IOException {
        HashMap<String, String> maptoprint = equipmentMap();
        maptoprint.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
