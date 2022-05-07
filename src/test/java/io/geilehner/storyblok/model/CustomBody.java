package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.StoryContent;

import java.util.ArrayList;
import java.util.List;

public class CustomBody extends StoryContent{
    private List<StoryContent> body;

    public CustomBody(String component){
        this.body = new ArrayList<>();
        this.setComponent(component);
    }

    public List<StoryContent> getBody() {
        return body;
    }

    public void setBody(List<StoryContent> body) {
        this.body = body;
    }
}
