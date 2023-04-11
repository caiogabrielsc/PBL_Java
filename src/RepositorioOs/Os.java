package RepositorioOs;

import Entity.Person;

public class Os {
    protected Person client;

    public Os(int id, Person client, String description, int status) {
        this.id = id;
        this.client = client;
        this.description = description;
        this.status = status;
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
