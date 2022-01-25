package models;

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

        Agent agent = new Agent("toto", "tata", "gardien", "azerty", liste);

        System.out.println(agent.toString());
        agent.generateAgentFile(map);
    }
}