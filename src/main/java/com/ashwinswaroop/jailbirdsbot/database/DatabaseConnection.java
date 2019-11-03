package com.ashwinswaroop.jailbirdsbot.database;

abstract class DatabaseConnection<T> {
    protected abstract String getConnectionString();
    public abstract T getClient();
}
