package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("lampe");
        liste.add("talkie");
        liste.add("mousqueton");

        Map<String, String> map = new HashMap<>();
        map.put(liste.get(0), "Lampe Torche");
        map.put(liste.get(1), "Talkie Walkie");
        map.put(liste.get(2), "Mousqueton");

        Agent agent = new Agent("toto", "tata", "gardien", "toto", "azerty", liste);

        System.out.println(agent.toString());
        agent.generateAgentFile(map);

        EquipmentMap e = new EquipmentMap();
        try {
            e.printEquimentMap();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}