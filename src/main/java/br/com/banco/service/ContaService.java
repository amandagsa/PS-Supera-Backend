package br.com.banco.service;

import br.com.banco.entity.Conta;
import br.com.banco.error.ResourcesNotFoundException;
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> {
            throw new ResourcesNotFoundException("Conta não encontrada para o ID");
        });
    }
}
