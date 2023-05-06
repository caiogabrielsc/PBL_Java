package RepositorioEstoque;

import java.util.Scanner;

public class RepositorioProdutoServico extends DaoProdutoServico{

    public Servico returnServiceById(int idbuscado){
        for (Servico i : ServiceList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }

    public void listProduct(){
        System.out.println("    Lista de produtos:");
        for(Produto i : ProdutoList){
            System.out.println("---------------------------");
            System.out.println("IdProduto:"+ i.getId() + " nome:" + i.getName() + " qtdEstoque:"+i.getQtd()+" valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public void listService(){
        System.out.println("    Lista de Serviços:");
        for(Servico i : ServiceList){
            System.out.println("---------------------------");
            System.out.println("IdServiço:"+ i.getId() + " nome:" + i.getName() + " valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public boolean changeStock(){
        listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o estoque:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do estoque:");
        int newqtd = ((new Scanner(System.in)).nextInt());

        DaoProdutoServico.changeStockDao(idProduto,newqtd);

        System.out.println("\nEstoque alterado.");
        return true;

    }

    public boolean changeValue(){
        listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o preço:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do produto:");
        int newvalue = ((new Scanner(System.in)).nextInt());

        DaoProdutoServico.changeValueDao(idProduto, newvalue);

        System.out.println("\nValor alterado.");
        return true;

    }




}
