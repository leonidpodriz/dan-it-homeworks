package com.danit.springhomeworks.entity;

import java.util.Optional;

public interface EntityWithLongId {
    public Optional<Long> getId();
    public void setId(Long id);
}
