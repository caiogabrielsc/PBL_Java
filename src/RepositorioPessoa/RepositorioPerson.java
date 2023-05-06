package RepositorioPessoa;
import Entity.Client;
import Entity.Person;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPerson extends DaoPessoa {

    //List<Person> list = new ArrayList<Person>();

    public boolean createPerson(Person person){
        Client clientGenerico = new Client((returnLenght() + 1), "ClienteGenerico" + (returnLenght() + 1));
        DaoPessoa.savePerson(clientGenerico);
        System.out.print("\nCliente Cadastrado\n");
        return true;
    }

    public boolean delete(int id){
        return DaoPessoa.deletePerson(id);
    }

    public static boolean editNamePerson(int idbuscado, String newName) {
       return DaoPessoa.editNamePerson(idbuscado,newName);
    }

    // PARTE "EXTRA" DA ESTRUTURA PESSOA \/
    /*
    public boolean editAgePerson(int idbuscado, String newAge) {
        for (Person person : list){
            if(person.getAge() == idbuscado){person.setAge(newAge); return true;}
        }
        return false;
    }
    public boolean editCpfPerson(int idbuscado, String newCpf) {
        for (Person person : list){
            if(person.getCpf() == idbuscado){person.setCpf(newCpf); return true;}
        }
        return false;
    }
    public boolean editEmailPerson(int idbuscado, String newEmail) {
        for (Person person : list){
            if(person.getEmail() == idbuscado){person.setEmail(newEmail); return true;}
        }
        return false;
    }
    public boolean editAdressPerson(int idbuscado, String newAdress) {
        for (Person person : list){
            if(person.getAdress() == idbuscado){person.setAdress(newAdress); return true;}
        }
        return false;
    }

     */

    public  boolean listPerson() {
        list = DaoPessoa.retornarLista();
        if (list.isEmpty()) {
            System.out.println("\nNão tem clientes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de clientes:");
        for (Person person : list) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + person.getId() + " nome:" + person.getName());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }

}
