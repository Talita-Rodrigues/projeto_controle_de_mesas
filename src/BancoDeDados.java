import java.sql.*;
import java.util.Scanner;
public class BancoDeDados {
    private Connection connection;
    private Statement statement;

    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "SISTEMA";
    private String USER = "root";
    private String PASSWORD = "user";

    public BancoDeDados() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" +
                DATABASE, USER, PASSWORD);
        this.statement = this.connection.createStatement();

    }

    public void cadastroDeMesa(Scanner sc){

        try{
            System.out.println("Informe a capacidade máxima da mesa: ");
            Integer capacidadeMaxima = sc.nextInt();
            ResultSet resultSet = this.statement.executeQuery("SELECT COUNT(*) AS NUMERO_MESA FROM MESA");
            Integer numeroMesa = 0;

            while (resultSet.next()){
                numeroMesa = resultSet.getInt("NUMERO_MESA");
            }

            String sql = "INSERT INTO MESA (NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA) VALUES (?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, numeroMesa + 1);
            preparedStatement.setString(2, "livre");
            preparedStatement.setInt(3, capacidadeMaxima);

            int linhasCriadas = preparedStatement.executeUpdate();

            if(linhasCriadas > 0) {
                System.out.println("Mesa cadastrada com sucesso!");
            } else {
                System.out.println("Erro ao criar nova mesa.");
            }

            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("Erro ao criar nova mesa. Error: " + e.getMessage());
        }
    }

    public void removerMesa(Scanner sc) {

        try{
            System.out.println("Informe o numero da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "DELETE FROM MESA WHERE NUMERO_MESA = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, numeroMesa);
            Integer linhasDeletadas = preparedStatement.executeUpdate();

            if(linhasDeletadas > 0){
                System.out.println("Mesa " + numeroMesa + " deletada com sucesso!");
            } else {
                System.out.println("Erro ao remover mesa.");
            }
            preparedStatement.close();
        } catch (Exception e){
            System.out.println("Erro ao remover mesa. Erro: " + e.getMessage());
        }
    }

    public void relatorioMesas(){

        try{
            String sql = "SELECT NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA, (" +
                    "SELECT NOME FROM GARCOM WHERE IDGARCOM = M.IDGARCOM) AS NOME_GARCOM FROM MESA M";
            ResultSet resultSet = this.statement.executeQuery(sql);
            System.out.println("================================= RELATÓRIO DE MESAS =================================");
            while(resultSet.next()){
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME_GARCOM"));
                System.out.println("=================================");
            }
            resultSet.close();
        }catch (Exception e){
            System.out.println("Erro ao listar as mesas. Erro: " + e.getMessage());
        }
    }

    public void buscarMesaPorNumero(Scanner sc){
        try {
            System.out.println("Informe o numero da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "SELECT NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA," +
                    "(SELECT NOME FROM GARCOM WHERE IDGARCOM = M.IDGARCOM) AS NOME_GARCOM " +
                    " FROM MESA M WHERE M.NUMERO_MESA = " + numeroMesa;
            ResultSet resultSet = this.statement.executeQuery(sql);

            System.out.println("=================================");
            while (resultSet.next()) {
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME_GARCOM"));
                System.out.println("=================================");
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mesa. Erro: " + e.getMessage());
        }
    }

    public void buscarMesaPelaCapacidade(Scanner sc){
        System.out.println("Informa a capacidade da mesa: ");
        Integer capacidade = sc.nextInt();
        try {
            String sql = "SELECT NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA," +
                    "(SELECT NOME FROM GARCOM WHERE IDGARCOM = M.IDGARCOM) AS NOME_GARCOM " +
                    " FROM MESA M WHERE M.CAPACIDADE_MAXIMA = " + capacidade;
            ResultSet resultSet = this.statement.executeQuery(sql);

            System.out.println("=================================");
            while (resultSet.next()) {
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME_GARCOM"));
                System.out.println("=================================");
            }
            resultSet.close();
        } catch (Exception e){
            System.out.println("Erro ao buscar mesa. Error: " + e.getMessage());
        }
    }

    public void cadastrarGarcom(Scanner sc){
        try {
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

            String sql = "INSERT INTO GARCOM (NOME,CPF,DATA_NASCIMENTO,EMAIL,TELEFONE,SEXO,SALARIO_FIXO) " +
                    "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, dataNascimento);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, telefone);
            preparedStatement.setString(6, sexo);
            preparedStatement.setDouble(7, salario);

            int linhasCriadas = preparedStatement.executeUpdate();

            if(linhasCriadas > 0){
                System.out.println("Garçom cadsatrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar garçom");
            }
            preparedStatement.close();
        } catch (Exception e){
            System.out.println("Erro ao cadastrar garçom. Erro: " + e.getMessage());
        }
    }

    public void removerGarcom(Scanner sc){
        try {
            System.out.println("Informe o código do garçom: ");
            Integer codigoGarcom = sc.nextInt();

            String sql_1 = "SELECT COUNT(*) AS CONTADOR FROM MESA WHERE IDGARCOM = " + codigoGarcom;
            ResultSet resultSet = this.statement.executeQuery(sql_1);
            Integer garcomPorMesa = 0;

            while (resultSet.next()){
                garcomPorMesa = resultSet.getInt("CONTADOR");
            }
            if(garcomPorMesa > 0){
                System.out.println("Este garçom não pode ser removido pois gerencia uma mesa.");
            } else {
                String sql_2 = "DELETE FROM GARCOM WHERE IDGARCOM = ?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql_2);
                preparedStatement.setInt(1,codigoGarcom);
                Integer linhasDeletadas = preparedStatement.executeUpdate();

                if(linhasDeletadas > 0){
                    System.out.println("Garçom deletado com sucesso!");
                } else {
                    System.out.println("Erro ao deletar garçom.");
                }
            }
        } catch(Exception e){
            System.out.println("Erro ao remover garlom. Error: " + e.getMessage());
        }
    }

    public void relatorioGarcons(){

        try {
            String sql = "SELECT * FROM GARCOM";
            ResultSet resultSet = this.statement.executeQuery(sql);

            System.out.println("================================= RELATÓRIO DE GARÇONS =================================");
            while (resultSet.next()){
                System.out.println("CÓDIGO: " + resultSet.getInt("IDGARCOM"));
                System.out.println("NOME: " + resultSet.getString("NOME"));
                System.out.println("CPF: " + resultSet.getString("CPF"));
                System.out.println("DATA DE NASCIMENTO: " + resultSet.getString("DATA_NASCIMENTO"));
                System.out.println("E-MAIL: " + resultSet.getString("EMAIL"));
                System.out.println("TELEFONE: " + resultSet.getString("TELEFONE"));
                System.out.println("SEXO: " + resultSet.getString("SEXO"));
                System.out.println("SALARIO: " + resultSet.getDouble("SALARIO_FIXO"));
                System.out.println("=================================");
            }
        }catch (Exception e){
            System.out.println("Erro ao mostrar lista de garçons. Erro: " + e.getMessage());
        }
    }

    public void vincularGarcomMesa(Scanner sc){
        try {
            System.out.println("Informe o código do garçom: ");
            Integer codigoGarcom = sc.nextInt();
            System.out.println("Informe o numero da mesa: ");
            Integer numeroMesa = sc.nextInt();
            Integer idGarcom = 0;
            Integer idMesa = 0;

            String sqlGarcom = "SELECT IDGARCOM FROM GARCOM WHERE IDGARCOM = " + codigoGarcom;
            ResultSet resultSet = this.statement.executeQuery(sqlGarcom);

            while (resultSet.next()){
                idGarcom = resultSet.getInt("IDGARCOM");
            }

            if(idGarcom > 0){
                String sqlMesa = "SELECT IDMESA FROM MESA WHERE NUMERO_MESA = " + numeroMesa;
                resultSet = this.statement.executeQuery(sqlMesa);

                while (resultSet.next()){
                    idMesa = resultSet.getInt("IDMESA");
                }

                if(idMesa > 0){
                    String sql = "UPDATE MESA SET IDGARCOM = ? WHERE IDMESA = ?";
                    PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                    preparedStatement.setInt(1, idGarcom);
                    preparedStatement.setInt(2, idMesa);

                    int linhasDeletada = preparedStatement.executeUpdate();
                    if(linhasDeletada > 0) {
                        System.out.println("Garçom vinculado com sucesso!");
                    } else {
                        System.out.println("Erro ao vincular garçom.");
                    }
                    resultSet.close();
                    preparedStatement.close();
                } else {
                    System.out.println("Mesa inexistente.");
                    resultSet.close();
                    return;
                }
            } else {
                System.out.println("Garçom inexistente.");
                resultSet.close();
                return;
            }
        }catch (Exception e){
            System.out.println("Erro ao vincular garçom à mesa. Erro: " + e.getMessage());
        }
    }

    public void desvincularGarcomMesa(Scanner sc){
        try{
            System.out.println("Informe o numero da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "UPDATE MESA SET IDGARCOM = NULL WHERE NUMERO_MESA = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, numeroMesa);
            int linhaAlterada = preparedStatement.executeUpdate();

            if(linhaAlterada > 0){
                System.out.println("Garçom desvinculado com sucesso!");
            } else {
                System.out.println("Erro ao desvincular garçom da mesa.");
            }
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("Erro ao desvincular garçom da mesa. Erro: " + e.getMessage());
        }
    }

    public void abrirMesa(Scanner sc){
        try {
            System.out.println("Informe o número da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "UPDATE MESA SET SITUACAO = 'ocupada' WHERE NUMERO_MESA = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1,numeroMesa);

            int linaAlterada = preparedStatement.executeUpdate();

            if(linaAlterada > 0){
                System.out.println("Mesa aberta com sucesso!");
            }else {
                System.out.println("Erro ao abrir mesa.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao abrir mesa. Erro: " + e.getMessage());
        }
    }

    public void reservarMesa(Scanner sc){
        try {
            System.out.println("Informe o número da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "UPDATE MESA SET SITUACAO = 'reservada' WHERE NUMERO_MESA = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1,numeroMesa);

            int linaAlterada = preparedStatement.executeUpdate();

            if(linaAlterada > 0){
                System.out.println("Mesa reservada com sucesso!");
            }else {
                System.out.println("Erro ao reservar mesa.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao reservar mesa. Erro: " + e.getMessage());
        }
    }

    public void liberarMesa(Scanner sc){
        try {
            System.out.println("Informe o número da mesa: ");
            Integer numeroMesa = sc.nextInt();

            String sql = "UPDATE MESA SET SITUACAO = 'livre' WHERE NUMERO_MESA = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1,numeroMesa);

            int linaAlterada = preparedStatement.executeUpdate();

            if(linaAlterada > 0){
                System.out.println("Mesa liberada com sucesso!");
            }else {
                System.out.println("Erro ao liberar mesa.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao liberar mesa. Erro: " + e.getMessage());
        }
    }

    public void buscarGarcomPorEmail(Scanner sc){
        try {
            System.out.println("Infrome o e-mail do garçom: ");
            String email = sc.next();

            String sql = "SELECT * FROM GARCOM WHERE EMAIL = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("=================================");
            while (resultSet.next()){
                System.out.println("NOME: " + resultSet.getString("NOME"));
                System.out.println("CPF: " + resultSet.getString("CPF"));
                System.out.println("DATA DE NASCIMENTO: " + resultSet.getString("DATA_NASCIMENTO"));
                System.out.println("E-MAIL: " + resultSet.getString("EMAIL"));
                System.out.println("TELEFONE: " + resultSet.getString("TELEFONE"));
                System.out.println("SEXO: " + resultSet.getString("SEXO"));
                System.out.println("SALARIO: " + resultSet.getDouble("SALARIO_FIXO"));
                System.out.println("=================================");
            }
            preparedStatement.close();
            resultSet.close();

        } catch (Exception e) {
            System.out.println("Erro ao buscar garçom. Erro: " + e.getMessage());
        }
    }

    public void relatorioDeMesasComUmaCapacidadeMaiorOuIgualAUmaDadaCapacidade(Scanner sc){

        try {
            System.out.println("Informa a capacidade da mesa: ");
            Integer capacidade = sc.nextInt();
            String sql = "SELECT NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA, (" +
                    "SELECT NOME FROM GARCOM WHERE IDGARCOM = M.IDGARCOM) AS NOME_GARCOM FROM MESA M " +
                    "WHERE M.CAPACIDADE_MAXIMA >= ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, capacidade);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("=================================");
            while (resultSet.next()){
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME_GARCOM"));
                System.out.println("=================================");
            }
            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mesas. Error: " + e.getMessage());
        }
    }

    public void relatorioMesasPorGarcomOcupadas(Scanner sc){
        try {
            System.out.println("Informe o código do garçom: ");
            Integer codigoGarcom = sc.nextInt();

            String sql = "SELECT M.NUMERO_MESA, M.SITUACAO, M.CAPACIDADE_MAXIMA, " +
                    "G.NOME FROM MESA M INNER JOIN GARCOM G WHERE M.IDGARCOM = G.IDGARCOM AND G.IDGARCOM = ? " +
                    " AND M.SITUACAO = 'ocupada'";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigoGarcom);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("=================================");
            while (resultSet.next()){
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME"));
                System.out.println("=================================");
            }

            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mesas. Error: " + e.getMessage());
        }
    }

    public void relatorioDeMesasPorGarcomDesocupadas(Scanner sc){
        try {
            System.out.println("Informe o código do garçom: ");
            Integer codigoGarcom = sc.nextInt();

            String sql = "SELECT M.NUMERO_MESA, M.SITUACAO, M.CAPACIDADE_MAXIMA, " +
                    "G.NOME FROM MESA M INNER JOIN GARCOM G WHERE M.IDGARCOM = G.IDGARCOM AND G.IDGARCOM = ? " +
                    " AND M.SITUACAO = 'livre'";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigoGarcom);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("=================================");
            while (resultSet.next()){
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME"));
                System.out.println("=================================");
            }

            preparedStatement.close();
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mesas. Error: " + e.getMessage());
        }
    }

    public void relatorioDeMesasLivres(){
        System.out.println("========================= Relatório de Mesas Livres =========================");
        try {

            String sql = "SELECT NUMERO_MESA, SITUACAO, CAPACIDADE_MAXIMA, (" +
                    "SELECT NOME FROM GARCOM WHERE IDGARCOM = M.IDGARCOM) AS NOME_GARCOM FROM MESA M" +
                    " WHERE M.SITUACAO = 'livre'";
            ResultSet resultSet = this.statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println("Número da mesa: " + resultSet.getInt("NUMERO_MESA"));
                System.out.println("Situação da mesa: " + resultSet.getString("SITUACAO"));
                System.out.println("Capacidade máxima da mesa: " + resultSet.getInt("CAPACIDADE_MAXIMA"));
                System.out.println("Garçom responsável: " + resultSet.getString("NOME_GARCOM"));
                System.out.println("=================================");
            }

            resultSet.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar mesas. Error: " + e.getMessage());
        }
    }

    public void closeDataBase() {
        try {
            this.statement.close();
            this.connection.close();
        } catch( Exception e){
            System.out.println("Não foi possivle encerrar a conexão com o Banco de dados. Error: " + e.getMessage());
        }
    }

}
