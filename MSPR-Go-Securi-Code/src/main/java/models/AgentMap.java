package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class AgentMap {

    public static HashMap<String, String> agentMap() throws IOException {
        Path fileName = Path.of("C:\\Users\\tlepo\\Documents\\GitHub\\MSPR-Go-Securi\\staff.txt" );
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

    public void printAgentMap() throws IOException {
        HashMap<String, String> maptoprint = agentMap();
        maptoprint.forEach((key, value) -> System.out.println(key + " " + value));
    }

}
