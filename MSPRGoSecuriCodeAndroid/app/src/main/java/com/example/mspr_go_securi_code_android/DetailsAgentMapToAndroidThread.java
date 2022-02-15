package com.example.mspr_go_securi_code_android;

import static java.lang.Character.isUpperCase;

import android.graphics.drawable.Drawable;
import android.icu.text.CaseMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailsAgentMapToAndroidThread implements Runnable{

    public static String AgentUsername;
    public static Agent Agent;
    private static int i = 0;
    @Override
    public void run() {
        String pathFile = "https://github.com/kivircik55/MSPR-Go-Securi/blob/main/" + AgentUsername + ".txt";

        String[] detailsAgent;

        String lastName = "a";
        String firstName = "a";
        String role = "a";
        String login = "a";
        String password = "a";
        List<String> itemList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(pathFile).get();

            Element Agent = doc.select("#repo-content-pjax-container > div > div.Box.mt-3.position-relative > div.Box-body.p-0.blob-wrapper.data.type-text.gist-border-0 > div > table > tbody").first();

            try{
                for(int i=1; i<Agent.text().length(); i++)
                {
                    Element e = doc.select("td#LC" + i).first();
                    System.out.println(e.text());
                    if(i == 1) {
                        lastName = e.text();
                    }
                    if(i == 2) {
                        firstName = e.text();
                    }
                    if(i == 3) {
                        role = e.text();
                    }
                    if(i == 4) {
                        password = e.text();
                    }
                    if(i > 4) {
                        itemList.add(e.text());
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            this.Agent = new Agent(lastName, firstName, role, password, itemList);
        }
        catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static String getPathImage() {
        String pathImage = "https://github.com/kivircik55/MSPR-Go-Securi/raw/main/" + AgentUsername +".jpg";
        System.out.println(pathImage);
        return pathImage;
    }

}