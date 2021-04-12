package br.com.willi.williMeter.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.willi.williMeter.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String>{

}
