package com.pozharsky.dmitri.repository;

import com.pozharsky.dmitri.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T entity);

    void remove(T entity);

    T get(int index);

    List<T> sort(Comparator<? super T> comparator);

    List<T> query(Specification<T> specification);
}
