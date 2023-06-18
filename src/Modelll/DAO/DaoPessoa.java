package Modelll.DAO;
import Control.RepositorioPerson;
import Modelll.Entity.Attendant;
import Modelll.Entity.Person;
import Modelll.Entity.Technician;

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





    public static Technician technicianLogin(int id){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("technician.bin"));
            List<Technician> listFile = (List<Technician>) ois.readObject();
            ois.close();

            for (Technician p : listFile){
                // ta procurando só pelo ID e dá mensagem de confirmação
                if(p.getId()== id){
                    System.out.println("nome:" + p.getName() + "id:" + p.getId());
                    System.out.println("esse tecnico foi encontrado  e o login foi feito.");
                    return p;}}
            System.out.println("esse tecnico não foi encontrada.");

            // aqui tem que ter um loop lá na main que não deixa continuar

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("technician.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return null;

    }
    public static boolean saveTechnicianFile(Technician p){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("technician.bin"));
            List<Technician> listFile = (List<Technician>) ois.readObject();
            ois.close();

            listFile.add(p);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("technician.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }


    public static Attendant AttendantLogin(int id, String PS){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendant.bin"));
            List<Attendant> listFile = (List<Attendant>) ois.readObject();
            ois.close();

            for (Attendant p : listFile){
                // ta procurando só pelo ID e dá mensagem de confirmação
                if(p.getId()== id){
                    System.out.println("nome:" + p.getName() + "id:" + p.getId());
                    System.out.println("esse atendente foi encontrado  e o login foi feito.");
                    return p;}}
            System.out.println("esse atendente não foi encontrada.");

            // aqui tem que ter um loop lá na main que não deixa continuar

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("attendant.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return null;

    }
    public static boolean saveAttendantFile(Attendant p){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendant.bin"));
            List<Attendant> listFile = (List<Attendant>) ois.readObject();
            ois.close();

            listFile.add(p);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("attendant.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }



}
