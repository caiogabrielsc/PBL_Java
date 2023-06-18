package Control;
import Modelll.DAO.DaoOs;
import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Attendant;
import Modelll.Entity.Technician;
import Modelll.Os;
import Modelll.Entity.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelll.DAO.DaoProdutoServico;

public class RepositorioOs  extends DaoOs {

    public static boolean createOS(Attendant user, int idCLiente, String descricao) throws IOException, ClassNotFoundException {
        if ((DaoPessoa.returnlistClientFile().isEmpty())) { //lista de pessoas vazia
            System.out.println("Sem clientes, logo não podemos abrir OS");
            return false;};

        /*
        DaoPessoa.listClientFile();
        System.out.println("\nDigite o id do cliente para abrir OS:");
        Scanner idbuscado = new Scanner(System.in);
        int num = idbuscado.nextInt();



        if (DaoPessoa.returnClientByIdFile(num) == null) {
            System.out.println("Não tem esse cliente na lista\n");
            return false;
        }
         */

        Os os = new Os((returnLenght() + 1),(DaoPessoa.returnClientByIdFile(idCLiente)),user,null, descricao, 0, 0, "", 0, System.currentTimeMillis(), 0, 0);
        saveOsFile(os);
        System.out.print("\nOS aberta.\n");
        return true;
    }

    public static int returnLenght() throws IOException, ClassNotFoundException {
        return returnListOsFile().size();
    }

    public static boolean listOs() throws IOException, ClassNotFoundException {
        DaoOs.listOsFile();
        return true;
    }

