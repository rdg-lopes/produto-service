package com.exemplo.produto.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.exemplo.produto.service.ProdutoInputModel;
import com.exemplo.produto.service.ProdutoModel;

public class ProdutoMapper {

	public ProdutoInputModel map(ProdutoInputDTO input) {
		ProdutoInputModel model = new ProdutoInputModel();
		model.setNome(input.getNome());
		model.setDescricao(input.getDescricao());
		return model;
	}
	
	public ProdutoDTO map(ProdutoModel model) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setCodProduto(model.getCodProduto());
		dto.setNome(model.getNome());
		dto.setDescricao(model.getDescricao());
		return dto;
	}
	
	public List<ProdutoDTO> mapToListModel(List<ProdutoModel> listModel){
		return listModel.stream().map(this::map).collect(Collectors.toList());
	}
	
}
