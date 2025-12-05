package Singletone;

public class Singletone {
    private static Singletone db;

    private Singletone(){
        System.out.println("Databse Connection Created");
    }

    public static Singletone getinstance(){
        if (db == null){
            db = new Singletone();
        }
        return db;
    }

    public void connect(){
        System.out.println("Connected to databse");
    }
    public static void main(String args[]){
        Singletone sc = Singletone.getinstance();
        sc.connect();
        Singletone sr = Singletone.getinstance();
        sr.connect();
    }
}
