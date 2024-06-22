package com.api_clientes.persistence.dao.implement;

import com.api_clientes.persistence.dao.interfaces.IClientesDAO;
import com.api_clientes.persistence.entity.ClientesEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientesDAOImpl implements IClientesDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<ClientesEntity> findAll() {
        return this.em.createQuery("SELECT u FROM ClientesEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientesEntity> findById(Long id) {
        return Optional.ofNullable(this.em.find(ClientesEntity.class,id));
    }

    @Override
    @Transactional
    public void createCliente(ClientesEntity clientesEntity) {
        this.em.persist(clientesEntity);
        this.em.flush();
    }

    @Override
    @Transactional
    public void updateCliente(ClientesEntity clientesEntity) {
        this.em.merge(clientesEntity);
    }

    @Override
    @Transactional
    public void deleteCliente(ClientesEntity clientesEntity) {
        this.em.remove(clientesEntity);
    }
}
