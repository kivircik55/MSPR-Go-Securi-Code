package com.example.mspr_go_securi_code_android;
import static com.example.mspr_go_securi_code_android.DetailsAgentMapToAndroidThread.LoadImageFromWebOperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FicheAgent extends AppCompatActivity {

    TextView fullName, role;
    ListView itemList;
    ImageView imageView;
    Agent agent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_fiche_agent);

        fullName = findViewById(R.id.textFullName);
        role = findViewById(R.id.textRole);
        itemList = (ListView)findViewById(R.id.listAgent);
        imageView = (ImageView)findViewById(R.id.imageView);


        Intent intent = getIntent();

        //Appelle de la fonction
        DetailsAgentMapToAndroidThread.AgentUsername = (String)intent.getSerializableExtra("AgentUsername");
        DetailsAgentMapToAndroidThread f = new DetailsAgentMapToAndroidThread();

        Thread thread = new Thread(f);
        thread.start();

        try {
            thread.join();
            agent = DetailsAgentMapToAndroidThread.Agent;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fullName.setText(agent.getFirstName() + " " + agent.getLastName());
        role.setText(agent.getRole());
        imageView.setImageDrawable(LoadImageFromWebOperations());

        List<String> list = agent.getItemList();

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , list);
        itemList.setAdapter(arrayAdapter);



    }
}