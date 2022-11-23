public class Mesa {
    private Long idMesa;
    private Long numeroMesa;
    private String situacao;
    private Integer capacidadeMaxima;
    private Garcom garcom;

    public Mesa(Long idMesa, Long numeroMesa, String situacao, Integer capacidadeMaxima, Garcom garcom) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.situacao = situacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.garcom = garcom;
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

    public Garcom getGarcom() {
        return garcom;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }
}
