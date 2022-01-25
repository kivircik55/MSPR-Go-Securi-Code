package com.example.mspr_go_securi_code_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listAgent = (ListView)findViewById(R.id.listAgent);
        Agent a1 = new Agent("A", "A", "A", "A", Arrays.asList(new String[]{"e", "e"}));
        Agent a2 = new Agent("A", "A", "A", "A", Arrays.asList(new String[]{"e", "e"}));
        Agent a3 = new Agent("A", "A", "A", "A", Arrays.asList(new String[]{"e", "e"}));
        ArrayList<Agent> agents = new ArrayList<Agent>();
        agents.add(a1);
        agents.add(a2);
        agents.add(a3);

        ArrayAdapter<Agent> arrayAdapter
                = new ArrayAdapter<Agent>(this, android.R.layout.simple_list_item_1 , agents);
        listAgent.setAdapter(arrayAdapter);
    }
}