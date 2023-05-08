package Control;
import Modelll.DAO.DaoProdutoServico;
import java.io.IOException;
import java.util.Scanner;

public class RepositorioProdutoServico extends DaoProdutoServico {

    public boolean changeStock() throws IOException, ClassNotFoundException {
        listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o estoque:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do estoque:");
        int newqtd = ((new Scanner(System.in)).nextInt());

        DaoProdutoServico.changeStockDao(idProduto,newqtd);

        System.out.println("\nEstoque alterado.");
        return true;

    }

    public boolean changeValueProduct() throws IOException, ClassNotFoundException {
        listProduct();
        System.out.println("\nDigite o id do produto que vc deseja alterar o preço:");
        int idProduto = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do produto:");
        int newvalue = ((new Scanner(System.in)).nextInt());

        DaoProdutoServico.changeValueProductDao(idProduto, newvalue);

        System.out.println("\nValor alterado.");
        return true;

    }

    public boolean changeValueService() throws IOException, ClassNotFoundException {
        listService();
        System.out.println("\nDigite o id do serviço que vc deseja alterar o preço:");
        int id = ((new Scanner(System.in)).nextInt());
        System.out.println("\nDigite o novo valor do serviço:");
        int newvalue = ((new Scanner(System.in)).nextInt());

        DaoProdutoServico.changeValueServiceDao(id, newvalue);

        System.out.println("\nValor alterado.");
        return true;

    }




}
