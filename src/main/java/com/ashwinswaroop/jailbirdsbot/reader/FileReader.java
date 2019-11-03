package com.ashwinswaroop.jailbirdsbot.reader;

import com.ashwinswaroop.jailbirdsbot.loader.StreamLoader;

import java.util.Properties;

abstract class FileReader<T> {
    protected abstract StreamLoader getExpression();
    protected abstract Properties getProperties();
    public abstract T readFile();
}
