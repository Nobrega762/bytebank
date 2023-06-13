package br.com.unpbankdigital.domain.conta;

import br.com.unpbankdigital.domain.cliente.DadosCadastroCliente;

public record DadosAberturaConta(Integer numero, DadosCadastroCliente dadosCliente) {
}
