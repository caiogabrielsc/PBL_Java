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
        System.out.println("---------------------");
        for (Os os : OsList) {
            System.out.println("cliente associado:" + os.client.getName() + " descricao:" + os.getDescription() + "\n");
        }
    }



}