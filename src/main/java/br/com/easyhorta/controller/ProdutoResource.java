package br.com.easyhorta.controller;


import br.com.easyhorta.model.Produto;
import br.com.easyhorta.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("{id}")
    public Produto buscar(@PathVariable Integer id) {
        return produtoRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Integer id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }
}
