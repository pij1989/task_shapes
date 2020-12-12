package com.pozharsky.dmitri.specification;

public interface Specification<T> {
    boolean specify(T entity);
}
