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

    public boolean listOs() {
        if(OsList.isEmpty() == true){
            System.out.println("Não tem OS cadastradas");
            return false;}
        System.out.println("            Lista de OS:");
        for (Os os : OsList) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("idOs:" + os.getId() + " | cliente:" + os.client.getName() + " | descricao:" + os.getDescription());
        }System.out.println("---------------------------------------------------------------\n");

        return true;
    }

    public boolean checkOs(){
        for (Os os: OsList){
            if(os.status == 1){
                System.out.println("XXXTecnico já está em serviço em serviço, não pode iniciar OS.");
                return false;
            }
        }return true; // tecnico está disponível
    }

    public boolean startOs() {
        if(checkOs() == false){
            System.out.println("tecnico indisponivel");
            return false;
        }else{  //tecnico disponivel
            for (Os os : OsList) {
                if (os.status == 0) {
                    os.status = 1;
                    System.out.println("\nIniciada a primeira na fila, OS id:" + os.getId());}
                }
            }
        return true;
    }

    public boolean finalizeOS(){
    if(checkOs()){
        System.out.println("Tecnico não tem nenhuma os em andamento.");
        return false;
    }else{
        for( Os os : OsList){
            if(os.status == 1){os.status=2;    //acha a os que está em andamento
                System.out.println("\nFinalizada a os" + os.status + " ,Tecnico livre");
                System.out.println("\nPara pagamento, Atendente deve gerar fatura");
                return true;
        }
    }
}
    return false;
}

    public int returnLenght(){
        return OsList.size();
    }


}