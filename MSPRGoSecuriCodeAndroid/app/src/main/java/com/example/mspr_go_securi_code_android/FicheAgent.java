package com.example.mspr_go_securi_code_android;

import static com.example.mspr_go_securi_code_android.FileMapAndroid.AgentRecup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FicheAgent extends AppCompatActivity {

    TextView fullName, role;
    ListView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fiche_agent);

        fullName = findViewById(R.id.textFullName);
        role = findViewById(R.id.textRole);
        itemList = (ListView)findViewById(R.id.listAgent);

        Intent intent = getIntent();

        Agent agent = (Agent)intent.getSerializableExtra("agent");
        String AgentFirstname = agent.getFirstName();
        String AgentUsername = AgentFirstname.charAt(0) + agent.getLastName();
        //Appelle de la fonction
        String Tonton = AgentRecup("cberthier");

        fullName.setText(agent.getFirstName() + " " + agent.getLastName());
        role.setText(agent.getRole());

        List<String> list = agent.getItemList();

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , list);
        itemList.setAdapter(arrayAdapter);



    }
}