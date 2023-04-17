import Entity.Client;
import java.util.Scanner;

import RepositorioOs.RepositorioOs;
import RepositorioPessoa.RepositorioPerson;
import RepositorioProduto.RepositorioProduto;


public class Main {
    public static void main(String[] args) {
        RepositorioPerson rp = new RepositorioPerson();
        RepositorioOs ro = new RepositorioOs();
        RepositorioProduto rpdt = new RepositorioProduto();


        Scanner menu = new Scanner(System.in);

        //iniciar com os aberta:

        rp.createPerson(new Client((rp.returnLenght() + 1), "ClienteGenerico" + (rp.returnLenght() + 1)));
        rp.createPerson(new Client((rp.returnLenght() + 1), "ClienteGenerico" + (rp.returnLenght() + 1)));
        ro.createOS(rp,ro);
        ro.createOS(rp,ro);

        while (true) {
            System.out.print("\nMENU GERAL:\n1-Sou Atendente.\n2-Sou Tecnico.\n3-Sou Gerente.\n");
            System.out.print("4-Sair do sistema.\nDigite uma opção: ");
            int opcao = menu.nextInt();
            if (opcao == 4) {System.out.print("\nAté logo!");menu.close();}

            switch (opcao) {
                case 1:
                    Scanner menuAtendente = new Scanner(System.in);
                    boolean continuar = true;
                    while (continuar) {
                        System.out.print("------------MENU ATENDENTE---------\n");
                        System.out.print("\n1-Cadastrar Cliente\n2-Abrir OS\n3-Listar Clientes\n4-Listar OS\n");
                        System.out.print("10-Voltar para o menu principal\nDigite uma opção: ");
                        int opcaoAtendente = menuAtendente.nextInt();
                        switch (opcaoAtendente) {
                            case 1:
                                rp.createPerson(new Client((rp.returnLenght() + 1), "ClienteGenerico" + (rp.returnLenght() + 1)));
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
                        System.out.print("\n1-Listar OS\n2-Iniciar OS\n3-Finalizar OS\n");
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
                                ro.finalizeOS(rpdt);
                                break;
                            case 8:
                                rpdt.listProduct();
                            case 10:
                                continuar = false;
                                break;
                        }
                    }
                    /*
                case 3:
                    System.out.print("\nMENU GERENTE\n");
                    break;
                default:
                    System.out.print("\nOpção Inválida!");
                    break;

                     */


                    }
            }}}
