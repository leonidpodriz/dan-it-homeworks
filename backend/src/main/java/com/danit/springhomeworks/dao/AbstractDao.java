package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.AutoIncrementor;
import com.danit.springhomeworks.entity.EntityWithLongId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends EntityWithLongId> implements Dao<T> {
    AutoIncrementor idGenerator = new AutoIncrementor();
    HashMap<Long, T> dbInMemory = new HashMap<>();

    @Override
    public T save(T obj) {
        Long id = obj.getId().orElseGet(idGenerator::next);
        obj.setId(id);
        dbInMemory.put(id, obj);
        return obj;
    }

    @Override
    public void saveAll(Iterable<T> entities) {
        entities.forEach(this::save);
    }

    @Override
    public boolean delete(T obj) {
        return obj.getId().map(id -> dbInMemory.remove(id, obj)).orElse(false);
    }

    @Override
    public void deleteAll(Iterable<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dbInMemory.values());
    }

    @Override
    public boolean deleteById(long id) {
        return getOne(id).map(this::delete).orElse(false);
    }

    @Override
    public Optional<T> getOne(long id) {
        return Optional.ofNullable(dbInMemory.get(id));
    }
}
