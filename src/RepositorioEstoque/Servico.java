package RepositorioEstoque;

public class Servico {
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    protected double value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Servico(int id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
