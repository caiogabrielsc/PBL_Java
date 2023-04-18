package RepositorioEstoque;

public class Produto {
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int qtd;
    protected double value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Produto(int id, String name, int qtd, double value) {
        this.id = id;
        this.name = name;
        this.qtd = qtd;
        this.value = value;
    }
}
