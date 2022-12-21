package br.com.banco.service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ContaService contaService;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> findByContaId(Long idConta) {
        return transferenciaRepository.findAllByConta(idConta);
    }

    public List<Transferencia> findByContaIdAndDate(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return transferenciaRepository.findAllByAccontAndDate(idConta, dataInicio, dataFim);
    }

    public List<Transferencia> findByContaIdAndOperator(Long idConta, String nomeOperadorTransacao) {
        return transferenciaRepository.findAllByAccountAndOperator(idConta, nomeOperadorTransacao);
    }

    public List<Transferencia> findByContaIdAndDateAndOperator(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperadorTransacao) {
        return transferenciaRepository.findAllByAccountAndDateAndOperator(idConta, dataInicio, dataFim, nomeOperadorTransacao);
    }
}
