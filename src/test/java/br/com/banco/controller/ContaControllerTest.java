package br.com.banco.controller;

import br.com.banco.entity.Conta;
import br.com.banco.service.ContaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MockServletContext.class})
@ExtendWith(SpringExtension.class)
public class ContaControllerTest {

    @InjectMocks
    private ContaController controller;

    @Mock
    private ContaService service;

    @Test
    public void getAllAccountsSuccess() {
        when(service.findAll()).thenReturn(createContasList());
        ResponseEntity response = controller.findAllAccounts();

        assertNotNull(response.getBody());
    }
    @Test
    public void getAccountByIdSuccess() {
        when(service.findById(anyLong())).thenReturn(createConta());
        ResponseEntity response = controller.findAccountById(anyLong());

        assertNotNull(response.getBody());
    }

    private List<Conta> createContasList(){
        List<Conta> lista = new ArrayList<>();
        lista.add(createConta());
        return lista;
    }

    private Conta createConta(){
        Conta conta = new Conta();
        conta.setIdConta(1L);
        conta.setNomeResponsavel("Fulano");
        return conta;
    }
}
