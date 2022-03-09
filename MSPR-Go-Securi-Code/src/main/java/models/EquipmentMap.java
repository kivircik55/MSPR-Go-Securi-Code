package models;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EquipmentMap {

    /**
     * Parse and deals with the equipment list in a more readable format
     * @return
     * @throws IOException
     */

    public static HashMap<String, String> parseEquipmentFromFile() throws IOException {
        Path fileName = Path.of("/home/thibault/Documents/MSPR-Go-Securi-Text/MSPR-Go-Securi/list.txt" );
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
        HashMap<String, String> maptoprint = parseEquipmentFromFile();
        maptoprint.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
