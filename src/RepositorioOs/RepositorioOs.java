package RepositorioOs;


import java.util.ArrayList;
import java.util.List;

public class RepositorioOs implements IRepositorioOs {

    List<Os> OsList = new ArrayList<Os>();

    public boolean saveOS(Os os){
        try {
            OsList.add(os);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public  void listOs(){
        System.out.println("---------------------");
        for (Os os : OsList) {
            System.out.println("cliente associado:" + os.client.getName() + " descricao:" + os.getDescription()+"\n");
        }
    }










}
