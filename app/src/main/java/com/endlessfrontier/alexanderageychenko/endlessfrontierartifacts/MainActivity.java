package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArtifactsAdapter artifactsAdapter = new ArtifactsAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.artifacts_list);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(artifactsAdapter);
        try {
            artifactsAdapter.setData(MainActivity.this, getCountryList(MainActivity.this));
        } catch (IOException e) {
            e.printStackTrace();
        }
        artifactsAdapter.notifyDataSetChanged();
    }



    static public ArrayList<Artifact> getCountryList(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.artefacts);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        String jsonString = writer.toString();
        Gson gson = new Gson();
        return new ArrayList<Artifact>(Arrays.asList(gson.fromJson(jsonString, Artifact[].class)));
    }
}
