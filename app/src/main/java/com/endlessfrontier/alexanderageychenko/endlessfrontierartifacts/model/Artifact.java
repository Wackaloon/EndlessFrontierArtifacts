package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model;

import java.util.ArrayList;

/**
 * Created by alexanderageychenko on 9/6/16.
 */

public class Artifact {
    public String item_name;
    public String stars;
    public boolean is_set;
    public  String set_name;
    public String source;
    public ArrayList<String> materials;
    public ArrayList<Attribute> attributes;

    public class Attribute {
        public String name;
        public String value;
        public  String value_increment;

        public String getFullName(){
            return name + ": " + Double.parseDouble(value.replace(",","."))*100 + "%";
        }
    }
}
