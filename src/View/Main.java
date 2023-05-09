package View;

import Modelll.DAO.DaoPessoa;
import Modelll.DAO.DaoProdutoServico;
import Modelll.DAO.IniciaTodosOsArquivosSemDados;
import Modelll.Entity.Client;
import java.io.*;
import java.util.Scanner;
import Control.RepositorioOs;
import Control.RepositorioPerson;
import Control.RepositorioProdutoServico;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        IniciaTodosOsArquivosSemDados.main(args);

        if(DaoProdutoServico.retornarListaProduto().isEmpty()){
            DaoProdutoServico.fillArraylistProduto();
        }
        if(DaoProdutoServico.retornarListaServico().isEmpty()){
            DaoProdutoServico.fillArraylistService();
        }

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
                                RepositorioPerson.createPerson(new Client((RepositorioPerson.returnLenghtFile() + 1), "ClienteGenerico" + (RepositorioPerson.returnLenghtFile() + 1)));
                                break;
                            case 2:
                                RepositorioOs.createOS();
                                    break;
                            case 3:
                                DaoPessoa.listPersonFile();
                                break;
                            case 4:
                                RepositorioOs.listOs();
                                break;
                            case 5:
                                RepositorioOs.paymentOS();
                                break;
                            case 6:
                                RepositorioOs.cancelOS();
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
                        System.out.print("1-Listar OS\n2-Iniciar OS\n3-Finalizar OS\n4-Listar Produtos\n5-Listar Serviços\n");
                        System.out.print("10-Voltar para o menu principal\n");
                        System.out.print("Digite uma opção: ");
                        int opcaoTecnico = menuTecnico.nextInt();

                        switch (opcaoTecnico) {
                            case 1:
                                RepositorioOs.listOs();
                                break;
                            case 2:
                                RepositorioOs.startOs();
                                break;
                            case 3:
                                RepositorioOs.finalizeOS();
                                break;
                            case 4:
                                RepositorioProdutoServico.listProduct();
                                break;
                            case 5:
                                RepositorioProdutoServico.listService();
                                break;
                            case 6:
                                RepositorioOs.cancelOS();
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
                                RepositorioOs.summaryOS();
                                break;
                            case 2:
                                RepositorioProdutoServico.changeStock();
                                break;
                            case 3:
                                RepositorioProdutoServico.changeValueProduct();
                                break;
                            case 4:
                                RepositorioProdutoServico.changeValueService();
                                break;
                            case 10:
                                continuar = false;
                                break;

                default:
                    System.out.print("\nOpção Inválida!");
                    break;

                    }
            }}}}}


