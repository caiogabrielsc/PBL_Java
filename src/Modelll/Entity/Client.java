package Modelll.Entity;

public class Client extends Person{

    private String password;

    public Client(int id, String name) {
        super(id, name);
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
