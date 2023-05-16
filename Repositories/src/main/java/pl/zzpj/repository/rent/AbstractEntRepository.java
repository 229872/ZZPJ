package pl.zzpj.repository.rent;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class AbstractEntRepository<T> implements AbstractRepository<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public T add(T entity) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public T update(UUID id, T entity) {
        return null;
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public T findById(UUID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
