import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int opcao = 999;
        BancoDeDados bancoDeDados = new BancoDeDados();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        while(opcao != 0){
            System.out.println("================= Sistema gerenciador de mesas =================");
            System.out.println("1 - Cadastro de mesa");
            System.out.println("2 - Remover mesa");
            System.out.println("3 - Buscar mesa pelo número");
            System.out.println("4 - Buscar mesa pela capacidade de clientes");
            System.out.println("5 - Relatório de mesas");
            System.out.println("6 - Cadastro de garçom");
            System.out.println("7 - Remover garçom");
            System.out.println("8 - Vincular garçom à mesa");
            System.out.println("9 - Desvincular garçom à mesa");
            System.out.println("10 - Abrir mesa");
            System.out.println("11 - Reservar mesa");
            System.out.println("12 - Liberar mesa");
            System.out.println("13 - Relatório de garçons");
            System.out.println("14 - Buscar garçom por e-mail");
            System.out.println("15 - Relatório com todas as mesas com capacidade maior ou igual a uma dada capacidade");
            System.out.println("16 - Relatório de mesas por garçom que estão ocupadas");
            System.out.println("17 - Relatório de mesas por garçom que não estão ocupadas");
            System.out.println("18 - Relatório de mesas livres");
            System.out.println("0 - SAIR");
            System.out.print("Informe uma opção: ");
            opcao = sc.nextInt();

            switch (opcao){
                case 0:
                    bancoDeDados.closeDataBase();
                    sc.close();
                    System.out.println("Até logo!");
                    break;
                case 1:
                    bancoDeDados.cadastroDeMesa(sc);
                    break;
                case 2:
                    bancoDeDados.removerMesa(sc);
                    break;
                case 3:
                    bancoDeDados.buscarMesaPorNumero(sc);
                    break;
                case 4:
                    bancoDeDados.buscarMesaPelaCapacidade(sc);
                    break;
                case 5:
                    bancoDeDados.relatorioMesas();
                    break;
                case 6:
                    bancoDeDados.cadastrarGarcom(sc);
                    break;
                case 7:
                    bancoDeDados.removerGarcom(sc);
                    break;
                case 8:
                    bancoDeDados.vincularGarcomMesa(sc);
                    break;
                case 9:
                    bancoDeDados.desvincularGarcomMesa(sc);
                    break;
                case 10:
                    bancoDeDados.abrirMesa(sc);
                    break;
                case 11:
                    bancoDeDados.reservarMesa(sc);
                    break;
                case 12:
                    bancoDeDados.liberarMesa(sc);
                    break;
                case 13:
                    bancoDeDados.relatorioGarcons();
                    break;
                case 14:
                    bancoDeDados.buscarGarcomPorEmail(sc);
                    break;
                case 15:
                    bancoDeDados.relatorioDeMesasComUmaCapacidadeMaiorOuIgualAUmaDadaCapacidade(sc);
                    break;
                case 16:
                    bancoDeDados.relatorioMesasPorGarcomOcupadas(sc);
                    break;
                case 17:
                    bancoDeDados.relatorioDeMesasPorGarcomDesocupadas(sc);
                    break;
                case 18:
                    bancoDeDados.relatorioDeMesasLivres();
                    break;
                default:
                    System.out.println("Opção inválida. Informe uma opção válida");
                    break;
            }
        }
    }
}