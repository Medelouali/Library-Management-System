package com.example.libraryapp.dao;

import java.util.List;

public interface Dao<T> {
    //crud(Create..Read..Update..Delete) operations

    //1-create
    public boolean save(T item);

    //2-read
    public T getById(long id);
    public List<T> getAll();

    //3-update
    public boolean updateById(long id, T newItem);

    //4-delete
    public boolean deleteById(long id);

}
