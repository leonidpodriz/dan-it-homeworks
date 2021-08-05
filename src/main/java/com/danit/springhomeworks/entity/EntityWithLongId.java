package com.danit.springhomeworks.entity;

import java.util.Optional;

public interface EntityWithLongId {
    Optional<Long> getId();

    void setId(Long id);
}
