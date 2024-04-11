package br.com.cam.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cam.api.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>  {
    
}