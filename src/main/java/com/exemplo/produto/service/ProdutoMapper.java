package com.exemplo.produto.service;

import java.util.List;
import java.util.stream.Collectors;

import com.exemplo.produto.repository.ProdutoEntity;

public class ProdutoMapper {

	public ProdutoEntity map(ProdutoInputModel model) {
		ProdutoEntity entity = new ProdutoEntity();
		entity.setNome(model.getNome());
		entity.setDescricao(model.getDescricao());
		return entity;
	}
	
	public ProdutoModel map(ProdutoEntity entity) {
		ProdutoModel model = new ProdutoModel();
		model.setCodProduto(entity.getCodProduto());
		model.setNome(entity.getNome());
		model.setDescricao(entity.getDescricao());
		return model;
	}
	
	public List<ProdutoModel> mapToListModel(List<ProdutoEntity> listEntity){
		return listEntity.stream().map(this::map).collect(Collectors.toList());
	}
	
}
