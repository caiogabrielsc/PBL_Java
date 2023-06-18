package Modelll.DAO;

import Modelll.Entity.Person;
import Modelll.Entity.Technician;
import Modelll.Os;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class DaoOs {
    public static void zerarArquivoOs() throws IOException {
        List<Os> list = new ArrayList<Os>();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
            oos.writeObject(list);
            oos.close();
        }catch (IOException e) {e.printStackTrace();}}

    public static boolean saveOsFile(Os os){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
            List<Os> listFile = (List<Os>) ois.readObject();
            ois.close();

            listFile.add(os);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
            oos.writeObject(listFile);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return true;
    }

    public static boolean startOsDaoFile(int id, Technician user) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        for (Os os : listFile) {
            if (os.getId() == id) {
                os.setStatus(1);
                os.setTechnician(user);
                os.setStarttime(System.currentTimeMillis());
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
        oos.writeObject(listFile);
        oos.close();
        return true;
    }

    public static boolean finalizeOsDaoFile(int id, double value) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        for (Os os : listFile) {
            if (os.getId() == id) {
                os.setStatus(2);
                os.setFinishtime(System.currentTimeMillis());
                os.setFinalvalue(value);
            }
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
        oos.writeObject(listFile);
        oos.close();
        return true;
    }

    public static boolean paymantOsDaoFile(int id, String pagm, int sats) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        for (Os os : listFile) {
            if (os.getId() == id) {
                os.setPayment(pagm);
                os.setSatisfaction(sats);
                os.setStatus(3);
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
        oos.writeObject(listFile);
        oos.close();
        return true;
    }

    public static boolean cancelOsDaoFile(int id) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        for (Os os : listFile) {
            if (os.getId() == id) {
                os.setStatus(4);
            }
        }

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("os.bin"));
        oos.writeObject(listFile);
        oos.close();
        return true;
    }

    public static boolean listOsFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        if (listFile.isEmpty() == true) {
            System.out.println("Não tem OS cadastradas");
            return false;
        }
        System.out.println("            Lista de OS:");
        for (Os os : listFile) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("idOs:" + os.getId() + " | cliente:" + os.client.getName() + " | status:" + os.getStatus() + " | tecnico:"+os.getTechnician().getName());
        }
        System.out.println("---------------------------------------------------------------\n");

        return true;
    }

    public static List<Os> returnListOsFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("os.bin"));
        List<Os> listFile = (List<Os>) ois.readObject();
        ois.close();

        return listFile;
    }



}
