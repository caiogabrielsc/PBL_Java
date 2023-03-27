import Entity.Person;
import Repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static Repositorio rp = new Repositorio();

    public static void main(String[] args) {

        Person person1 = new Person(1, "Caio");
        rp.savePerson(person1);
        Person person2 = new Person(2, "Lara");
        rp.savePerson(person2);
        Person person3 = new Person(3, "Alice");
        rp.savePerson(person3);

        //rp.listPerson();

        rp.editNamePerson(2, "Joao");

        rp.listPerson();

    }
}