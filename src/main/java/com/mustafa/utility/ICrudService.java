package com.mustafa.utility;

import com.mustafa.entity.User;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T,ID> {
    T save(T t);
    T update(T t);
    Iterable<T> saveAll(Iterable<T> t);
    T deleteById(ID id);
    Optional<T> findById(ID id);
    boolean existById(ID id);
    List<T> findAll();
    List<T> findByColumnAndValue(String columnName, Object value); // select * from tblurun where ad= ?
    List<T> findAllEntity(T t);
}
