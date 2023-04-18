package RepositorioOs;
import Entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import RepositorioPessoa.RepositorioPerson;
import RepositorioEstoque.RepositorioProduto;


public class RepositorioOs { //implements IRepositorioOs {

    List<Os> OsList = new ArrayList<Os>();

    public boolean createOS(RepositorioPerson rp, RepositorioOs ro) {
        if (!rp.listPerson()) { //lista de pessoas vazia
            System.out.println("Logo não podemos abrir OS");
            return false;
        }
        ;

        System.out.println("\nDigite o id do cliente para abrir OS:");
        Scanner idbuscado = new Scanner(System.in);
        int num = idbuscado.nextInt();

        if (rp.returnPersonById(num) == null) {
            System.out.println("Não tem esse cliente na lista\n");
            return false;
        }

        Os os = new Os((rp.returnPersonById(num)), (ro.returnLenght() + 1), "trocar placa mae", 0, 0, "", 0, System.currentTimeMillis(), 0, 0);
        saveOS(os);
        System.out.print("\nOS aberta.\n");
        return true;
    }

    public boolean saveOS(Os os) {
        try {
            OsList.add(os);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

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

    public int returnLenght() {
        return OsList.size();
    }

    public boolean listOs() {
        if (OsList.isEmpty() == true) {
            System.out.println("Não tem OS cadastradas");
            return false;
        }
        System.out.println("            Lista de OS:");
        for (Os os : OsList) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("idOs:" + os.getId() + " | cliente:" + os.client.getName() + " | status:" + os.getStatus());
        }
        System.out.println("---------------------------------------------------------------\n");

        return true;
    }

    public boolean startOs() {
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
                os.setStatus(1);
                os.setStarttime(System.currentTimeMillis());
                System.out.println("\nIniciada a primeira da fila, OS id:" + os.getId());
                System.out.println("O tempo de espera foi: " + (os.getStarttime() - os.getCreatetime()) / 1000 + "segundos.");

                return true;
            }
        }
        System.out.println("\nNão temos OS para serem iniciadas.");
        return false;
    }

    public boolean finalizeOS(RepositorioProduto rpdt) {
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 1) { //procura uma os que já está em andamento
                os.setStatus(2);
                os.setFinishtime(System.currentTimeMillis());

                System.out.println("\n[1]Foi utilizado um produto ou [2] realizado um serviço ?");
                int opcao = ((new Scanner(System.in)).nextInt());
                if (opcao == 1) {  //se for produto
                    rpdt.listProduct();
                    System.out.println("\nDigite o id do produto que vc utilizou nessa OS:");
                    int idProduto = ((new Scanner(System.in)).nextInt());

                    // SETA O VALOR FINAL E REDUZ O ESTOQUE EM UMA UNIDADE
                    os.setFinalvalue(rpdt.returnProdutoById(idProduto).getValue());
                    int novaqtd = (rpdt.returnProdutoById(idProduto).getQtd() - 1);
                    rpdt.returnProdutoById(idProduto).setQtd(novaqtd);
                    System.out.println("\nAgora tem " + rpdt.returnProdutoById(idProduto).getQtd() + "un desse produto no estoque.");

                } else {
                    rpdt.listService();
                    System.out.println("\nDigite o id do Serviço que vc utilizou nessa OS:");
                    int idServico = ((new Scanner(System.in)).nextInt());
                    os.setFinalvalue(rpdt.returnServiceById(idServico).getValue());
                }
                System.out.println("Finalizada a OS com ID " + os.getId() + ", tecnico está disponível.");
                System.out.println("Para realizar o pagamento de R$" + os.getFinalvalue() + " o Atendente deve gerar fatura.");
                System.out.println("O tempo de duração do serviço foi: " + (os.getFinishtime() - os.getStarttime()) / 1000 + "segundos.");
                return true;
            }
        }
        System.out.println("\nNão foi encontrada nenhuma OS em andamento para poder finalizar");
        return false;
    }

    public boolean paymentOS() {
        if (OsList.isEmpty()) {
            System.out.println("\nNão temos OS cadastradas\n");
            return false;
        }
        for (Os os : OsList) {
            if (os.getStatus() == 2) {
                os.setStatus(3);
                System.out.println("\nEncontrada a OS id:" + os.getId() + " aguardando pagamento.");
                System.out.println("O valor a ser pago é: RS" + os.getFinalvalue());
                System.out.println("Qual será a forma de pagamento ?\n1-Dinheiro ou 2-Cartão");

                int opcao = ((new Scanner(System.in)).nextInt());
                if (opcao == 1) {
                    os.setPayment("Dinheiro");
                } else {
                    os.setPayment("Cartão");};

                System.out.println("Muito obrigado pelo pagamento.\nEntre 0 e 10, qual a sua nota para o serviço:");
                int satisfacao = ((new Scanner(System.in)).nextInt());
                os.setSatisfaction(satisfacao);
                System.out.println("Serviço finalizado.");
                return true;
            }
        }
        System.out.println("\nNão foi encontrada OS aguardando pagamento.");
        return false;
    }

}

