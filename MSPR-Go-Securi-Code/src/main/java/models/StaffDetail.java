package models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StaffDetail {
    /**
     *
     * @param stafflist
     * @param equipmentMap
     * @return
     * @throws IOException
     */
    public static boolean agentDetail (List stafflist, HashMap<String,String> equipmentMap) throws IOException {
    for (int i = 0; i < stafflist.size(); i++){
        Object row = stafflist.get(i);
        Path fileName = Path.of("C:/Users/Olivier/Documents/GitHub/Diamond_Aloha/MSPR-Go-Securi/".concat((String) row).concat(".txt"));
        agentCreation(fileName, (String) row, equipmentMap);
    }
    return true;
    }

    public static void agentCreation(Path path, String login, HashMap<String,String> equipmentMap) throws IOException {
        String[] fileString = Files.readString(path).split("\\r?\\n");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, fileString);
        List<String> equipment = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            String row = list.get(i);
            if(i>4){
                equipment.add(row);
            }
        }
       Agent agent = new Agent(list.get(0), list.get(1), list.get(2),list.get(3), equipment);
        agent.setLogin(login);
        System.out.println("olii "+login);
        System.out.println("tokoro "+agent.getLogin());
        agent.generateAgentFile(equipmentMap);
    }
}
