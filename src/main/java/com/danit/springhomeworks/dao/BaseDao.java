package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.EntityWithLongId;

import java.util.Collection;
import java.util.List;

abstract public class BaseDao<T extends EntityWithLongId> implements Dao<T> {
    abstract Collection<T> getEntities();

    public Long getNextId() {
        return getEntities().stream()
                .max((x, y) -> (int) (x.getId().orElse(0L) - y.getId().orElse(0L)))
                .flatMap(EntityWithLongId::getId)
                .orElse(0L) + 1;
    }


    @Override
    public void deleteAll(List<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void saveAll(List<T> entities) {
        entities.forEach(this::save);
    }
}
