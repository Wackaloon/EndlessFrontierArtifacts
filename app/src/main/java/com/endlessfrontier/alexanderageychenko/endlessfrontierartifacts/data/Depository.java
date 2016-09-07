package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.data;

import android.content.Context;

import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model.Artifact;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.R;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model.Sets;
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

/**
 * Created by alexanderageychenko on 9/7/16.
 */

public class Depository {
    private static Depository instance;
    private ArrayList<Artifact> artifactsList = new ArrayList<>();
    private ArrayList<Sets> setsList = new ArrayList<>();

    public static void init(Context context){
        instance = new Depository(context);
    }
    public static Depository getInstance(){
        return instance;
    }
    public Depository(Context context) {
        try {
        this.artifactsList = getArtifactsList(context);
            this.setsList = getSetsList(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Artifact> getArtifactsList() {
        return artifactsList;
    }

    public ArrayList<Sets> getSetsList() {
        return setsList;
    }

    private ArrayList<Artifact> getArtifactsList(Context context) throws IOException {
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

    private ArrayList<Sets> getSetsList(Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(R.raw.sets);
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
        return new ArrayList<Sets>(Arrays.asList(gson.fromJson(jsonString, Sets[].class)));
    }
}
