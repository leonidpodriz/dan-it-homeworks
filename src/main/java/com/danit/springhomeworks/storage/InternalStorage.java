package com.danit.springhomeworks.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

public class InternalStorage<I, E> {
    private HashMap<I, E> entities = new HashMap<>();

    public Optional<E> getEntity(I id) {
        return Optional.ofNullable(entities.get(id));
    }

    public Collection<E> getAllEntities() {
        return entities.values();
    }

    public E putEntity(I id, E entity) {
        return entities.put(id, entity);
    }

    public boolean hasEntity(I id) {
        return getEntity(id).isPresent();
    }

    public boolean removeEntity(I id) {
        if (!hasEntity(id)) {
            return false;
        }

        entities.remove(id);
        return true;
    }

    public void flush() {
        entities = new HashMap<>();
    }
}
