import Entity.Client;
import java.util.Scanner;

import RepositorioOs.Os;
import RepositorioOs.RepositorioOs;
import RepositorioPessoa.RepositorioPerson;

public class Main {
    public static void main(String[] args) {
        RepositorioPerson rp = new RepositorioPerson();
        RepositorioOs ro = new RepositorioOs();

        //  ****************** MENU PRINCIPAL *************************
        Scanner menu = new Scanner (System.in);
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
            switch (opcao) {
                //   ********************  MENU ATENDENTE *******************
                case 1:
                    System.out.print("------------MENU ATENDENTE---------\n");
                    Scanner menuAtendente = new Scanner (System.in);
                    while (true) {
                        System.out.print("1-Cadastrar Cliente\n");
                        System.out.print("2-Abrir OS\n");
                        System.out.print("3-Voltar para o menu principal\n");
                        System.out.print("Digite uma opção: ");
                        int opcaoAtendente = menuAtendente.nextInt();
                        if (opcaoAtendente == 3) {
                            menuAtendente.close();
                        }
                        switch (opcaoAtendente) {
                            case 1:
                                System.out.print("\nCliente Cadastrado");
                                break;
                            case 2:
                                System.out.print("\nOS aberta\n");
                                break;
                            default:
                                System.out.print("\nOpção Inválida!");
                                break;}
                        break;
                    }
                    break;
                case 2:
                    System.out.print("\nMENU TECNICO\n");
                    break;
                case 3:
                    System.out.print("\nMENU GERENTE\n");
                    break;
                default:
                    System.out.print("\nOpção Inválida!");
                    break;
            }
        }}}




