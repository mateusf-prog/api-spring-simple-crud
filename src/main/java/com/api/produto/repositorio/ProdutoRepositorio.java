package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.produto.modelo.ProdutoModelo;

// interface responsável por fazer o c.r.u.d no banco de dados

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> {
    
    // listar todos os produtos
    List<ProdutoModelo> findAll();

    // pesquisar por id
    ProdutoModelo findById(int id);

    // remover produto
    void delete(ProdutoModelo obj);

    // cadastrar/alterar produto
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod obj);
}
