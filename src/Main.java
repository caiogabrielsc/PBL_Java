import Entity.Person;
import Repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Repositorio rp = new Repositorio();

    public static void main(String[] args) {

    Person person = new Person(10);
    rp.savePerson(person);

    System.out.println(rp.findPersonById(10));



    }


    /*
    public static void popularArray(){
        Person person = new Person(10);
        rp.savePerson(person);

        person.setId(20);
        rp.savePerson(person);

        person.setId(30);
        rp.savePerson(person);

    }
    public static void listPerson(){

        List<Person> lista = new ArrayList<Person>();
        lista = rp.listPerson();

        for (Person person : lista) {
            System.out.println(person.getId());

        }
    }

     */
}