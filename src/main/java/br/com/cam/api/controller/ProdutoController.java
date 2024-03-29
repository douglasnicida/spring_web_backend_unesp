package br.com.cam.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cam.api.model.Produto;
import br.com.cam.api.repository.ProdutoRepository;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/", produces="application/json")
    public ResponseEntity<List<Produto>> getAllProducts (){
        List<Produto> produtos = (List<Produto>) this.produtoRepository.findAll();

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
    
    @PostMapping(value = "/", produces="application/json")
    public ResponseEntity<Produto> addProduct (@RequestBody Produto produto){
        Produto produtoSalvo = produtoRepository.save(produto);

        return new ResponseEntity<Produto>(produtoSalvo, HttpStatus.OK);
    }
}
