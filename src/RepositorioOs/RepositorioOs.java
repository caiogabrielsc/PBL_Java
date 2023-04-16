package RepositorioOs;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;

public class RepositorioOs implements IRepositorioOs {

    List<Os> OsList = new ArrayList<Os>();

    public boolean saveOS(Os os) {
        try {
            OsList.add(os);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean editDescriptionOs(int idbuscado, String newDescription) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setDescription(newDescription);
                return true;
            }
        }
        return false;
    }

    public boolean editStatusOs(int idbuscado, int newStatus) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public boolean editClientOs(int idbuscado, Person newClient) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setClient(newClient);
                return true;
            }
        }
        return false;
    }

    public void listOs() {
        for (Os os : OsList) {
            System.out.println("---------------------");
            System.out.println("id:" + os.getId() + " | cliente:" + os.client.getName() + " | descricao:" + os.getDescription());
        }System.out.println("---------------------");
    }

    public boolean checkOs(){
        for (Os os: OsList){
            if(os.status == 1){
                return false;   // tem alguma OS em serviço
            }
        }return true; // tecnico está disponível
    }

    public void startOs(){
        int counter = 0;
        for(Os os : OsList){
            counter+=1;
            if (os.status == 0){
                os.status = 1;
                System.out.println("\nIniciada a primeira da fila, OS id:" + counter);
            }
        }
    }

    public int returnLenght(){
        return OsList.size();
    }


}