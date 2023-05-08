package Control;
import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Client;
import Modelll.Entity.Person;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RepositorioPerson extends DaoPessoa {

    public boolean createPerson(Person person){
        Client clientGenerico = new Client((returnLenghtFile() + 1), "ClienteGenerico" + (returnLenghtFile() + 1));
        DaoPessoa.savePersonFile(clientGenerico);
        System.out.print("\nCliente Cadastrado\n");
        return true;
    }

    public boolean deletePerson() throws IOException, ClassNotFoundException {
        DaoPessoa.listPersonFile();
        System.out.println("\nDigite o id da Pessoa que vc deseja deletar:");
        int id = ((new Scanner(System.in)).nextInt());
        DaoPessoa.deletePersonFile(id);
        return true;
    }

    public static boolean editNamePerson() throws IOException, ClassNotFoundException {
        DaoPessoa.listPersonFile();
        System.out.println("\nDigite o id da Pessoa que vc deseja alterar o nome:");
        int id = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo nome:");
        String newname = String.valueOf(((new Scanner(System.in)).nextInt()));

        DaoPessoa.editNamePersonFile(id, newname);
        return true;

    }

    public static boolean listPerson() {
        List<Person> lista = DaoPessoa.returnlistFile();
        if (lista.isEmpty()) {
            System.out.println("\nNão tem clientes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de clientes:");
        for (Person person : lista) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + person.getId() + " nome:" + person.getName());
        }
        System.out.println("-------------------------------------\n");
        return true;
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

}
