import Entity.Person;
import RepositorioOs.Os;
import RepositorioOs.RepositorioOs;
import RepositorioPessoa.RepositorioPerson;

public class Main {
    static RepositorioPerson rp = new RepositorioPerson();
    static RepositorioOs ro = new RepositorioOs();

    public static void main(String[] args) {

        Person person1 = new Person(1, "Caio");
        rp.savePerson(person1);
        Person person2 = new Person(2, "Lara");
        rp.savePerson(person2);
        Person person3 = new Person(3, "Alice");
        rp.savePerson(person3);

        Os os = new Os(person2,"trocar hdd",0 );
        ro.saveOS(os);
        ro.listOs();



    }
}