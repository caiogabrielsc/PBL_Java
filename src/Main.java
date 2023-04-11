
import Entity.Client;

import RepositorioOs.Os;
import RepositorioOs.RepositorioOs;
import RepositorioPessoa.RepositorioPerson;

public class Main {
    static RepositorioPerson rp = new RepositorioPerson();
    static RepositorioOs ro = new RepositorioOs();

    public static void main(String[] args) {

        Client client1 = new Client(1, "Joao");

        rp.savePerson(client1);
        /*
        Person person2 = new Person(2, "Lara");
        rp.savePerson(person2);
        Person person3 = new Person(3, "Alice");
        rp.savePerson(person3);
        */

        Os os = new Os(1,client1,"trocar hdd",0 );
        ro.saveOS(os);
        ro.editDescriptionOs(1,"trocar placa mae");
        ro.listOs();




    }
}