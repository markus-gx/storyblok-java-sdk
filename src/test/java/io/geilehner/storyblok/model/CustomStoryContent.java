package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.StoryContent;

public class CustomStoryContent extends StoryContent {
    private String _uid;

    public void set_uid(String _uid) {
        this._uid = _uid;
    }

    public String get_uid() {
        return _uid;
    }
}
