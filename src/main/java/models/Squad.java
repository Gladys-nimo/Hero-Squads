package models;

import java.util.ArrayList;

public class Squad {

    private int SquadId;
    private String squadName;
    private int SquadSize;
    private String cause;
    private ArrayList<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String name, int squadSize, String cause) {
       squadName = name;
        SquadSize = squadSize;
        this.cause = cause;
        this.squadMembers = new ArrayList<>();
        instances.add(this);
        this.SquadId = instances.size();
    }

    public int getSquadId() {
        return SquadId;
    }
    public static Squad findBySquadId(int id) {
        return instances.get(id-1);
    }

    public String getSquadName() {
        return squadName;
    }

    public int getSize() {
        return SquadSize;
    }

    public String getCause() {
        return cause;
    }

    public ArrayList<Hero> getSquadMembers() {
        return squadMembers;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public void setSquadMembers(Hero newMember) {
        squadMembers.add(newMember);
    }
    public static void clearAllSquads(){
        instances.clear();
    }
    public void clearAllSquadMembers(){
        getSquadMembers().clear();
    }
    public static Squad setUpNewSquad(){
        return new Squad("Avengers",5,"Infinity Stone");
    }
    public static Squad setUpNewSquad1(){
        return new Squad("GameBoy",5,"PUBG");
    }

}
