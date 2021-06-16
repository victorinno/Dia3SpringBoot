package com.example.dia3springboot.perssiter;

public class AsyncPersisterDecorator implements Persister{

    private Persister persister;

    public AsyncPersisterDecorator(Persister persister) {
        this.persister = persister;
    }

    @Override
    public void persist(byte[] data, String path) {
        new Thread(() -> persister.persist(data, path)).start();
    }
}
