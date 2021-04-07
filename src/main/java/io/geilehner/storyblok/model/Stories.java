package io.geilehner.storyblok.model;

import java.util.List;

public class Stories<T> {
    private List<Story<T>> stories;
    private int perPage;
    private int total;

    public List<Story<T>> getStories() {
        return stories;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setStories(List<Story<T>> stories) {
        this.stories = stories;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
