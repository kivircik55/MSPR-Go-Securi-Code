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
            Path fileName = Path.of("/home/thibault/Documents/MSPR-Go-Securi-Text/MSPR-Go-Securi/".concat((String) row).concat(".txt"));
            agentCreation(i+1,fileName, (String) row, equipmentMap);
        }
    return true;
    }

    public static void agentCreation(int id, Path path, String login, HashMap<String,String> equipmentMap) throws IOException {
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

        AgentThread agentThread = new AgentThread(id, equipmentMap, agent);
        Thread thread = new Thread(agentThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*System.out.println("olii "+login);
        System.out.println("tokoro "+agent.getLogin());
        agent.generateAgentFile(equipmentMap);*/
    }
}
