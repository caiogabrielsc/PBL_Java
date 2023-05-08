package View;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Modelll.Entity.Person;

 public class ExemploSerializacao {
        public static void main(String[] args) {
            List<Person> list = new ArrayList<Person>();
            // criar um objeto da classe
            //Person p1 = new Person(1,"caio");

            try {
                // criar um ObjectOutputStream
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"));
                // gravar o objeto no arquivo
                //list.add(p1);
                oos.writeObject(list);

                // fechar o ObjectOutputStream
                oos.close();
                System.out.println(("agora o arquivo tá zerado."));

            } catch (IOException e) {e.printStackTrace();}
        }
    }



