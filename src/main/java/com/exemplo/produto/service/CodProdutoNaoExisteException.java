package com.exemplo.produto.service;

public class CodProdutoNaoExisteException extends ApplicatonException {

	private static final long serialVersionUID = 1L;

	private Integer codProduto;
	
	public CodProdutoNaoExisteException(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	@Override
	public String getMessage() {
		return "Não foi encontrado um produto no sistema com o código "+this.codProduto;
	}

}
