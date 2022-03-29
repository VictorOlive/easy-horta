package br.com.easyhorta.controller;

import br.com.easyhorta.model.Produto;
import br.com.easyhorta.repository.ProdutorRepository;
import br.com.easyhorta.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutorRepository produtorRepository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("categorias", produtorRepository.findAll());
        return "produto/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return "produto/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        repository.save(produto);
        return "redirect:listar";
    }

    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", repository.findAll());
        return "produto/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("produto",repository.findById(id));
        return "produto/form";
    }

    @GetMapping("excluir/{id}")
    public String remover(@PathVariable("id") Integer id, Model model) {
        repository.findById(id);
        repository.deleteById(id);
        return listarProdutos(model);
    }
}