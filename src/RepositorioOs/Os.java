package RepositorioOs;

import Entity.Person;

public class Os {
    protected Person client;

    public Os(Person client, String description, int status) {
        this.client = client;
        this.description = description;
        this.status = status;
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
