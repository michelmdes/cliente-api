package com.builders.cliente.repositories;

import com.builders.cliente.domain.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("select c from Cidade c " +
            "where (:nome is null or upper(c.nome) like :nome%) " +
            "and (:idEstado is null or c.estado.id = :idEstado)")
    Page<Cidade> findByFilter(@Param("nome") String nome, @Param("idEstado") Long idEstado, Pageable pageRequest);
}
