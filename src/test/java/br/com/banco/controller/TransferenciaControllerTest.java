package br.com.banco.controller;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MockServletContext.class})
@ExtendWith(SpringExtension.class)
public class TransferenciaControllerTest {

    @InjectMocks
    private TransferenciaController controller;

    @Mock
    private TransferenciaService service;

    @Test
    public void getAllTransfersByIdSuccess() {
        when(service.findByContaId(anyLong())).thenReturn(createTransferenciaList());
        ResponseEntity response = controller.findTransfersByAccountId(anyLong());

        assertNotNull(response.getBody());
    }

    private Conta createConta(){
        Conta conta = new Conta();
        conta.setIdConta(1L);
        conta.setNomeResponsavel("Fulano");
        return conta;
    }
    private Transferencia createTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.setId(1L);
        transferencia.setConta(createConta());
        return transferencia;
    }
    private List<Transferencia> createTransferenciaList() {
        List<Transferencia> listaTransferencias = new ArrayList<>();
        listaTransferencias.add(createTransferencia());
        return listaTransferencias;
    }
}
