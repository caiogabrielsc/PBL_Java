package RepositorioProdutos;

public class Produtos {
    protected String name;
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

    public Produtos(String name, int qtd, double value) {
        this.name = name;
        this.qtd = qtd;
        this.value = value;
    }
}
