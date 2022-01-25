package models;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EquipmentMap {
    public static HashMap<String, String> EquimentMap(String username) throws IOException {
        Path fileName = Path.of("C:/Users/33614/OneDrive/Documents/GitHub/MSPR-Go-Securi/" + username);
        String[] fileString = Files.readString(fileName).split("\n");
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < fileString.length; i++) {

        }
        return map;
    }
}
