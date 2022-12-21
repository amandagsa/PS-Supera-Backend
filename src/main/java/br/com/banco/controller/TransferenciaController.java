package br.com.banco.controller;

import br.com.banco.service.ContaService;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "transferencia")
public class TransferenciaController {

    @Autowired
    ContaService contaService;

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping("/{id}")
    public ResponseEntity findTransfersByAccountId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByContaId(id));
    }

    @GetMapping("/{id}/{Dinicial}/{Dfinal}")
    public ResponseEntity findTransfersByAccountIdAndDate(@PathVariable(value = "id") Long id,
                                                          @PathVariable(value = "Dinicial") String Dinicial,
                                                          @PathVariable(value = "Dfinal") String Dfinal) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime dataInicio = LocalDateTime.parse(Dinicial, formatter);
        LocalDateTime dataFim = LocalDateTime.parse(Dfinal, formatter);

        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByContaIdAndDate(id, dataInicio, dataFim));
    }

    @GetMapping("/{id}/{operador}")
    public ResponseEntity findTransfersByAccountIdAndOperator(@PathVariable(value = "id") Long id,
                                                              @PathVariable(value = "operador") String operador) {
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByContaIdAndOperator(id, operador));
    }

    @GetMapping("/{id}/{Dinicial}/{Dfinal}/{operador}")
    public ResponseEntity findTransfersByAccountIdAndDateAndOperator(@PathVariable(value = "id") Long id,
                                                                     @PathVariable(value = "Dinicial") String Dinicial,
                                                                     @PathVariable(value = "Dfinal") String Dfinal,
                                                                     @PathVariable(value = "operador") String operador) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime dataInicio = LocalDateTime.parse(Dinicial, formatter);
        LocalDateTime dataFim = LocalDateTime.parse(Dfinal, formatter);

        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findByContaIdAndDateAndOperator(id, dataInicio, dataFim, operador));
    }
}
