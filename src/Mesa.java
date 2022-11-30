public class Mesa {
    private Long idMesa;
    private Long numeroMesa;
    private String situacao;
    private Integer capacidadeMaxima;
    private Long idGarcom;

    public Mesa(Long idMesa, Long numeroMesa, String situacao, Integer capacidadeMaxima, Long idGarcom) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.situacao = situacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.idGarcom = idGarcom;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public Long getNumeroMesa() {
        return numeroMesa;
    }

    public String getSituacao() {
        return situacao;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public Long getIdGarcom() {
        return idGarcom;
    }
}
