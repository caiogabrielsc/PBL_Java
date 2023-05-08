package View;

import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Client;
import java.io.*;
import java.util.Scanner;
import Control.RepositorioOs;
import Control.RepositorioPerson;
import Control.RepositorioProdutoServico;
import Modelll.Entity.Person;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RepositorioPerson rp = new RepositorioPerson();
        RepositorioOs ro = new RepositorioOs();
        RepositorioProdutoServico rpdt = new RepositorioProdutoServico();
        rpdt.fillArraylistProduto();
        rpdt.fillArraylistService();

        /*
        DaoPessoa.zerarArquivo();

        DaoPessoa.savePersonFile(new Person((1), "caio"));
        DaoPessoa.savePersonFile(new Person((2), "lara"));
        DaoPessoa.listPersonFile();
        DaoPessoa.deletePersonFile(1);
        DaoPessoa.deletePersonFile(2);
        DaoPessoa.listPersonFile();

         */


        rp.createPerson(new Client((rp.returnLenghtFile() + 1), "ClienteGenerico" + (rp.returnLenghtFile() + 1)));
        rp.createPerson(new Client((rp.returnLenghtFile() + 1), "ClienteGenerico" + (rp.returnLenghtFile() + 1)));
        // MAIN:
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.print("\n------------------------MENU GERAL-----------------------\n[1]-Sou Atendente.   [2]-Sou Tecnico.   [3]-Sou Gerente.\n");
            System.out.print("[10]-Sair do sistema.\nDigite uma opção: ");
            int opcao = menu.nextInt();
            if (opcao == 4) {System.out.print("\nAté logo!");menu.close();}

            switch (opcao) {
                case 1:
                    Scanner menuAtendente = new Scanner(System.in);
                    boolean continuar = true;
                    while (continuar) {
                        System.out.print("------------MENU ATENDENTE---------\n");
                        System.out.print("1-Cadastrar Cliente\n2-Abrir OS\n3-Listar Clientes\n4-Listar OS\n5-Gerar pagamento\n6-Cancelar OS\n");
                        System.out.print("10-Voltar para o menu principal\nDigite uma opção: ");
                        int opcaoAtendente = menuAtendente.nextInt();
                        switch (opcaoAtendente) {
                            case 1:
                                rp.createPerson(new Client((rp.returnLenghtFile() + 1), "ClienteGenerico" + (rp.returnLenghtFile() + 1)));
                                break;
                            case 2:
                                ro.createOS(rp,ro);
                                    break;
                            case 3:
                                rp.listPerson();
                                break;
                            case 4:
                                ro.listOs();
                                break;
                            case 5:
                                ro.paymentOS();
                                break;
                            case 6:
                                ro.cancelOS();
                                break;
                            case 10:
                                continuar = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    Scanner menuTecnico = new Scanner(System.in);
                    continuar = true;
                    while (continuar) {       /// while do atendente
                        System.out.print("------------MENU TECNICO---------\n");
                        System.out.print("1-Listar OS\n2-Iniciar OS\n3-Finalizar OS\n4-Listar Produtos\n");
                        System.out.print("10-Voltar para o menu principal\n");
                        System.out.print("Digite uma opção: ");
                        int opcaoTecnico = menuTecnico.nextInt();

                        switch (opcaoTecnico) {
                            case 1:
                                ro.listOs();
                                break;
                            case 2:
                                ro.startOs();
                                break;
                            case 3:
                                ro.finalizeOS();
                                break;
                            case 4:
                                rpdt.listProduct();
                                break;
                            case 5:
                                ro.cancelOS();
                            case 10:
                                continuar = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    Scanner menuGerente = new Scanner(System.in);
                    continuar = true;
                    while (continuar) {       /// while do atendente
                        System.out.print("------------ MENU GERENTE ---------\n");
                        System.out.print("1-Gerar relatório de OS\n2-Alterar estoque de produto\n3-Alterar valor de produto\n4-Alterar valor de serviço\n");
                        System.out.print("10-Voltar para o menu principal\n");
                        System.out.print("Digite uma opção: ");
                        int opcaoGerente = menuGerente.nextInt();

                        switch (opcaoGerente) {
                            case 1:
                                ro.summaryOS();
                                break;
                            case 2:
                                rpdt.changeStock();
                                break;
                            case 3:
                                rpdt.changeValueProduct();
                                break;
                            case 4:
                                rpdt.changeValueService();                                break;
                            case 10:
                                continuar = false;
                                break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;

                    }
            }}}}}


