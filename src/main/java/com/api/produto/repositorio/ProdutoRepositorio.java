package com.api.produto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;

// interface responsável por fazer o c.r.u.d no banco de dados

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Integer> {
    
    List<ProdutoModelo> findAll();

    ProdutoModelo findById(int id);

    RespostaModelo deleteById(int id);

    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod obj);

}
