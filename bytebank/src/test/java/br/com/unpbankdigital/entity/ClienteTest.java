package br.com.unpbankdigital.entity;

import br.com.unpbankdigital.domain.entity.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

class ClienteTest {

    @Mock
    private Cliente clienteMock;

    @Test
    void testValidations() {
        clienteMock = new Cliente();

        clienteMock.setNome("John Doe");
        clienteMock.setCpf("045.031.864-85");
        clienteMock.setEmail("johndoe@example.com");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Cliente>> violations = validator.validate(clienteMock);

        assertTrue(violations.isEmpty());
    }
    @Test
    void testValidationsComErroDeEmail() {
        clienteMock = new Cliente();

        clienteMock.setNome("John Doe");
        clienteMock.setCpf("045.031.864-85");
        clienteMock.setEmail("johndoeexample.com");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Cliente>> violations = validator.validate(clienteMock);

        assertFalse(violations.equals(factory));
    }

    @Test
    void testValidationsComErroDeCpf() {
        clienteMock = new Cliente();

        clienteMock.setNome("John Doe");
        clienteMock.setCpf("045.031.864");
        clienteMock.setEmail("johndoe@example.com");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Cliente>> violations = validator.validate(clienteMock);

        assertFalse(violations.equals(factory));
    }
}

