package Modelll.DAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Modelll.Entity.Person;
import Modelll.Os;
import Modelll.Produto;
import Modelll.Servico;

public class IniciaTodosOsArquivosSemDados {
        public static void main(String[] args) throws IOException, ClassNotFoundException {

            File os = new File("os.bin");
            if (!(os.exists())) {
                List<Os> listOs = new ArrayList<Os>();
                try {
                    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("os.bin"));
                    oos2.writeObject(listOs);
                    oos2.close();
                    System.out.println("O arquivo necessário para as OS não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File person = new File("person.bin");
            if (!(person.exists())) {
                List<Person> listPer = new ArrayList<Person>();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"));
                    oos.writeObject(listPer);
                    oos.close();

                    System.out.println("O arquivo necessário para Person não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File product = new File("product.bin");
            if (!(product.exists())) {
                List<Produto> listPro = new ArrayList<Produto>();
                try {
                    ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("product.bin"));
                    oos3.writeObject(listPro);
                    oos3.close();
                    System.out.println("O arquivo necessário para Produtos não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File service = new File("service.bin");
            if (!(service.exists())) {
                List<Servico> listSer = new ArrayList<Servico>();
                try {
                    ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream("service.bin"));
                    oos4.writeObject(listSer);
                    oos4.close();
                    System.out.println("O arquivo necessário para Serviços não existia mas foi criado.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Todos os arquivos necessários presentes!");
        }

    }



