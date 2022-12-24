package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.response.ResponseTransferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public ResponseTransferencia findTransferencias(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperadorTransacao) {
        ResponseTransferencia responseTransferencia = new ResponseTransferencia();
        responseTransferencia.setSaldoTotal(findTotal(idConta));
        responseTransferencia.setSaldoPeriodo(findPeriod(idConta, dataInicio, dataFim));

        if (nomeOperadorTransacao.isEmpty()) {
            responseTransferencia.setListTransferencia(transferenciaRepository.findAllByAccountAndDate(idConta, dataInicio, dataFim));
        } else {
            responseTransferencia.setListTransferencia(transferenciaRepository.findAllByAccountAndDateAndOperator(idConta, dataInicio, dataFim, nomeOperadorTransacao));
        }
        return responseTransferencia;
    }

    public Double findTotal(Long idConta) {
        List<Transferencia> listaTransferencias = transferenciaRepository.findAllByAccount(idConta);
        Double valorTotal = 0.0;

        for (Transferencia transferencia : listaTransferencias) {
            valorTotal += transferencia.getValor();
        }
        return valorTotal;
    }

    public Double findPeriod(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Transferencia> listaTransferencias = transferenciaRepository.findAllByAccountAndDate(idConta, dataInicio, dataFim);
        Double valorTotal = 0.0;

        for (Transferencia transferencia : listaTransferencias) {
            valorTotal += transferencia.getValor();
        }
        return valorTotal;
    }
}
