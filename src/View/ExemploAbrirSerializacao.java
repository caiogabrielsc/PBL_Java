package View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import Modelll.Entity.Person;
    public class ExemploAbrirSerializacao {
        public static void main(String[] args) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"));
                List<Person> obj = (List<Person>) ois.readObject();
                ois.close();
                for(Person p : obj){
                    System.out.println("Nome: " + p.getName());
                    System.out.println("Id: " + p.getId());
                }
            } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        }
    }

