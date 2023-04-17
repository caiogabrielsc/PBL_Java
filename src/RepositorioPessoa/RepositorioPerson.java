package RepositorioPessoa;
import Entity.Person;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPerson implements IRepositorioPerson {

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
        return 0;
    }

    public boolean deletePerson(int id){
        for (Person person : list){
            if(person.getId() == id){list.remove(person);return true;}}
        return false;
    }

    public Person returnPersonById(int id){
        int position = 0;
        for (Person person : list) {
            if (person.getId() == id) {return person;}
        }return null;
    }

    @Override
    public boolean editNamePerson(int idbuscado, String newName) {
       for (Person person : list){
           if(person.getId() == idbuscado){person.setName(newName); return true;}
       }
        return false;
    }
    // RESTO DA ESTRUTURA PESSOA \/
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

    public  boolean listPerson() {
        if (list.isEmpty()) {
            System.out.println("\nNão tem clientes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de clientes:");
        for (Person person : list) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + person.getId() + " nome:" + person.getName());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }

    public int returnLenght(){
        return list.size();
    }

}
