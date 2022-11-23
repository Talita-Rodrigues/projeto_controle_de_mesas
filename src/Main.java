import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 999;
        BancoDeDados bancoDeDados = new BancoDeDados();
        List<Mesa> mesaList = new ArrayList<>();
        List<Garcom> garcomList = new ArrayList<>();
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
                case 1:
                    bancoDeDados.cadastroDeMesa(mesaList, sc);
                    break;
                case 2:
                    bancoDeDados.removerMesa(mesaList, sc);
                    break;
                case 3:
                    bancoDeDados.buscarMesaPorNumero(mesaList, sc);
                    break;
                case 4:
                    bancoDeDados.buscarMesaPelaCapacidade(mesaList, sc);
                    break;
                case 5:
                    bancoDeDados.relatorioMesas(mesaList);
                    break;
                case 6:
                    bancoDeDados.cadastrarGarcom(garcomList, sc);
                    break;
                case 7:
                    bancoDeDados.removerGarcom(garcomList, mesaList, sc);
                    break;
                case 8:
                    bancoDeDados.vincularGarcomMesa(garcomList, mesaList, sc);
                    break;
                case 9:
                    bancoDeDados.desvincularGarcomMesa(mesaList, sc);
                    break;
                case 10:
                    bancoDeDados.abrirMesa(mesaList, sc);
                    break;
                case 11:
                    bancoDeDados.reservarMesa(mesaList,sc);
                    break;
                case 12:
                    bancoDeDados.liberarMesa(mesaList, sc);
                    break;
                case 13:
                    bancoDeDados.relatorioGarcons(garcomList);
                    break;
                case 14:
                    bancoDeDados.buscarGarcomPorEmail(garcomList, sc);
                    break;
                case 15:
                    bancoDeDados.relatorioDeMesasComUmaCapacidadeMaiorOuIgualAUmaDadaCapacidade(mesaList, sc);
                    break;
                case 16:
                    bancoDeDados.relatorioMesasPorGarcomOcupadas(mesaList, sc);
                    break;
                case 17:
                    bancoDeDados.relatorioDeMesasPorGarcomDesecupadas(mesaList, sc);
                    break;
                case 18:
                    bancoDeDados.relatorioDeMesasLivres(mesaList, sc);

            }
        }
    }
}