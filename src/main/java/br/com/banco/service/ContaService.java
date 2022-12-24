package br.com.banco.service;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;
import br.com.banco.error.ResourcesNotFoundException;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransferenciaService transferenciaService;

    private String MESSAGE = "Conta não encontrada para o ID";

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta findById(Long idConta) {
        return contaRepository.findById(idConta).orElseThrow(() -> {
            throw new ResourcesNotFoundException(MESSAGE);
        });
    }

    public Double findTotal(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Transferencia> listaTransferencias = transferenciaService.findByAccountIdAndDate(idConta, dataInicio, dataFim);
        Double valorTotal = 0.0;

        for (Transferencia transferencia : listaTransferencias) {
            valorTotal += transferencia.getValor();
        }
        return valorTotal;
    }
}
