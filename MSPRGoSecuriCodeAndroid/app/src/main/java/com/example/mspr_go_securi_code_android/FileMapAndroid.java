package com.example.mspr_go_securi_code_android;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class FileMapAndroid {

    public static String AgentRecup(String AgentUsername){
        String myData = "";
        File myExternalFile = new File("C:\\Users\\tlepo\\Documents\\GitHub\\MSPR-Go-Securi\\"+AgentUsername+".txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(myData);
        return myData;
    }

}