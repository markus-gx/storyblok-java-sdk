package io.geilehner.storyblok.model.content;

public class AlternateStory {
    private long id;
    private String name;
    private String slug;
    private String fullSlug;
    private boolean isFolder;
    private long parentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getFullSlug() {
        return fullSlug;
    }

    public void setFullSlug(String fullSlug) {
        this.fullSlug = fullSlug;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
