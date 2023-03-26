package Repositorio;
import Entity.Person;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements IRepositorio {

    List<Person> list = new ArrayList<Person>();


    @Override
    public boolean savePerson(Person person) {
        try {
            list.add(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int findPersonById(int id) {

        int position = 0;
        for (Person person : list) {
            if (person.getId() == id) {
                position += 1;
                return position;}
        }
        return 0;
        }




}
