package com.example.authentication;

public class Good {
    private String Name;
    private String Explain;
    private int Photo;

    public Good() {

    }

    public Good(String name, String explain, int photo) {
        Name = name;
        Explain = explain;
        Photo = photo;
    }

    //Getter


    public String getName() {
        return Name;
    }

    public String getExplain() {
        return Explain;
    }

    public int getPhoto() {
        return Photo;
    }

    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setExplain(String explain) {
        Explain = explain;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
