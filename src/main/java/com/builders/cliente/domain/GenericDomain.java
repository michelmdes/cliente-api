package com.builders.cliente.domain;

import java.io.Serializable;

/**
 * Classe generica de dominio.
 * Util para o businessGenerico identificar as classes de dominio, bem como utilizar os metodos aqui declarados
 * @param <ID> Tipo do ID
 * @author Michel Mendes
 * @since 14/02/2021
 */
public abstract class GenericDomain<ID> implements Serializable {

    private static final long serialVersionUID = 1L;
    public abstract ID getId();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericDomain other = (GenericDomain) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
}
