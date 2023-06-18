package Control;
import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Attendant;
import Modelll.Entity.Client;
import Modelll.Entity.Person;
import Modelll.Entity.Technician;

import java.io.IOException;
import java.util.Scanner;

public class RepositorioPerson extends DaoPessoa {

    public static boolean createClient(String name, String email, String adress ){
        Client clientGenerico = new Client(DaoPessoa.returnLenghtClientFile(), name, email, adress);
        DaoPessoa.saveClientFile(clientGenerico);
        System.out.print("\nCliente Cadastrado com o id ["+ clientGenerico.getId() +"].\n");
        return true;
    }

    public static boolean createTechnician( String name, String email, String adress, String password){
        // AQUI TEM QUE RETORNAR O TAMANHO DA LISTA DE ATENDENTES PARA PODER CRIAR NOVO
        Technician technicianGenerico = new Technician(returnLenghtTechnicianFile(), name, email, adress, password);
        DaoPessoa.saveTechnicianFile(technicianGenerico);
        System.out.print("\nTecnico Cadastrado\n");
        return true;
    }

    public static boolean createAttendant(String name,String email, String adress, String password){
        Attendant AttendantGenerico = new Attendant(returnLenghtAttendantFile(),name,email,adress,password);
        DaoPessoa.saveAttendantFile(AttendantGenerico);
        System.out.print("\nAtendente Cadastrado com id: [" + AttendantGenerico.getId() +"].\n");
        return true;
    }

    /*
                EDITAR:
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

     */

    /*
    public static boolean listPerson(List<Person> lista) {
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

     */

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
