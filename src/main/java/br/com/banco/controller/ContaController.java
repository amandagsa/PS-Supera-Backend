package br.com.banco.controller;

import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
