package RepositorioPessoa;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;

public class DaoPessoa {
    // ARMAZENAMENTO É FEITO AQUI
    static List<Person> list = new ArrayList<Person>();

    public static boolean savePerson(Person person) {
        try {
            list.add(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean deletePerson(int id){
        for (Person person : list){
            if(person.getId() == id){list.remove(person);return true;}}
        return false;
    }

    public Person returnPersonById(int id){
        for (Person person : list) {
            if (person.getId() == id) {return person;}
        }return null;
    }

    public static boolean editNamePerson(int idbuscado, String newName) {
        for (Person person : list){
            if(person.getId() == idbuscado){person.setName(newName); return true;}
        }
        return false;
    }

    public int returnLenght(){
        return list.size();
    }

    public static List<Person> retornarLista(){
        return list;
    }
}
