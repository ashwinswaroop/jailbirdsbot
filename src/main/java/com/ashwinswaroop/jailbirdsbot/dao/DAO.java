package com.ashwinswaroop.jailbirdsbot.dao;

public interface DAO<T> {
    void insert(T entry);
    T last();
}
