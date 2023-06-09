package Modelll.Entity;

public class Attendant extends Person{

    private String password;

    public Attendant(int id, String name, String password) {
        super(id, name);
        this.password = password;
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
