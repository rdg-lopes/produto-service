package com.exemplo.produto.service;

public class CodProdutoJaExisteException extends ApplicatonException {

	private static final long serialVersionUID = 1L;

	private Integer codProduto;
	
	public CodProdutoJaExisteException(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	@Override
	public String getMessage() {
		return "Já existe um produto no sistema com o código "+this.codProduto;
	}

}