    public static int startOs(Technician user) throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();

        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return -1;
        }

        // VARREDURA DE TODAS AS OS EM ANDAMENTO
        for (Os os : OsList) {
            if (os.getStatus() == 1) {  // todas em andamento
                if(os.getTechnician().getId() == user.getId()){  //buscando alguma que esse técnico já tá
                    System.out.println("Tecnico já está em serviço, não pode iniciar OS.");
                    return (-1);
                }
            }
        }

        // VARREDURA BUSCANDO A PRIMEIRA OS DISPONÍVEL PARA INICIAR
        for (Os os : OsList) {
            if (os.getStatus() == 0) {
                System.out.println("\nIniciada a primeira da fila, OS id:" + os.getId());
                System.out.println("O tempo de espera foi: " + (System.currentTimeMillis() - os.getCreatetime()) / 1000 + " segundos.");
                DaoOs.startOsDaoFile(os.getId(), user);
                return os.getId();
            }
        }
        System.out.println("\nNão temos OS para ser iniciada.");
    return -1;
    }

    public static int finalizeOS(Technician user,int id, String opcao) throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return -1;
        }

        for (Os os : OsList) {
            if (os.getStatus() == 1 && os.getTechnician().getId() == user.getId()) {
                if (opcao == "produto") {
                    // finaliza a OS e seta o valor final
                    double value = DaoProdutoServico.returnProdutoById(id).getValue();
                    DaoOs.finalizeOsDaoFile(os.getId(), value);

                    // altera a quantidade do produto na

                    int novaqtd = (DaoProdutoServico.returnProdutoById(id).getQtd() - 1);
                    DaoProdutoServico.changeStockDao(id,novaqtd);

                    DaoProdutoServico.returnProdutoById(id).setQtd(novaqtd);

                    DaoProdutoServico.listProduct();

                    //checa se o estoque está baixo e gera aviso
                    if ((DaoProdutoServico.returnProdutoById(id).getQtd() < 3)) {// MANDAR AVISO PRO GERENTE
                    }

                }

                if (opcao == "servico") {
                    double value = DaoProdutoServico.returnServiceById(id).getValue();
                    DaoOs.finalizeOsDaoFile(os.getId(), value);
                }
                return os.getId();
            }
        }
        return -1;
    }

    public static boolean paymentOS() throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 2) {
                /*
                System.out.println("\nEncontrada a OS id:" + os.getId() + " aguardando pagamento.");
                System.out.println("O valor a ser pago é: RS" + os.getFinalvalue());
                System.out.println("Qual será a forma de pagamento ?\n1-Dinheiro ou 2-Cartão");
                 */

                String pagamento;
                // input STRING NO FXML
                int opcao = ((new Scanner(System.in)).nextInt());
                if (opcao == 1) {pagamento = "Dinheiro";} else {pagamento = "Cartao";};

                int satisfacao = 10;
                DaoOs.paymantOsDaoFile(os.getId(),pagamento,satisfacao);
                System.out.println("Pagamento feito e serviço finalizado, muito obrigado.");
                return true;
            }
        }
        System.out.println("\nNão foi encontrada OS aguardando pagamento.");
        return false;
    }

    public static boolean cancelOS() throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        System.out.println("Digite o id da OS que vc quer cancelar:");
        int idcancelar = ((new Scanner(System.in)).nextInt());
        for (Os os : OsList) {
            if (os.getId() == idcancelar) {
                if(os.getStatus()==2 || os.getStatus()==3){
                    System.out.println("\nSó podem ser canceladas OSs em espera ou em serviço.");
                    return false;}


                DaoOs.cancelOsDaoFile(os.getId());
                System.out.println("\nA OS id "+idcancelar+" teve seu status definido como cancelado.");
                return true;}
        }
        System.out.println("\nEsse OsID não foi encontrado.");
        return false;}

    public static boolean summaryOS() throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        ArrayList<Long> listaTempodeEspera = new ArrayList<Long>();
        ArrayList<Long> listaTempoemServico = new ArrayList<Long>();
        ArrayList<Double> listaValorFinal = new ArrayList<Double>();
        ArrayList<Integer> listaSatisfacao = new ArrayList<Integer>();

        for(Os os : OsList){
            if(os.getStatus()==3){
                listaTempodeEspera.add(os.getStarttime()-os.getCreatetime());
                listaTempoemServico.add(os.getFinishtime()-os.getStarttime());
                listaValorFinal.add(os.getFinalvalue());
                listaSatisfacao.add(os.getSatisfaction());}
        }
        if(listaTempodeEspera.size()==0){
            System.out.println("Não tem Os finalizada para poder realizar as médias");
            return false;
        }
        //depois de ter povoado as listas:
        Long mEspera = 0L;
        Long mServico = 0L;
        double valorFinal = 0;
        int satisfacao = 0;

        for(int i = 0; i < listaTempodeEspera.size();i++){
            mEspera = mEspera + listaTempodeEspera.get(i);
            mServico = mServico + listaTempoemServico.get(i);
            valorFinal = valorFinal + listaValorFinal.get(i);
            satisfacao = satisfacao + listaSatisfacao.get(i);
        }
        mEspera = (mEspera/listaSatisfacao.size());
        mServico = (mServico/listaSatisfacao.size());
        valorFinal= (valorFinal/listaSatisfacao.size());
        satisfacao = (satisfacao/listaSatisfacao.size());

        System.out.println("\nMédias de atendimentos:\n");
        System.out.println(mEspera/1000 +" segundos é a média de tempo de espera.");
        System.out.println(mServico/1000 +" segundos é a média de tempo em serviço.");
        System.out.println(valorFinal + "R$ é a média de valor final para os serviços.");
        System.out.println(satisfacao + " é a média de satisfação entre os clientes.");
        return true;
    }



    /*
     (  as funções a seguir foram criadas mas não estão sendo utilizadas devido a natureza de "teste" do programa
      elas irão entrar apenas na versão final)

    public boolean editDescriptionOs(int idbuscado, String newDescription) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setDescription(newDescription);
                return true;
            }
        }
        return false;
    }

    public boolean editStatusOs(int idbuscado, int newStatus) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public boolean editClientOs(int idbuscado, Person newClient) {
        for (Os os : OsList) {
            if (os.getId() == idbuscado) {
                os.setClient(newClient);
                return true;
            }
        }
        return false;
    }

     */
}

