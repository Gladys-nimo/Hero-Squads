package models;

import java.util.ArrayList;

public class Squad {

    private int SquadId;
    private String squadName;
    private int SquadSize;
    private String cause;
    private ArrayList<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();
}
