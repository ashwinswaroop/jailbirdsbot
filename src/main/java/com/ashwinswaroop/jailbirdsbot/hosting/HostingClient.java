package com.ashwinswaroop.jailbirdsbot.hosting;

abstract class HostingClient<T, U, V> {
    protected abstract T getRequest();
    protected abstract U getData();
    public abstract V uploadImage();
}
