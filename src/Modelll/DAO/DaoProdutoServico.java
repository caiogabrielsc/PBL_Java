package Modelll.DAO;
import Modelll.Produto;
import Modelll.Servico;
import Control.RepositorioProdutoServico;
import java.io.*;
import java.sql.Array;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class DaoProdutoServico {
    public static List<Produto> retornarListaProduto() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
        List<Produto> listFile = (List<Produto>) ois.readObject();
        ois.close();

        return listFile;
    }

    public static List<Servico> retornarListaServico() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service.bin"));
        List<Servico> listFile = (List<Servico>) ois.readObject();
        ois.close();

        return listFile;
    }

    public static boolean fillArraylistProduto() {
        try {
            /*
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
            List<Produto> listFile = (List<Produto>) ois.readObject();
            ois.close();
             */
            List<Produto> listFile = new ArrayList<Produto>();
            Produto ram = new Produto(1,"Ram",3,20);
            Produto placamae = new Produto(2,"Placa mae", 10, 100);
            Produto fonte = new Produto(3,"Fonte", 10, 30);
            Produto placadevideo = new Produto(4,"Placa de video", 10, 100);
            Produto hddssd = new Produto(5,"HDD/SSD", 10, 30);

            listFile.add(ram);
            listFile.add(placamae);
            listFile.add(fonte);
            listFile.add(placadevideo);
            listFile.add(hddssd);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.bin"));
            oos.writeObject(listFile);
            oos.close();

        } catch (IOException e) {e.printStackTrace();}
        return true;
    }
    public static void fillArraylistService() {
        try {
            /*
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service.bin"));
            List<Servico> listFile = (List<Servico>) ois.readObject();
            ois.close();
             */
            List<Servico> listFile = new ArrayList<Servico>();
            Servico SO = new Servico(6,"Instalar SO", 50);
            Servico programas = new Servico(7,"Instalar Programas", 10);
            Servico limpeza = new Servico(8, "Realizar limpeza", 70);
            listFile.add(SO);
            listFile.add(programas);
            listFile.add(limpeza);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("service.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException e) {e.printStackTrace();}

    }

    public static void listProduct() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
        List<Produto> listFile = (List<Produto>) ois.readObject();
        ois.close();

        System.out.println("    Lista de produtos:");
        for(Produto i : listFile){
            System.out.println("---------------------------");
            System.out.println("IdProduto:"+ i.getId() + " nome:" + i.getName() + " qtdEstoque:"+i.getQtd()+" valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }
    public static void listService() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service.bin"));
        List<Servico> listFile = (List<Servico>) ois.readObject();
        ois.close();

        System.out.println("    Lista de Serviços:");
        for(Servico i : listFile){
            System.out.println("---------------------------");
            System.out.println("IdServiço:"+ i.getId() + " nome:" + i.getName() + " valor:" + i.getValue());
        }
        System.out.println("---------------------------");
    }

    public static Produto returnProdutoById(int idbuscado) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
        List<Produto> listFile = (List<Produto>) ois.readObject();
        ois.close();

        for (Produto i : listFile) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }
    public static Servico returnServiceById(int idbuscado) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service.bin"));
        List<Servico> listFile = (List<Servico>) ois.readObject();
        ois.close();
        for (Servico i : listFile) {
            if (i.getId() == idbuscado) {return i;}
        }return null;
    }


    public static boolean changeStockDao(int idProduto, int newQtd) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
        List<Produto> listFile = (List<Produto>) ois.readObject();
        ois.close();

        for (Produto p : listFile){
            if(p.getId()== idProduto){
                p.setQtd(newQtd);}
            }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.bin"));
        oos.writeObject(listFile);
        oos.close();
        return true;
    }

     public static boolean changeValueProductDao(int idProduto, int newValue) throws IOException, ClassNotFoundException {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.bin"));
         List<Produto> listFile = (List<Produto>) ois.readObject();
         ois.close();

         for (Produto p : listFile){
             if(p.getId()== idProduto){
                 p.setValue(newValue);}
         }

         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.bin"));
         oos.writeObject(listFile);
         oos.close();
         return true;
    }

     public static boolean changeValueServiceDao(int idServico, int newValue) throws IOException, ClassNotFoundException {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("service.bin"));
         List<Servico> listFile = (List<Servico>) ois.readObject();
         ois.close();

         for (Servico p : listFile){
             if(p.getId()== idServico){
                 p.setValue(newValue);}
         }

         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("service.bin"));
         oos.writeObject(listFile);
         oos.close();
         return true;

    }


}
