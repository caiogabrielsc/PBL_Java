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

    public static boolean createOS(Attendant user) throws IOException, ClassNotFoundException {
        if ((DaoPessoa.returnlistFile().isEmpty())) { //lista de pessoas vazia
            System.out.println("Sem clientes, logo não podemos abrir OS");
            return false;};

        DaoPessoa.listPersonFile();
        System.out.println("\nDigite o id do cliente para abrir OS:");
        Scanner idbuscado = new Scanner(System.in);
        int num = idbuscado.nextInt();

        if (DaoPessoa.returnPersonByIdFile(num) == null) {
            System.out.println("Não tem esse cliente na lista\n");
            return false;
        }

        Os os = new Os((DaoPessoa.returnPersonByIdFile(num)),user,null, (returnLenght() + 1), "trocar placa mae", 0, 0, "", 0, System.currentTimeMillis(), 0, 0);
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

    public static boolean startOs(Technician user) throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 1) {   //procura uma os que já está em andamento
                System.out.println("Tecnico já está em serviço, não pode iniciar OS.");
                return false;
            }
        }


        for (Os os : OsList) {
            if (os.getStatus() == 0) {
                System.out.println("\nIniciada a primeira da fila, OS id:" + os.getId());
                System.out.println("O tempo de espera foi: " + (System.currentTimeMillis() - os.getCreatetime()) / 1000 + " segundos.");
                DaoOs.startOsDaoFile(os.getId(), user);
                return true;
            }
        }
        System.out.println("\nNão temos OS para ser iniciada.");
        return false;
    }

    public static boolean finalizeOS() throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 1) {//procura uma os que já está em andamento
                System.out.println("\nFinalizando a OS com ID " + os.getId() + ", tecnico está disponível.");
                System.out.println("\n[1]Foi utilizado um produto ou [2] realizado um serviço ?");
                int opcao = ((new Scanner(System.in)).nextInt());
                if (opcao == 1) {  //se for produto
                    DaoProdutoServico.listProduct();
                    System.out.println("\nDigite o id do produto que vc utilizou nessa OS:");
                    int idProduto = ((new Scanner(System.in)).nextInt());

                    if(DaoProdutoServico.returnProdutoById(idProduto).getQtd() == 0){
                        System.out.println("Provavelmente vc não usou esse produto pq n tem ele no estoque.");
                        return false;
                    }

                    // finaliza a OS e seta o valor final
                    double value =  DaoProdutoServico.returnProdutoById(idProduto).getValue();
                    DaoOs.finalizeOsDaoFile(os.getId(), value);

                    // altera a quantidade do produto na lista via M.Modelll.DAO
                    int novaqtd = (DaoProdutoServico.returnProdutoById(idProduto).getQtd() - 1);
                    DaoProdutoServico.returnProdutoById(idProduto).setQtd(novaqtd);
                    System.out.println("\nAgora tem " + DaoProdutoServico.returnProdutoById(idProduto).getQtd() + "un desse produto no estoque.");

                    //checa se o estoque está baixo e gera aviso
                    if((DaoProdutoServico.returnProdutoById(idProduto).getQtd() < 3)){
                        System.out.println("O estoque desse produto está acabando, o Gerente deve repor!");}

                    System.out.println("Para realizar o pagamento de R$" + value + " o Atendente deve gerar fatura.");
                    System.out.println("O tempo de duração do serviço foi: " + (System.currentTimeMillis() - os.getStarttime()) / 1000 + "segundos.");

                } if (opcao == 2) { // se foi realizado um serviço
                    DaoProdutoServico.listService();
                    System.out.println("\nDigite o id do Serviço que vc utilizou nessa OS:");
                    int idServico = ((new Scanner(System.in)).nextInt());
                    double value = DaoProdutoServico.returnServiceById(idServico).getValue();
                    DaoOs.finalizeOsDaoFile(os.getId(), value);
                    System.out.println("Para realizar o pagamento de R$" + value + " o Atendente deve gerar fatura.");
                    System.out.println("O tempo de duração do serviço foi: " + (System.currentTimeMillis() - os.getStarttime()) / 1000 + "segundos.");

                }


                return true;
            }
        }
        System.out.println("\nNão foi encontrada nenhuma OS em andamento para poder finalizar");
        return false;
    }

    public static boolean paymentOS() throws IOException, ClassNotFoundException {
        List<Os> OsList = returnListOsFile();
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 2) {

                System.out.println("\nEncontrada a OS id:" + os.getId() + " aguardando pagamento.");
                System.out.println("O valor a ser pago é: RS" + os.getFinalvalue());
                System.out.println("Qual será a forma de pagamento ?\n1-Dinheiro ou 2-Cartão");

                String pagamento;
                int opcao = ((new Scanner(System.in)).nextInt());
                if (opcao == 1) {
                    pagamento = "Dinheiro";
                } else {
                    pagamento = "Cartão";};

                //System.out.println("Muito obrigado pelo pagamento.\nEntre 0 e 10, qual a sua nota para o serviço:");
                //int satisfacao = ((new Scanner(System.in)).nextInt());
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

