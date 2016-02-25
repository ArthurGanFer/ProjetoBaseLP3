package com.br.lp3.dao;

import java.util.List;

/**
 *
 * @author 31338283
 *  @param <E> Entidade
 */
public interface GenericDAO<E> {

    public boolean create(E e);

    public List<E> readAll();

    public E readById(long id);

    public boolean update(E e);

    public boolean delete(E e);

}
