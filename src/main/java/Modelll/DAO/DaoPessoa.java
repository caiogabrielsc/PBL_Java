package Modelll.DAO;
import Control.RepositorioPerson;
import Modelll.Entity.Attendant;
import Modelll.Entity.Client;
import Modelll.Entity.Person;
import Modelll.Entity.Technician;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoPessoa {
    public static void zerarArquivo() throws IOException {
        List<Client> list = new ArrayList<Client>();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(list);
            oos.close();
        }catch (IOException e) {e.printStackTrace();}}

    public static boolean listClientFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
        List<Client> listFile = (List<Client>) ois.readObject();
        ois.close();


        if (listFile.isEmpty()) {
            System.out.println("\nNão tem clientes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de clientes:");
        for (Client c : listFile) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + c.getId() + " nome:" + c.getName());
            System.out.println("id:" + c.getAdress() + " nome:" + c.getEmail());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }
    public static boolean saveClientFile(Client p){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();

            listFile.add(p);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }
    public static boolean deleteClientFile(int id){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();

            for (Client c : listFile){
                if(c.getId() == id){
                    listFile.remove(c);
                    break;}
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(listFile);
            oos.close();
        }catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }
    public static Client returnClientByIdFile(int id) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
        List<Client> listFile = (List<Client>) ois.readObject();
        ois.close();

        for (Client c : listFile) {
            if (c.getId() == id) {return c;}


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
        oos.writeObject(listFile);
        oos.close();
        }
        return null;
    }
    public static int returnLenghtClientFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();
            return listFile.size();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return 0;
    }
    public static List<Client> returnlistClientFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();
            return listFile;
        }catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return null;
    }
    public static boolean editNameClientFile(int id, String name){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();

            for (Client c : listFile){
                if(c.getId()== id){c.setName(name);
            }}

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }
    public static boolean editEmailClientFile(int id, String email){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();

            for (Client c : listFile){
                if(c.getId()== id){c.setEmail(email);
                }}

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }
    public static boolean editAdressClientFile(int id, String adress){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
            List<Client> listFile = (List<Client>) ois.readObject();
            ois.close();

            for (Client c : listFile){
                if(c.getId()== id){c.setAdress(adress);
                }}

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }



    public static Technician technicianLogin(int id, String password){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("technician.bin"));
            List<Technician> listFile = (List<Technician>) ois.readObject();
            ois.close();

            for (Technician p : listFile){
                if(p.getId()== id){
                    if(Objects.equals(p.getPassword(), password)){
                        System.out.println("nome:" + p.getName() + "id:" + p.getId());
                        System.out.println("esse tecnico foi encontrado  e o login foi feito.");
                        return p;}
                }
            }
            System.out.println("nao achou tecnico no for");

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
    public static boolean listTechnicianFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("technician.bin"));
        List<Technician> listFile = (List<Technician>) ois.readObject();
        ois.close();

        if (listFile.isEmpty()) {
            System.out.println("\nNão tem atendentes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de atendentes:");
        for (Technician a : listFile) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + a.getId() + " nome:" + a.getName() + " PS: "+ a.getPassword());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }
    public static int returnLenghtTechnicianFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("technician.bin"));
            List<Technician> listFile = (List<Technician>) ois.readObject();
            ois.close();
            return listFile.size();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return 0;
    }


    public static Attendant AttendantLogin(int id, String password){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendant.bin"));
            List<Attendant> listFile = (List<Attendant>) ois.readObject();
            ois.close();

            for (Attendant p : listFile){
                if(p.getId()== id){
                    if(Objects.equals(p.getPassword(), password)){
                        System.out.println("nome:" + p.getName() + "id:" + p.getId());
                        System.out.println("esse atendente foi encontrado  e o login foi feito.");
                        return p;}
                }
            }
            System.out.println("esse atendente não foi encontrada.");

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
    public static boolean listAttendantFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendant.bin"));
        List<Attendant> listFile = (List<Attendant>) ois.readObject();
        ois.close();


        if (listFile.isEmpty()) {
            System.out.println("\nNão tem atendentes cadastrados.\n");
            return false;
        }
        System.out.println("          Lista de atendentes:");
        for (Attendant a : listFile) {
            System.out.println("-------------------------------------");
            System.out.println("id:" + a.getId() + " nome:" + a.getName() + " PS: "+ a.getPassword());
        }
        System.out.println("-------------------------------------\n");
        return true;
    }
    public static int returnLenghtAttendantFile(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("attendant.bin"));
            List<Attendant> listFile = (List<Attendant>) ois.readObject();
            ois.close();
            return listFile.size();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return 0;
    }



}
