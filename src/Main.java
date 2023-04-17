import Entity.Client;
import java.util.Scanner;

import RepositorioOs.Os;
import RepositorioOs.RepositorioOs;
import RepositorioPessoa.RepositorioPerson;

public class Main {
    public static void main(String[] args) {
        RepositorioPerson rp = new RepositorioPerson();
        RepositorioOs ro = new RepositorioOs();


        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.print("\nMENU GERAL:\n");
            System.out.print("1-Sou Atendente.\n");
            System.out.print("2-Sou Tecnico. \n");
            System.out.print("3-Sou Gerente.\n");
            System.out.print("4-Sair do sistema.\n");
            System.out.print("Digite uma opção: ");
            int opcao = menu.nextInt();
            if (opcao == 4) {
                System.out.print("\nAté logo!");
                menu.close();
            }
            // SWITCH MENU GERAL
            switch (opcao) {
                //   ********************  MENU ATENDENTE *******************
                case 1:
                    Scanner menuAtendente = new Scanner(System.in);
                    boolean continuar = true;
                    while (continuar) {
                        System.out.print("------------MENU ATENDENTE---------\n");
                        System.out.print("\n1-Cadastrar Cliente\n2-Abrir OS\n3-Listar Clientes\n4-Listar OS\n");
                        System.out.print("10-Voltar para o menu principal\nDigite uma opção: ");
                        int opcaoAtendente = menuAtendente.nextInt();
                        switch (opcaoAtendente) {
                            case 1:      // REGISTER CLIENT
                                Client clientGenerico = new Client((rp.returnLenght() + 1), "ClienteGenerico" + (rp.returnLenght() + 1));
                                rp.savePerson(clientGenerico);
                                System.out.print("\nCliente Cadastrado\n");
                                break;
                            case 2:      // ABRIR OS
                                // list person retorna falso se n tiver cliente
                                if(rp.listPerson() == false){
                                    System.out.println("Logo não podemos abrir OS");
                                    break;
                                };
                                System.out.println("\nDigite o id do cliente para abrir OS:");
                                Scanner idbuscado = new Scanner(System.in);
                                int num = idbuscado.nextInt();

                                if(rp.returnPersonById(num) == null){
                                    System.out.println("Não tem esse cliente na lista\n");
                                    break;
                                }
                                Os os = new Os((rp.returnPersonById(num)), (ro.returnLenght() + 1), "trocar placa mae", 0, 0);
                                ro.saveOS(os);
                                System.out.print("\nOS aberta\n");
                                break;
                            case 3:
                                rp.listPerson();
                                break;
                            case 4:
                                ro.listOs();
                                break;
                            case 10:   // SAIR DO MENU ATENDENTE
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
                                ro.finalizeOS();
                                break;
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
