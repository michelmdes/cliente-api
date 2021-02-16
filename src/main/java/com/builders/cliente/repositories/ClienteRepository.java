package com.builders.cliente.repositories;

import com.builders.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c " +
            "where (:nome is null or upper(c.nome) like :nome%) " +
            "and (:cpf is null or c.cpf = :cpf) " +
            "and (:rg is null or c.rg = :rg) " +
            "and (:email is null or c.email = :email) " +
            "and (:telefone is null or c.telefone = :telefone) " +
            "and (:genero is null or c.genero.id = :genero)")
    Page<Cliente> findByFilter(@Param("nome") String nome,
                               @Param("cpf") String cpf,
                               @Param("rg") String rg,
                               @Param("email") String email,
                               @Param("telefone") String telefone,
                               @Param("genero") Integer genero,
                               Pageable pageRequest);

}
