package Modelll.DAO;
import Modelll.Entity.Person;
import java.util.ArrayList;
import java.util.List;

public class DaoPessoa {
    // ARMAZENAMENTO É FEITO AQUI
    protected static List<Person> list = new ArrayList<Person>();

    public static boolean savePerson(Person person) {
        try {
            list.add(person);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean deletePerson(Person p){
        list.remove(p);
        return true;}

    public static Person returnPersonById(int id){
        for (Person person : list) {
            if (person.getId() == id) {return person;}
        }return null;
    }

    public static boolean editNamePerson(Person p, String name) {
        p.setName(name);
        return true;
    }

    public int returnLenght(){
        return list.size();
    }

    public static List<Person> retornarLista(){
        return list;
    }
}
