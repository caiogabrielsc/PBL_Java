package Modelll.DAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Modelll.Entity.Attendant;
import Modelll.Entity.Person;
import Modelll.Entity.Technician;
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

            File person = new File("client.bin");
            if (!(person.exists())) {
                List<Person> listPer = new ArrayList<Person>();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
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

            File technician = new File("technician.bin");
            if (!(technician.exists())) {
                List<Technician> listTechnician = new ArrayList<Technician>();
                try {
                    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("technician.bin"));
                    oos2.writeObject(listTechnician);
                    oos2.close();
                    System.out.println("O arquivo necessário para os tecnicos não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File attendant = new File("attendant.bin");
            if (!(attendant.exists())) {
                List<Attendant> listAttendant = new ArrayList<Attendant>();
                try {
                    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("attendant.bin"));
                    oos2.writeObject(listAttendant);
                    oos2.close();
                    System.out.println("O arquivo necessário para os atendentes não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            File manager = new File("manager.bin");
            if (!(manager.exists())) {
                List<Person> listManager = new ArrayList<Person>();
                try {
                    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("manager.bin"));
                    oos2.writeObject(listManager);
                    oos2.close();
                    System.out.println("O arquivo necessário para os gerentes não existia mas foi criado.");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Todos os arquivos necessários presentes!");
        }

    }



