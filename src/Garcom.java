public class Garcom {
    private Long idGarcom;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String sexo;
    private Double salarioFixo;

    public Garcom(Long idGarcom, String nome, String cpf, String email, String telefone, String sexo, Double salarioFixo) {
        this.idGarcom = idGarcom;
        this.nome = nome;
        this.cpf = cpf;
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
