package io.geilehner.storyblok.model;

import io.geilehner.storyblok.Storyblok;
import io.geilehner.storyblok.model.content.FilterOperation;
import io.geilehner.storyblok.model.content.ResolveLinks;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;

public class StoryblokQueryTest {

    @Test
    public void testStoryblokQuery(){
        StoryblokQuery storyblokQuery = StoryblokQuery.StoryblokQueryBuilder.newBuilder().build();
        assertEquals(storyblokQuery.toString(),"");
        storyblokQuery = StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .searchTerm("search")
                .addBySlug("app")
                .addExcludingId(123L)
                .addFilterQueryParameter("actor", FilterOperation.like,"*john*")
                .build();

        assertEquals("&by_slugs=app&excluding_ids=123&search_term=search&filter_query[actor][like]=*john*",storyblokQuery.toString());

        final UUID addUUID = UUID.fromString("ac0d2ed0-e323-43ca-ae59-5cd7d38683cb");
        final UUID addUUID2 = UUID.fromString("22f4fb1b-50b3-4bf2-816e-7d589e307421");
        storyblokQuery = StoryblokQuery.StoryblokQueryBuilder.newBuilder()
                .addByUUID(addUUID)
                .addByUUID(addUUID2)
                .language("de")
                .addFilterQueryParameter(FilterQueryParameter.of("age",FilterOperation.gt_int,"18"))
                .cv("123123123")
                .addExcludingId(33L)
                .searchTerm("someterm")
                .fallbackLang("en")
                .firstPublishedAtGt(LocalDateTime.of(2021,4,7,15,0,0))
                .resolveLinks(ResolveLinks.story)
                .build();

        assertEquals("&by_uuids=ac0d2ed0-e323-43ca-ae59-5cd7d38683cb,22f4fb1b-50b3-4bf2-816e-7d589e307421&excluding_ids=33&search_term=someterm&first_published_at_gt=2021-04-07T15:00&resolve_links=story&cv=123123123&language=de&fallback_lang=en&filter_query[age][gt_int]=18",storyblokQuery.toString());
    }
}
