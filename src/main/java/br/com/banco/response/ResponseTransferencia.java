package br.com.banco.response;

import br.com.banco.entity.Transferencia;

import java.util.List;

public class ResponseTransferencia {

    private Double saldoTotal;
    private Double saldoPeriodo;
    private List <Transferencia> listTransferencia;

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Double getSaldoPeriodo() {
        return saldoPeriodo;
    }

    public void setSaldoPeriodo(Double saldoPeriodo) {
        this.saldoPeriodo = saldoPeriodo;
    }

    public List<Transferencia> getListTransferencia() {
        return listTransferencia;
    }

    public void setListTransferencia(List<Transferencia> listTransferencia) {
        this.listTransferencia = listTransferencia;
    }
}
