package com.example.dia3springboot.endpoint;

public class PathsParameters {
    private final String path;
    private final String target;

    public PathsParameters(String path, String target) {
        this.path = path;
        this.target = target;
    }

    public String getPath() {
        return path;
    }

    public String getTarget() {
        return target;
    }
}
