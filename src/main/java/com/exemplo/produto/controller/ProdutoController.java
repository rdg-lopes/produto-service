package com.exemplo.produto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.exemplo.produto.service.ProdutoInputModel;
import com.exemplo.produto.service.ProdutoModel;
import com.exemplo.produto.service.ProdutoService;

@RestController
@RequestMapping("/v1/Produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoInputDTO input, WebRequest context){
		ProdutoInputModel model = new ProdutoMapper().map(input);
		ProdutoModel modelCriado = this.produtoService.createProduto(model);
		ProdutoDTO dtoResult = new ProdutoMapper().map(modelCriado);
		return ResponseEntity.created(newUri(context.getContextPath(), dtoResult)).body(dtoResult);
	}
	
	private URI newUri(String contextPath, ProdutoDTO dtoResult) {
		return UriComponentsBuilder.fromPath(contextPath)
						           .path("/")
						           .path(dtoResult.getCodProduto().toString())
						           .build().toUri();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdutoDTO> search(@RequestParam(name = "nome", required = false) String nome, 
								   @RequestParam(name = "page", required = false, defaultValue = "0") int page, 
								   @RequestParam(name = "size", required = false, defaultValue = "10")  int size){
		List<ProdutoModel> listModel = this.produtoService.getProdutos(nome, page, size);
		return new ProdutoMapper().mapToListModel(listModel);
	}
	
	
	
}
