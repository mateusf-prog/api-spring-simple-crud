package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;

// interface responsável por fazer o c.r.u.d no banco de dados

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Integer> {
    
    // listar todos os produtos
    List<ProdutoModelo> findAll();

    // pesquisar por id
    ProdutoModelo findById(int id);

    // remover produto
    RespostaModelo deleteById(int id);

    // cadastrar/alterar produto
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod obj);

}
