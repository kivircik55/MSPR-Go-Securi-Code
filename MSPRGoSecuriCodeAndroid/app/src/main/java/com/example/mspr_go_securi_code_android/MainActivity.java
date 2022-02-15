package com.example.mspr_go_securi_code_android;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> agents = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        ListAgentsMapToAndroidThread f = new ListAgentsMapToAndroidThread();
        Thread thread = new Thread(f);
        thread.start();
        try {
            thread.join();
            agents = ListAgentsMapToAndroidThread.AgentListPublic;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ArrayList<String> a = MapListAgent();
        //System.out.println(a);

        ListView listAgent = (ListView)findViewById(R.id.listAgent);
        //Agent a1 = new Agent("Berthier", "Corinne", "Surveillance entrepôt", "pmNd1ldFE7WTk", Arrays.asList(new String[]{"kit", "lampe", "lacrymo"}));
        //Agent a2 = new Agent("Lepoivre", "Thibault", "Chef d'equipe", "pmNd1ldFE7WTk", Arrays.asList(new String[]{"brassard, Brassard de sécurité", "talky Talkies walkies", "lampe Lampe Torche", "kit Kit oreillette", "taser Tasers"}));
        //Agent a3 = new Agent("Splauding", "Henri", "Agent spécial", "pmNd1ldFE7WTk", Arrays.asList(new String[]{"kit", "lampe", "lacrymo", "cyno", "Bandeau agent cynophile"}));
        //ArrayList<Agent> agents = new ArrayList<Agent>();
        //agents.add(a1);
        //agents.add(a2);
        //agents.add(a3);

        ArrayAdapter<String> arrayAdapter
            = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , agents);
        listAgent.setAdapter(arrayAdapter);

        listAgent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listAgent.getItemAtPosition(position);
                String AgentUsername = (String) o;
                Intent intent = new Intent (MainActivity.this, FicheAgent.class);
                intent.putExtra("AgentUsername", AgentUsername);
                startActivity(intent);
            }
        });
    }
}