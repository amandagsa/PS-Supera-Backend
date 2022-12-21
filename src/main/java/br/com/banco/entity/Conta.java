package br.com.banco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @NotNull
    @Column(name = "id_conta")
    private Long idConta;

    @NotNull
    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Transferencia> tranferenciasList;

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public List<Transferencia> getTranferenciasList() {
        return tranferenciasList;
    }

    public void setTranferenciasList(List<Transferencia> tranferenciasList) {
        this.tranferenciasList = tranferenciasList;
    }
}
