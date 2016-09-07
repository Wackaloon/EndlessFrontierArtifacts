package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.data;

import android.content.Context;

import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.Artifact;
import com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.R;
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
    static public ArrayList<Artifact> getArtifactsList(Context context) throws IOException {
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
