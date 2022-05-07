package io.geilehner.storyblok.model;

public enum ObjectType {
    STORY("stories/"), ASSET("assets/"); //more to come... COMPONENT, SPACES, DATASOURCEs....

    private String path;
    ObjectType(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getPath(String mapi){
        return mapi.concat(getPath());
    }
}
