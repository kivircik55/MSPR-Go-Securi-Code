package com.example.mspr_go_securi_code_android;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAgentsMapToAndroidThread implements Runnable {

    public static ArrayList<String> AgentListPublic;
    @Override
    public void run() {
        //Lien vers le fichier contenant la liste des agents
        String path = "https://github.com/kivircik55/MSPR-Go-Securi/blob/main/staff.txt";
        ArrayList<String> AgentsList = new ArrayList<>();
        String[] agentsTab;

        try {
            //Initialisation d'un objet representant le DOM html
            Document doc = Jsoup.connect(path).get();

            //Reccuperer de l'objet contenant la liste des agents
            Element Agents = doc.select("#repo-content-pjax-container > div > div.Box.mt-3.position-relative > div.Box-body.p-0.blob-wrapper.data.type-text.gist-border-0 > div > table > tbody").first();

            //reccuperation de la liste des agents et separations de chaque mot en fonction de l'espace
            agentsTab = Agents.text().split(" ");

            //ajout de la liste d'agent dans un tableau
            for (String a : agentsTab)
                AgentsList.add(a);
            AgentListPublic = AgentsList;
        }
        catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}