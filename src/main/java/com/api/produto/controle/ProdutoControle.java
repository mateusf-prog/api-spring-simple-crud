package com.api.produto.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("api")
public class ProdutoControle {

    // ações
    @Autowired  // é responsável por criar a instância do objeto(ProdutoRepositorio) e fazer a injeção dessa dependência aqui.
    private ProdutoRepositorio acoes;
    
    // listar produtos
    // uso do acoes.findAll(interface) para retornar todos os produtos contidos no banco de dados 
    @GetMapping(value = "/produtos")
    public @ResponseBody List<ProdutoModelo> listar() {
        return acoes.findAll();
    }

    // cadastrar produtos
    // recebe um json do tipo ProdutoModelo e retorna esse produto usando acoes.save(obj)
    @PostMapping(value = "/produtos")       
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo obj) {
        return acoes.save(obj);
    }

    // filtrar produtos
    // retorna o produto especificado pelo endpoint /produtos/id, onde esse id pode ser usado como uma 'variavel'
    @GetMapping(value = "/produtos/{id}")
    public @ResponseBody Optional<ProdutoModelo> filtrar(@PathVariable Integer id) {
        return acoes.findById(id);
    }

    // alterar produto
    // recebe um json do tipo ProdutoModelo, atualiza no banco e retorna esse produto usando acoes.save(obj)
    @PutMapping(value = "/produtos")
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo obj) {
        return acoes.save(obj);
    }

    // deletar produtos
    // recebe um json(ProdutoMmodelo), deleta no banco de dados, e retorna uma string dizendo se deu certo ou nao.
    @DeleteMapping(value = "/produtos/{id}")
    public @ResponseBody RespostaModelo deleteById(@PathVariable Integer id) {
        RespostaModelo resp = new RespostaModelo();
        try {
            Optional<ProdutoModelo> obj = filtrar(id);
            acoes.deleteById(obj.get().getId());
            resp.setMsg("Removido com sucesso!");
        } catch (Exception e) {
            resp.setMsg("Falha ao remover!");
        }
        return resp;
    }
}


/*
 * @GetMapping sera invocado quando uma solicitação GET é feita para o endpoint(/produtos) 
 * @PostMapping será invocado quando uma solicitação POST for feita para o endpoint(/produtos)
 */
