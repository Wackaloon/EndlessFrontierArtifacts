package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts;

import java.util.ArrayList;

/**
 * Created by alexanderageychenko on 9/6/16.
 */

public class Artifact {
    String item_name;
    String stars;
    boolean is_set;
    String set_name;
    String source;
    ArrayList<String> materials;
    ArrayList<Attribute> attributes;

    public class Attribute {
        String name;
        String value;
        String value_increment;

        public String getFullName(){
            return name + ": " + value;
        }
    }
}
