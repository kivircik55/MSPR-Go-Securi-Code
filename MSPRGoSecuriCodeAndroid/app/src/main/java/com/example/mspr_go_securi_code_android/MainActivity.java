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

    //Création et initialisation d'un tableau qui possedera la liste de noms des agents
    ArrayList<String> agents = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        //reccuperation notre vue principal
        setContentView(R.layout.activity_main);

        //creation et instanciation d'un thread permettant l'appel de notre code mis dans le run du fichier ListAgentMapToAndroidThread
        ListAgentsMapToAndroidThread f = new ListAgentsMapToAndroidThread();
        Thread thread = new Thread(f);
        thread.start();
        try {
            thread.join(); //permet de reccuperer la liste apres l'execution du thread
            agents = ListAgentsMapToAndroidThread.AgentListPublic;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //liaision de la listView du layout a notre code
        ListView listAgent = (ListView)findViewById(R.id.listAgent);

        //creation d'un tableau adapter pour le listView
        ArrayAdapter<String> arrayAdapter
            = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , agents);

        //mise du tableau dans la listView
        listAgent.setAdapter(arrayAdapter);

        //evenement onClick
        listAgent.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //reccuperation de l'item a la position cliquer dessus
                Object o = listAgent.getItemAtPosition(position);
                String AgentUsername = (String) o;

                //creation et initialisation d'un objet intent
                Intent intent = new Intent (MainActivity.this, FicheAgent.class);
                //envoi du nom d'utilisateur selectionner dans la prochaine vue
                intent.putExtra("AgentUsername", AgentUsername);
                startActivity(intent);
            }
        });
    }
}