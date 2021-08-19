package com.example.authentication;

public class model
{
    String name, email, health;
    private long timestamp;
    model() {

    }
    public model(String name, String email, String health, long timestamp) {
        this.name=name;
        this.email=email;
        this.health=health;
        this.timestamp=timestamp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getHealth() {
        return health;
    }
    public void setHealth(String health) {
        this.health=health;
    }
    public long getTimestamp() {
        return timestamp;
    }
}
