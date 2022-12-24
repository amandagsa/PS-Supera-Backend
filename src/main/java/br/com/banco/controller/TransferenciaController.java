package br.com.banco.controller;

import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping("/{id}")
    public ResponseEntity findTransfersByAccountId(@PathVariable(value = "id") Long id,
                                                   @RequestParam(required = false, defaultValue = "1970-01-01T01:01:01", name = "dataInicial") String dataInicial,
                                                   @RequestParam(required = false, defaultValue = "#{T(java.time.LocalDateTime).now().toString()}", name = "dataFinal") String dataFinal,
                                                   @RequestParam(required = false, defaultValue = "", name = "operador") String operador) {

        LocalDateTime dataInicio = LocalDateTime.parse(dataInicial);
        LocalDateTime dataFim = LocalDateTime.parse(dataFinal);

        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findTransferencias(id, dataInicio, dataFim, operador));
    }
}
