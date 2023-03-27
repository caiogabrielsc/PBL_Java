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

    @Override
    public boolean editNamePerson(int idbuscado, String newName) {
       for (Person person : list){
           //System.out.println(person.getName());
           if(person.getId() == idbuscado){person.setName(newName); return true;}
       }
        return false;
    }

    public  void listPerson(){
        System.out.println("---------------------");
        for (Person person : list) {
            System.out.println("id:" + person.getId() + " nome:" + person.getName()+"\n");
        }
    }

}
