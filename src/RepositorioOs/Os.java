package RepositorioOs;

import Entity.Person;

public class Os {
    protected Person client;

    protected double finalvalue;

    public Os(Person client, int id, String description, int status, double finalvalue) {
        this.client = client;
        this.id = id;
        this.description = description;
        this.status = status;
        this.finalvalue = finalvalue;
    }


    public double getFinalvalue() {
        return finalvalue;
    }

    public void setFinalvalue(double finalvalue) {
        this.finalvalue = finalvalue;
    }
    protected  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String description;

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    protected int status;


}
