import java.util.List;
import java.util.Scanner;

public class BancoDeDados {

    public void cadastroDeMesa(List<Mesa> mesaList, Scanner sc){
        Long idMesa = Long.valueOf(1);
        Long numeroMesa = Long.valueOf(1);
        if(!mesaList.isEmpty()){
            idMesa = mesaList.get(mesaList.size() - 1).getIdMesa() + 1;
            numeroMesa = mesaList.get(mesaList.size() - 1).getNumeroMesa() + 1;
        }
        String situacao = "livre";
        System.out.println("Informa a capacidade máxima da mesa: ");
        Integer capacidadeMaxima = sc.nextInt();

        Mesa mesa = new Mesa(idMesa, numeroMesa, situacao, capacidadeMaxima, null);
        mesaList.add(mesa);
        System.out.println("Mesa cadastrada com sucesso!");
    }

    public void relatorioMesas(List<Mesa> mesaList){
        System.out.println("================================= RELATÓRIO DE MESAS =================================");
        for(int i = 0; i < mesaList.size(); i++){
            System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
            System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
            System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
            if(null != mesaList.get(i).getGarcom()){
                System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
            } else {
                System.out.println("Garçom responsável: ");
            }
            System.out.println("=================================");
        }
    }

    public void removerMesa(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o numero da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;

        for (int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getNumeroMesa() == numeroMesa){
                mesa = mesaList.get(i);
            }
        }

