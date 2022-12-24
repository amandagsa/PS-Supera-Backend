package br.com.banco.controller;

import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity findAllAccounts() {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findAccountById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(id));
    }

    @GetMapping("/{id}/saldo")
    public ResponseEntity findTotal(@PathVariable(value = "id") Long idConta,
                                    @RequestParam(required = false, defaultValue = "1970-01-01T01:01:01", name = "dataInicial") String dataInicial,
                                    @RequestParam(required = false, defaultValue = "#{T(java.time.LocalDateTime).now().toString()}", name = "dataFinal") String dataFinal) {

        LocalDateTime dataInicio = LocalDateTime.parse(dataInicial);
        LocalDateTime dataFim = LocalDateTime.parse(dataFinal);

        return ResponseEntity.status(HttpStatus.OK).body(contaService.findTotal(idConta, dataInicio, dataFim));
    }
}
