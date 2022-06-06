package com.exemplo.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodProdutoRepository extends JpaRepository<CodProdutoEntity, Integer> {

}
