package com.api.produto.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("api")
public class ProdutoControle {

    // ações
    // o Spring é responsável por criar a instância do objeto(ProdutoRepositorio) e fazer a injeção dessa dependência aqui.
    @Autowired    
    private ProdutoRepositorio acoes;
    
    // listar produtos
    // o método está usa acoes.findAll(interface) para retornar todos os produtos contidos no banco de dados 
    @GetMapping(value = "/produtos")
    public @ResponseBody List<ProdutoModelo> listar() {
        return acoes.findAll();
    }

    // cadastrar produtos
    // este método aceita um json do tipo ProdutoModelo e retorna esse produto usando acoes.save(obj)
    @PostMapping(value = "/produtos")       
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo obj) {
        return acoes.save(obj);
    }
}

/*
 * @GetMapping sera invocado quando uma solicitação GET é feita para o endpoint(/produtos) 
 * @PostMapping será invocado quando uma solicitação POST for feita para o endpoint(/produtos)
 */
