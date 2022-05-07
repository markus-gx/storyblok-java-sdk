package io.geilehner.storyblok.model;

import io.geilehner.storyblok.exception.StoryblokException;
import io.geilehner.storyblok.model.content.StoryContent;

public class ManagementStory<T extends StoryContent>{
    private Story<T> story;
    private int publish; //1 = publish; 0 = do not publish

    public Story<T> getStory() {
        return story;
    }

    public void setStory(Story<T> story) {
        this.story = story;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }
}
