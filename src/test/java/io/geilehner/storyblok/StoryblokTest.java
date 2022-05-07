package io.geilehner.storyblok;

import io.geilehner.storyblok.exception.StoryblokException;
import io.geilehner.storyblok.model.*;
import io.geilehner.storyblok.model.assets.AssetUpload;
import io.geilehner.storyblok.model.content.StoryVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class StoryblokTest {
    /*
    @Test
    public void testSimpleStorbylokFetch() throws StoryblokException {
        Storyblok client = new Storyblok("Q379bI7btilfPJ4F1PdmSQtt");
        Story<CustomStoryContent> story = client.fetchStory("test",CustomStoryContent.class);
        Assert.assertNotNull(story);
        Assert.assertNotNull(story.getContent());
        Assert.assertNotNull(story.getFullSlug());

        Story<Map<String,Object>> story2 = client.fetchStory("test");
        Assert.assertNotNull(story2.getContent());;

        Story<Map<String,Object>> story3 = client.fetchStory("test",StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .version(StoryVersion.published)
                .build());
        Assert.assertNotNull(story3);

        Stories<Map<String,Object>> story4 = client.fetchStories(StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .startsWith("h")
                .build());

        Assert.assertNotNull(story4.getStories());
        Assert.assertEquals(story4.getPerPage(),25);
    }

    @Test
    public void testManagementAPICreateStory() throws StoryblokException {
        Storyblok client = new Storyblok("Q379bI7btilfPJ4F1PdmSQtt","ilazVdybVGDCKEgAGrdHqwtt-74483-_UX8PA6bziVUvLF3MeYW","156697");
        ManagementStory<CustomBody> story = new ManagementStory<>();
        story.setPublish(1);
        story.setStory(new Story<>());
        story.getStory().setSlug("ich-bin-management");
        story.getStory().setName("Ich bin Management");
        CustomBody customBody = new CustomBody("page");
        customBody.getBody().add(new Feature("ich feature"));
        story.getStory().setContent(customBody);
        story.getStory().setFolder(false);
        story.getStory().setParentId(0);
        ManagementStory<CustomBody> response = client.createStory(story,CustomBody.class);

        Assert.assertNotNull(response.getStory());

        //update
        //DONT UPDATE A RESPONSE, gson is not resolving the custom types in body...
        response.getStory().getContent().getBody().add(new Feature("new feature lol"));
        response.getStory().getContent().getBody().add(new Feature("another one"));
        ManagementStory<CustomBody> response2 = client.updateStory(response,CustomBody.class);

        Assert.assertNotNull(response2.getStory());

        //delete

        client.deleteStory(response2.getStory().getId());
    }

    @Test
    public void testUploadAssetSignedResponse() throws StoryblokException {
        Storyblok client = new Storyblok("Q379bI7btilfPJ4F1PdmSQtt","ilazVdybVGDCKEgAGrdHqwtt-74483-_UX8PA6bziVUvLF3MeYW","156697");
        AssetUpload upload = client.uploadAsset("mytest.jpg","400x500");
        Assert.assertNotNull(upload);
    }*/
}
