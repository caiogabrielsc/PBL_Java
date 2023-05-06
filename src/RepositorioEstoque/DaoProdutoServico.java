package RepositorioEstoque;

import java.util.ArrayList;
import java.util.List;


public class DaoProdutoServico {

    // ARMAZENAMENTO DE PRODUTOS E SERVIÇO
    static List<Produto> ProdutoList = new ArrayList<Produto>();
    static List<Servico> ServiceList = new ArrayList<Servico>();

    public static List<Produto> retornarListaProduto(){
        return ProdutoList;
    }

    public static List<Servico> retornarListaServico(){
        return ServiceList;
    }

    public void fillArraylistProduto() {
        Produto ram = new Produto(1,"Ram",3,20);
        Produto placamae = new Produto(2,"Placa mae", 10, 100);
        Produto fonte = new Produto(3,"Fonte", 10, 30);
        Produto placadevideo = new Produto(4,"Placa de video", 10, 100);
        Produto hddssd = new Produto(5,"HDD/SSD", 10, 30);

        ProdutoList.add(ram);
        ProdutoList.add(placamae);
        ProdutoList.add(fonte);
        ProdutoList.add(placadevideo);
        ProdutoList.add(hddssd);
    }

    public void fillArraylistService() {
        Servico SO = new Servico(6,"Instalar SO", 50);
        Servico programas = new Servico(7,"Instalar Programas", 10);
        Servico limpeza = new Servico(8, "Realizar limpeza", 70);
        ServiceList.add(SO);
        ServiceList.add(programas);
        ServiceList.add(limpeza);
    }


    public static Produto returnProdutoById(int idbuscado){
        for (Produto i : ProdutoList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }
    public  Servico returnServiceById(int idbuscado){
        for (Servico i : ServiceList) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }


    public static boolean changeStockDao(int idProduto, int newqtd){
        returnProdutoById(idProduto).setQtd(newqtd);
        return true;

    }

     public static boolean changeValueDao(int id, int nv){
        returnProdutoById(id).setValue(nv);
        return true;

    }



}
