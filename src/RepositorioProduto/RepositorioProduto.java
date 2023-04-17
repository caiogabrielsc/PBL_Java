package RepositorioProduto;
import Entity.Person;
import RepositorioOs.Os;


import java.util.ArrayList;
import java.util.List;

public class RepositorioProduto {
    List<Produto> ProdutoList = new ArrayList<Produto>();
    List<Os> OsList = new ArrayList<Os>();

    Produto ram = new Produto(1,"Ram",10,20);
    Produto placamae = new Produto(2,"Placa mae", 10, 100);
    Produto fonte = new Produto(3,"Fonte", 10, 30);
    Produto placadevideo = new Produto(4,"Placa de video", 10, 100);
    Produto hddssd = new Produto(5,"HDD/SSD", 10, 30);

    public void fillArraylist() {
        ProdutoList.add(ram);
        ProdutoList.add(placamae);
        ProdutoList.add(fonte);
        ProdutoList.add(placadevideo);
        ProdutoList.add(hddssd);
    }

    public void listProduct(){
        if(ProdutoList.isEmpty()){fillArraylist();}

        System.out.println("    Lista de produtos:");
        for(Produto i : ProdutoList){
            System.out.println("---------------------------");
            System.out.println("IdProduto:"+ i.getId() + " nome:" + i.getName() + " qtdEstoque:"+i.getQtd()+" valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public Produto returnProdutoById(int idbuscado){
        for (Produto i : ProdutoList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }


}
