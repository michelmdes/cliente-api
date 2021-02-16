package com.builders.cliente.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.builders.cliente.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    @Query("select e from Estado e where (:nome is null or upper(e.nome) like :nome%) ")
    Page<Estado> findByFilter(@Param("nome") String nome, Pageable pageRequest);

}
