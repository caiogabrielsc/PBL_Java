package Modelll.DAO;
import Control.RepositorioPerson;
import Modelll.Entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPessoa {

    public static boolean listPersonFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
        List<Person> listFile = (List<Person>) ois.readObject();
        ois.close();


        if (listFile.isEmpty()) {
            System.out.println("\nNão tem clientes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de clientes:");
        for (Person person : listFile) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + person.getId() + " nome:" + person.getName());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }

    public static void zerarArquivo() throws IOException {
        List<Person> list = new ArrayList<Person>();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
            oos.writeObject(list);
            oos.close();
    }catch (IOException e) {e.printStackTrace();}}

    public static boolean savePersonFile(Person p){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
            List<Person> listFile = (List<Person>) ois.readObject();
            ois.close();

            listFile.add(p);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }

    public static boolean deletePersonFile(int id){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
            List<Person> listFile = (List<Person>) ois.readObject();
            ois.close();

            for (Person p : listFile){
                if(p.getId() == id){
                    listFile.remove(p);break;}
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
            oos.writeObject(listFile);
            oos.close();
        }catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }

    public static Person returnPersonByIdFile(int id) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
        List<Person> listFile = (List<Person>) ois.readObject();
        ois.close();

        for (Person p : listFile) {
            if (p.getId() == id) {return p;}


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
        oos.writeObject(listFile);
        oos.close();
        }
        return null;
    }

    public static boolean editNamePersonFile(int id, String name){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
            List<Person> listFile = (List<Person>) ois.readObject();
            ois.close();

            for (Person p : listFile){
                if(p.getId()== id){p.setName(name);
            }}

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }

    public static int returnLenghtFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
            List<Person> listFile = (List<Person>) ois.readObject();
            ois.close();
            return listFile.size();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return 0;
    }

    public static List<Person> returnlistFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"));
            List<Person> listFile = (List<Person>) ois.readObject();
            ois.close();
            return listFile;
        }catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return null;
    }


}
