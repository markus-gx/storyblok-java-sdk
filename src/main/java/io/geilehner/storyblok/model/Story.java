package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.AlternateStory;
import io.geilehner.storyblok.model.content.TranslatedSlug;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Storyblok Story Object
 * @see <a href="https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/the-story-object">The Story Object</a>
 * @param <T> The custom content object retrieved
 */
public class Story<T> {
    private long id;
    private UUID uuid;
    private String name;
    private String slug;
    private String fullSlug;
    private String defaultFullSlug;
    private LocalDateTime createdAt;
    private LocalDateTime publishedAt;
    private String releaseId;
    private String lang;
    private T content;
    private int position;
    private boolean isStartpage;
    private List<String> tagList;
    private long parentId;
    private UUID groupId;
    private List<TranslatedSlug> translatedSlugs;
    private List<AlternateStory> alternates;

    private boolean isFolder;

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getDefaultFullSlug() {
        return defaultFullSlug;
    }

    public void setDefaultFullSlug(String defaultFullSlug) {
        this.defaultFullSlug = defaultFullSlug;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isStartpage() {
        return isStartpage;
    }

    public void setStartpage(boolean startpage) {
        isStartpage = startpage;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public List<TranslatedSlug> getTranslatedSlugs() {
        return translatedSlugs;
    }

    public void setTranslatedSlugs(List<TranslatedSlug> translatedSlugs) {
        this.translatedSlugs = translatedSlugs;
    }

    public List<AlternateStory> getAlternates() {
        return alternates;
    }

    public void setAlternates(List<AlternateStory> alternates) {
        this.alternates = alternates;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }
}
