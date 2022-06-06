package com.exemplo.produto.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exemplo.produto.repository.CodProdutoEntity;
import com.exemplo.produto.repository.CodProdutoRepository;
import com.exemplo.produto.repository.ProdutoEntity;
import com.exemplo.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private CodProdutoRepository codProdutoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public ProdutoModel createProduto(ProdutoInputModel input) {
		ProdutoEntity entity = new ProdutoMapper().map(input);
		entity.setCodProduto(newCodProduto());
		this.produtoRepository.save(entity);
		return new ProdutoMapper().map(entity);
	}

	private Integer newCodProduto() {
		CodProdutoEntity entity = new CodProdutoEntity();
		entity.setDtCreate(new Date());
		this.codProdutoRepository.save(entity);
		return entity.getCodProduto();
	}

	public List<ProdutoModel> getProdutos(String nome, int page, int size){
		List<ProdutoEntity> listEntity;
		Pageable pag = PageRequest.of(page, size);
		if(Objects.nonNull(nome)) {
			listEntity = this.produtoRepository.findByNomeContaining(nome, pag);
		} else {
			Page<ProdutoEntity> pagEntity = this.produtoRepository.findAll(pag);
			listEntity = pagEntity.getContent();
		}
		return new ProdutoMapper().mapToListModel(listEntity);
	}
	
}
