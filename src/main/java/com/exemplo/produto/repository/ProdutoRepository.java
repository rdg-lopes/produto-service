package com.exemplo.produto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

	Optional<ProdutoEntity> findByCodProduto(Integer codProduto);
	List<ProdutoEntity> findByNomeContaining(String nome, Pageable page);
	
}
