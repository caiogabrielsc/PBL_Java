package RepositorioOs;
import Entity.Person;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalTime;

import RepositorioPessoa.IRepositorioPerson;
import RepositorioPessoa.RepositorioPerson;
import RepositorioPessoa.RepositorioPerson;

public class RepositorioOs implements IRepositorioOs {

    List<Os> OsList = new ArrayList<Os>();




    public boolean createOS(RepositorioPerson rp, RepositorioOs ro){
        if(rp.listPerson() == false){
            System.out.println("Logo não podemos abrir OS");
            return false;};

        System.out.println("\nDigite o id do cliente para abrir OS:");
        Scanner idbuscado = new Scanner(System.in);
        int num = idbuscado.nextInt();

        if(rp.returnPersonById(num) == null){
            System.out.println("Não tem esse cliente na lista\n");
            return false;
        }

        Os os = new Os((rp.returnPersonById(num)), (ro.returnLenght() + 1), "trocar placa mae", 0, 0,System.currentTimeMillis(),0, 0);
        saveOS(os);
        System.out.print("\nOS aberta.\n");
        return true;
    }

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

    public int returnLenght() {
        return OsList.size();
    }

    public boolean listOs() {
        if (OsList.isEmpty() == true) {
            System.out.println("Não tem OS cadastradas");
            return false;
        }
        System.out.println("            Lista de OS:");
        for (Os os : OsList) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("idOs:" + os.getId() + " | cliente:" + os.client.getName() + " | status:" + os.getStatus());
        }
        System.out.println("---------------------------------------------------------------\n");

        return true;
    }

    public boolean startOs() {
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 1) {   //procura uma os que já está em andamento
                System.out.println("Tecnico já está em serviço, não pode iniciar OS.");
                return false;
            }
        }
        for (Os os : OsList) {
            if (os.getStatus() == 0) {
                os.setStatus(1);
                os.setStarttime(System.currentTimeMillis());
                System.out.println("\nIniciada a primeira da fila, OS id:" + os.getId());
                System.out.println("\nO tempo de espera foi: " + (os.getStarttime() - os.getCreatetime())/1000 + "segundos." );

                return true;
            }
        }
        System.out.println("\nNão temos OS para serem iniciadas.");
        return false;
    }

    public boolean finalizeOS() {
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 1) { //procura uma os que já está em andamento
                os.setStatus(2);
                os.setFinishtime(System.currentTimeMillis());
                System.out.println("\nFinalizada a os com ID " + os.getId() + ", tecnico está disponível.");
                System.out.println("\nPara pagamento o Atendente deve gerar fatura.");
                System.out.println("\nO tempo de espera foi: " + (os.getFinishtime() - os.getStarttime())/1000 + "segundos.");
                return true;
            }}
        System.out.println("\nNão foi encontrada nenhuma OS em andamento para poder finalizar");
        return false;
    }

}

