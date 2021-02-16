package com.builders.cliente.repositories;

import com.builders.cliente.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findEnderecosByCliente_Id(Long id);

    @Modifying
    void deleteByIdAndCliente_Id(Long id, Long idCliente);
}
