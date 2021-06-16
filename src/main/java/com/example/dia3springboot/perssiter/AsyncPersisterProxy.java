package com.example.dia3springboot.perssiter;

public class AsyncPersisterProxy implements Persister{

    private Persister persister;

    public AsyncPersisterProxy(Persister persister) {
        this.persister = persister;
    }

    @Override
    public void persist(byte[] data, String path) {
        new Thread(() -> persister.persist(data, path)).start();
    }
}
