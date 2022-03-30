package br.com.easyhorta.controller;

import br.com.easyhorta.model.Produto;
import br.com.easyhorta.model.Produtor;
import br.com.easyhorta.repository.ProdutoRepository;
import br.com.easyhorta.repository.ProdutorRepository;
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
@RequestMapping("produtor")
public class ProdutorController {

    @Autowired
    private ProdutorRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Produtor produtor, Model model){
        model.addAttribute("categorias", repository.findAll());
        return "produtor/form";
    }

    @PostMapping("cadastrar")
    public String processarForm(@Valid Produtor produtor, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return "produtor/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        repository.save(produtor);
        return "redirect:listar";
    }

    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", repository.findAll());
        return "produtor/lista";
    }

    @GetMapping("cadastrar/produto")
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("categorias", repository.findAll());
        return "produto/form";
    }

    @PostMapping("cadastrar/produto")
    public String processarForm(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return "produto/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        produtoRepository.save(produto);
        return "redirect:listar";
    }

    @GetMapping("listar/produtos/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("produtos",produtoRepository.findAll());
        return "produtor/produtos";
    }

}