        if(null != mesa){
            mesaList.remove(mesa);
            System.out.println("Mesa " + numeroMesa + " removida com sucesso!");
        } else {
            System.out.println("Número de mesa inválido.");
        }
    }

    public void buscarMesaPorNumero(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o numero da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;
        for(int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getNumeroMesa() == numeroMesa){
                    mesa = mesaList.get(i);
                    System.out.println("=================================");
                    System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                    System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                    System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                    if(null != mesaList.get(i).getGarcom()){
                        System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                    } else {
                        System.out.println("Garçom responsável: ");
                    }
                    System.out.println("=================================");
                    break;
            }
        }

        if(null == mesa){
            System.out.println("Numero de mesa inválido.");
        }
    }

    public void buscarMesaPelaCapacidade(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informa a capacidade da mesa: ");
        Integer capacidade = sc.nextInt();

        System.out.println("=================================");
        for(int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getCapacidadeMaxima().equals(capacidade)){
                System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                if(null != mesaList.get(i).getGarcom()){
                    System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                } else {
                    System.out.println("Garçom responsável: ");
                }
                System.out.println("=================================");
                break;
            }
        }
    }

    public void cadastrarGarcom(List<Garcom> garcomList, Scanner sc){
        Long idGarcom = Long.valueOf(1);
        if(!garcomList.isEmpty()){
            idGarcom = garcomList.get(garcomList.size() - 1).getIdGarcom() + 1;
        }
        System.out.println("Informe o nome: ");
        String nome = sc.next();
        System.out.println("Informe o cpf: ");
        String cpf = sc.next();
        System.out.println("Informe a data de nascimento (DD/MM/YYYY)");
        String dataNascimento = sc.next();
        System.out.println("Informe o e-mail: ");
        String email = sc.next();
        System.out.println("Informe o telefone: ");
        String telefone = sc.next();
        System.out.println("Informe o sexo (F - feminino ou M - masculino): ");
        String sexo = sc.next();
        while (!"F".equals(sexo) && !"M".equals(sexo)){
            System.out.println("Informe F ou M: ");
            sexo = sc.next();
        }
        System.out.println("Informe o salário: ");
        Double salario = sc.nextDouble();

        Garcom garcom = new Garcom(idGarcom, nome, cpf, dataNascimento, email, telefone, sexo, salario);
        garcomList.add(garcom);
        System.out.println("Garçom cadsatrado com sucesso!");
    }

    public void relatorioGarcons(List<Garcom> garcomList){
        System.out.println("================================= RELATÓRIO DE GARÇONS =================================");
        for(int i = 0; i < garcomList.size(); i++){
            System.out.println("CÓDIGO: " + garcomList.get(i).getIdGarcom());
            System.out.println("NOME: " + garcomList.get(i).getNome());
            System.out.println("CPF: " + garcomList.get(i).getCpf());
            System.out.println("DATA DE NASCIMENTO: " + garcomList.get(i).getDataNascimento());
            System.out.println("E-MAIL: " + garcomList.get(i).getEmail());
            System.out.println("TELEFONE: " + garcomList.get(i).getTelefone());
            System.out.println("SEXO: " + garcomList.get(i).getSexo());
            System.out.println("SALARIO: " + garcomList.get(i).getSalarioFixo());
            System.out.println("=================================");
        }
    }
    public void removerGarcom(List<Garcom> garcomList, List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o código do garçom que deseja remover: ");
        Long codigoGarcom = sc.nextLong();

        for(int i = 0; i < mesaList.size(); i++){
            if(null != mesaList.get(i).getGarcom()) {
                if(codigoGarcom.compareTo(mesaList.get(i).getGarcom().getIdGarcom()) == 0){
                    System.out.println("Este garçom não pode ser removido pois gerencia uma mesa!");
                    return;
                }
            }
        }
        Garcom garcom = null;
        for(int i = 0; i < garcomList.size(); i ++){
            if(codigoGarcom.compareTo(garcomList.get(i).getIdGarcom()) == 0){
                garcom = garcomList.get(i);
                break;
            }
        }

        if(null != garcom){
            garcomList.remove(garcom);
            System.out.println("Garçom " + garcom.getNome() + " - " + garcom.getCpf() + " removido com sucesso!");
        } else {
            System.out.println("Garçom inexistente!");
        }

    }
    public void vincularGarcomMesa(List<Garcom> garcomList, List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o código do garçom: ");
        Long codigoGarcom = sc.nextLong();
        System.out.println("Informe o numero da mesa: ");
        Long numeroMesa = sc.nextLong();

        Garcom garcom = null;
        Mesa mesa = null;

        for(int i = 0; i < garcomList.size(); i++){
            if(codigoGarcom.compareTo(garcomList.get(i).getIdGarcom()) == 0){
                garcom = garcomList.get(i);
                break;
            }
        }

        if(null == garcom){
            System.out.println("Garçom inexistente.");
            return;
        }

        for(int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getNumeroMesa().equals(numeroMesa)){
                mesa = mesaList.get(i);
                if(null != mesaList.get(i).getGarcom()){
                    System.out.println("Esta mesa ja possui um garçom vinculado!");
                } else {
                    mesaList.get(i).setGarcom(garcom);
                    System.out.println("Garçom " + garcom.getNome() + " - " + garcom.getCpf() + " vinculado à mesa " + mesaList.get(i).getNumeroMesa() + " com sucesso!");
                }
                break;
            }
        }
        if(null == mesa){
            System.out.println("Número de mesa inválido.");
            return;

        }
    }

    public void desvincularGarcomMesa(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o numero da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;


        for(int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getNumeroMesa().equals(numeroMesa)){
                mesa = mesaList.get(i);
                Garcom garcom = mesaList.get(i).getGarcom();

                if(null != garcom){
                    mesaList.get(i).setGarcom(null);
                    System.out.println("Garçom " + garcom.getNome() + " - " + garcom.getCpf() + " desvinculado da mesa " + mesaList.get(i).getNumeroMesa() + " com sucesso!");
                } else {
                    System.out.println("Mesa sem garçom vinculado");
                }

                break;
            }
        }
        if(null == mesa){
            System.out.println("Numero de mesa inválido.");
        }
    }

    public void abrirMesa(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o número da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;
        for(int i = 0; i < mesaList.size(); i++){
            if(numeroMesa.compareTo(mesaList.get(i).getNumeroMesa()) == 0){
                mesa =  mesaList.get(i);
                mesaList.get(i).setSituacao("ocupada");
                System.out.println("Mesa " + mesaList.get(i).getNumeroMesa() + " aberta com sucesso!");
                break;
            }
        }

        if(null == mesa){
            System.out.println("Numero de mesa inválido.");
        }
    }

    public void reservarMesa(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o número da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;

        for(int i =0; i < mesaList.size(); i++){
            if(numeroMesa.compareTo(mesaList.get(i).getNumeroMesa()) == 0){
                mesa = mesaList.get(i);
                mesaList.get(i).setSituacao("reservada");
                System.out.println("Mesa " + mesaList.get(i).getNumeroMesa() + " reservado com sucesso!");
                break;
            }
        }

        if(null == mesa){
            System.out.println("Número de mesa inválido.");
        }
    }

    public void liberarMesa(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o número da mesa: ");
        Long numeroMesa = sc.nextLong();
        Mesa mesa = null;

        for(int i = 0; i < mesaList.size(); i++){
            if(numeroMesa.compareTo(mesaList.get(i).getNumeroMesa()) == 0){
                mesa = mesaList.get(i);
                mesaList.get(i).setSituacao("livre");
                System.out.println("Mesa " + mesaList.get(i).getNumeroMesa() + " liberada com sucesso!");
                break;
            }
        }

        if(null == mesa){
            System.out.println("Número de mesa inválido.");
        }
    }

    public void buscarGarcomPorEmail(List<Garcom> garcomList, Scanner sc){
        System.out.println("Infrome o e-mail do garçom: ");
        String email = sc.next();

        System.out.println("=================================");
        for(int i = 0; i < garcomList.size(); i++){
            if(email.equalsIgnoreCase(garcomList.get(i).getEmail())){
                System.out.println("NOME: " + garcomList.get(i).getNome());
                System.out.println("CPF: " + garcomList.get(i).getCpf());
                System.out.println("DATA DE NASCIMENTO: " + garcomList.get(i).getDataNascimento());
                System.out.println("E-MAIL: " + garcomList.get(i).getEmail());
                System.out.println("TELEFONE: " + garcomList.get(i).getTelefone());
                System.out.println("SEXO: " + garcomList.get(i).getSexo());
                System.out.println("SALARIO: " + garcomList.get(i).getSalarioFixo());
                System.out.println("=================================");
                break;
            }
        }
    }

    public void relatorioDeMesasComUmaCapacidadeMaiorOuIgualAUmaDadaCapacidade(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informa a capacidade da mesa: ");
        Integer capacidade = sc.nextInt();

        System.out.println("=================================");
        for(int i = 0; i < mesaList.size(); i++){
            if(mesaList.get(i).getCapacidadeMaxima() >= capacidade){
                System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                if(null != mesaList.get(i).getGarcom()){
                    System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                } else {
                    System.out.println("Garçom responsável: ");
                }
                System.out.println("=================================");
            }
        }
    }

    public void relatorioMesasPorGarcomOcupadas(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o código do garçom: ");
        Long codigoGarcom = sc.nextLong();
        Garcom garcom = null;

        System.out.println("=================================");
        for(int i = 0; i < mesaList.size(); i++){
            if(null != mesaList.get(i).getGarcom()){
                if(codigoGarcom.compareTo(mesaList.get(i).getGarcom().getIdGarcom()) == 0) {
                    garcom = mesaList.get(i).getGarcom();
                }
                if((codigoGarcom.compareTo(mesaList.get(i).getGarcom().getIdGarcom()) == 0) && ("ocupada".compareToIgnoreCase(mesaList.get(i).getSituacao()) == 0)){
                    System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                    System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                    System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                    System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                    System.out.println("=================================");
                }
            }
        }

        if(null == garcom){
            System.out.println("Garçom inexistente.");
        }
    }

    public void relatorioDeMesasPorGarcomDesecupadas(List<Mesa> mesaList, Scanner sc){
        System.out.println("Informe o código do garçom: ");
        Long codigoGarcom = sc.nextLong();
        Garcom garcom = null;
        System.out.println("=================================");
        for(int i = 0; i < mesaList.size(); i++){
            if(null != mesaList.get(i).getGarcom()){
                if(codigoGarcom.compareTo(mesaList.get(i).getGarcom().getIdGarcom()) == 0) {
                    garcom = mesaList.get(i).getGarcom();
                }
                if((codigoGarcom.compareTo(mesaList.get(i).getGarcom().getIdGarcom()) == 0) && ("livre".compareToIgnoreCase(mesaList.get(i).getSituacao()) == 0)){
                    System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                    System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                    System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                    System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                    System.out.println("=================================");
                }
            }
        }
        if(null == garcom){
            System.out.println("Garçom inexistente.");
        }
    }

    public void relatorioDeMesasLivres(List<Mesa> mesaList, Scanner sc){
        System.out.println("========================= Relatório de Mesas Livres ========================= Relatório de Mesas Livres");
        for(int i = 0; i < mesaList.size(); i++){
            if("livre".compareToIgnoreCase(mesaList.get(i).getSituacao()) == 0){
                System.out.println("Número da mesa: " + mesaList.get(i).getNumeroMesa());
                System.out.println("Situação da mesa: " + mesaList.get(i).getSituacao());
                System.out.println("Capacidade máxima da mesa: " + mesaList.get(i).getCapacidadeMaxima());
                if(null != mesaList.get(i).getGarcom()){
                    System.out.println("Garçom responsável: " + mesaList.get(i).getGarcom().getNome());
                } else {
                    System.out.println("Garçom responsável: ");
                }
                System.out.println("=================================");
            }
        }
    }

}
