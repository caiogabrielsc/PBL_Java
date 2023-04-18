package RepositorioEstoque;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositorioProdutoServico {
    List<Produto> ProdutoList = new ArrayList<Produto>();
    List<Servico> ServiceList = new ArrayList<Servico>();

    Produto ram = new Produto(1,"Ram",3,20);
    Produto placamae = new Produto(2,"Placa mae", 10, 100);
    Produto fonte = new Produto(3,"Fonte", 10, 30);
    Produto placadevideo = new Produto(4,"Placa de video", 10, 100);
    Produto hddssd = new Produto(5,"HDD/SSD", 10, 30);

    Servico SO = new Servico(6,"Instalar SO", 50);
    Servico programas = new Servico(7,"Instalar Programas", 10);
    Servico limpeza = new Servico(8, "Realizar limpeza", 70);

    public void fillArraylistProduto() {
        ProdutoList.add(ram);
        ProdutoList.add(placamae);
        ProdutoList.add(fonte);
        ProdutoList.add(placadevideo);
        ProdutoList.add(hddssd);
    }

    public void listProduct(){
        if(ProdutoList.isEmpty()){fillArraylistProduto();}

        System.out.println("    Lista de produtos:");
        for(Produto i : ProdutoList){
            System.out.println("---------------------------");
            System.out.println("IdProduto:"+ i.getId() + " nome:" + i.getName() + " qtdEstoque:"+i.getQtd()+" valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public void fillArraylistService() {
        ServiceList.add(SO);
        ServiceList.add(programas);
        ServiceList.add(limpeza);
    }

    public void listService(){
        if(ProdutoList.isEmpty()){fillArraylistService();}

        System.out.println("    Lista de Serviços:");
        for(Servico i : ServiceList){
            System.out.println("---------------------------");
            System.out.println("IdServiço:"+ i.getId() + " nome:" + i.getName() + " valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public Produto returnProdutoById(int idbuscado){
        for (Produto i : ProdutoList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }

    public Servico returnServiceById(int idbuscado){
        for (Servico i : ServiceList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }

    public boolean changeStock(RepositorioProdutoServico rpdt){
        rpdt.listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o estoque:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do estoque:");
        int newqtd = ((new Scanner(System.in)).nextInt());
        rpdt.returnProdutoById(idProduto).setQtd(newqtd);
        System.out.println("\nEstoque alterado.");
        return true;

    }

    public boolean changeValue(RepositorioProdutoServico rpdt){
        rpdt.listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o preço:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do produto:");
        int newvalue = ((new Scanner(System.in)).nextInt());
        rpdt.returnProdutoById(idProduto).setValue(newvalue);
        System.out.println("\nValor alterado.");
        return true;

    }



}
