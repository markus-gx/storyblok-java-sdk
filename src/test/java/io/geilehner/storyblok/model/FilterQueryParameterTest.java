package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.FilterOperation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilterQueryParameterTest {

    @Test
    public void testFilterQueryParameter(){
        Assert.assertEquals("filter_query[author][in]=something",FilterQueryParameter.of("author", FilterOperation.in,"something").build());
    }
}
