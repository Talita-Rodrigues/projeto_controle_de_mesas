public class Garcom {
    private Long idGarcom;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String sexo;
    private Double salarioFixo;

    public Garcom(Long idGarcom, String nome, String cpf, String dataNascimento, String email, String telefone, String sexo, Double salarioFixo) {
        this.idGarcom = idGarcom;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;
    }

    public Long getIdGarcom() {
        return idGarcom;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public Double getSalarioFixo() {
        return salarioFixo;
    }
}
