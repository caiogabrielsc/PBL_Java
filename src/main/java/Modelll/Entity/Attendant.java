package Modelll.Entity;

import java.io.Serializable;

public class Attendant extends Person{

    private String password;

    public Attendant(int id, String name, String email, String adress, String password) {
        super(id, name, email, adress);
        this.password = password;
    }

    public Attendant(int id, String name, String email, String adress) {
        super(id, name, email, adress);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getAdress() {
        return super.getAdress();
    }

    @Override
    public void setAdress(String adress) {
        super.setAdress(adress);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
