package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.StoryContent;

public class Feature extends StoryContent {
    private String name;

    public Feature(String name) {
        this.name = name;
        this.setComponent("feature");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
