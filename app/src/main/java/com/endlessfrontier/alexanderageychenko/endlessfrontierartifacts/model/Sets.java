package com.endlessfrontier.alexanderageychenko.endlessfrontierartifacts.model;

import java.util.ArrayList;

/**
 * Created by alexanderageychenko on 9/6/16.
 */

public class Sets {
    public  String set_name;
    public ArrayList<Bonus> attributes;

    public class Bonus {
        public String bonus;
        public String bonus_activated;
    }
}
