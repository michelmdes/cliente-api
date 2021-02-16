package com.builders.cliente;

import com.builders.cliente.domain.Cliente;
import com.builders.cliente.domain.Genero;
import com.builders.cliente.services.ClienteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class ClienteTest {

    private Validator validator;

    @InjectMocks
    ClienteService clienteService;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void naoDeveAceitarClienteComCpfInvalido() {

        List<String> cpfsInvalidos = Arrays.asList("", "ABC", "123456789123456789", "12345678910", "693.845.570.80", "693.845.570.B0");
        Set<ConstraintViolation<Cliente>> violations;

        for (String cpf: cpfsInvalidos) {
            Cliente cliente = getClientePreenchidoCorretamente();
            cliente.setCpf(cpf);

            violations = validator.validate(cliente);

            assertFalse(violations.isEmpty());
        }

    }

    @Test
    public void deveAceitarClienteComCpfValido() {

        List<String> cpfsValidos = Arrays.asList("693.845.570-80", "69384557080", "091.213.360-08", "09121336008");
        Set<ConstraintViolation<Cliente>> violations;

        for (String cpf: cpfsValidos) {
            Cliente cliente = getClientePreenchidoCorretamente();
            cliente.setCpf(cpf);

            violations = validator.validate(cliente);

            assertTrue(violations.isEmpty());
        }

    }

    @Test
    public void deveRetirarCaracteresDosDocumentosAoIncluirCliente() throws Exception {
        Cliente cliente = getClientePreenchidoCorretamente();

        Whitebox.invokeMethod(clienteService, "prepareDataBeforeSaving", cliente);

        assertEquals("69384557080", cliente.getCpf());
        assertEquals("0123456798", cliente.getRg());
        assertEquals("11345678910", cliente.getTelefone());
    }

    private Cliente getClientePreenchidoCorretamente() {
        return new Cliente("Nome Teste", new Date(), "693.845.570-80", "01234567 98", "teste@teste.com", "(11) 34567-8910", new Genero(1));
    }

}
