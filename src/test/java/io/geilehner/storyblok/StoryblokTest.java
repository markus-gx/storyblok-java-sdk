package io.geilehner.storyblok;

import io.geilehner.storyblok.exception.StoryblokException;
import io.geilehner.storyblok.model.CustomStoryContent;
import io.geilehner.storyblok.model.Stories;
import io.geilehner.storyblok.model.Story;
import io.geilehner.storyblok.model.StoryblokQuery;
import io.geilehner.storyblok.model.content.StoryVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class StoryblokTest {
    @Test
    public void testSimpleStorbylokFetch() throws StoryblokException {
        Storyblok client = new Storyblok("CSBmv0Drr65cwjSpiSw4agtt");
        Story<CustomStoryContent> story = client.fetchStory("home",CustomStoryContent.class);
        Assert.assertNotNull(story);
        Assert.assertNotNull(story.getContent());
        Assert.assertNotNull(story.getFullSlug());

        Story<Map<String,Object>> story2 = client.fetchStory("home");
        Assert.assertNotNull(story2.getContent());;

        Story<Map<String,Object>> story3 = client.fetchStory("home",StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .version(StoryVersion.published)
                .build());
        Assert.assertNotNull(story3);

        Stories<Map<String,Object>> story4 = client.fetchStories(StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .startsWith("h")
                .build());

        Assert.assertNotNull(story4.getStories());
        Assert.assertEquals(story4.getPerPage(),25);
    }
}
