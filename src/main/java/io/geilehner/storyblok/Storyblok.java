package io.geilehner.storyblok;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.geilehner.storyblok.adapters.*;
import io.geilehner.storyblok.exception.StoryblokException;
import io.geilehner.storyblok.model.*;
import io.geilehner.storyblok.model.content.StoryContent;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Storyblok {
    private final String API_URL = "https://api.storyblok.com/v1/cdn";
    private final String API_KEY;
    private final String MAPI_URL;
    private final String OAUTH_TOKEN;
    private final String SPACE_ID;
    private Gson gson;

    /**
     * Initialize Storyblok API
     * @param apiKey
     */
    public Storyblok(String apiKey){
        this(apiKey,null,null);
    }

    /**
     * Initialize Storyblok Content Delivery API and Management API
     * @param apiKey API KEY for content delivery API
     * @param oAuthToken To access the management API
     * @param spaceId On which space the management API should operate on
     */
    public Storyblok(String apiKey, String oAuthToken, String spaceId){
        this.API_KEY = apiKey;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .registerTypeAdapter(Long.class,new LongTypeAdapter())
                .registerTypeAdapter(UUID.class,new UUIDTypeAdapter())
                .registerTypeAdapter(Integer.class,new IntegerTypeAdapter())
                .registerTypeAdapter(Double.class, new DoubleTypeAdapter())
                .create();
        this.OAUTH_TOKEN = oAuthToken;
        this.SPACE_ID = spaceId;
        this.MAPI_URL = spaceId != null ? "https://mapi.storyblok.com/v1/spaces/" + spaceId + "/" : null;
    }

    /**
     * Fetch a story based on the given slug or id or uuid
     * @param fullSlugOrIdOrUUID (:full_slug|:id|:uuid)
     * @return {@link Story<Map<String,Object>}
     * @throws StoryblokException
     */
    public Story<Map<String,Object>> fetchStory(String fullSlugOrIdOrUUID) throws StoryblokException {
        return fetchStory(fullSlugOrIdOrUUID, (Class<Map<String,Object>>)(Class)Map.class);
    }

    /***
     * Fetch a story based on the given slug or id or uuid and given queryBuilder {@link StoryblokQuery}
     * @param fullSlugOrIdOrUUID (:full_slug|:id|:uuid)
     * @param query {@link StoryblokQuery} for enhanced filtering
     * @return {@link Story<Map<String,Object>}
     * @throws StoryblokException
     */
    public Story<Map<String,Object>> fetchStory(String fullSlugOrIdOrUUID, StoryblokQuery query) throws StoryblokException {
        return fetchStory(fullSlugOrIdOrUUID,query, (Class<Map<String,Object>>)(Class)Map.class);
    }

    /**
     * Fetch a story based on the given slug or id or uuid and parse the content attribute to a certain type.
     * @param fullSlugOrIdOrUUID (:full_slug|:id|:uuid)
     * @param type The type the content attribute should be converted in
     * @return {@link Story<T>}
     * @throws StoryblokException
     */
    public <T> Story<T> fetchStory(String fullSlugOrIdOrUUID, Class<T> type) throws StoryblokException {
        if(fullSlugOrIdOrUUID == null) throw new IllegalArgumentException();
        return fetch(String.join("","/stories/",fullSlugOrIdOrUUID),type,null);
    }

    /***
     * Fetch a story based on the given slug
     * @@param fullSlugOrIdOrUUID (:full_slug|:id|:uuid)
     * @param query {@link StoryblokQuery} for enhanced filtering
     * @param type The type the content attribute should be converted in
     * @return {@link Story<T>}
     * @throws StoryblokException
     */
    public <T> Story<T> fetchStory(String fullSlugOrIdOrUUID, StoryblokQuery query, Class<T> type) throws StoryblokException {
        if(fullSlugOrIdOrUUID == null) throw new IllegalArgumentException();
        if(query == null) return fetchStory(fullSlugOrIdOrUUID,type);
        return fetch(String.join("","/stories/",fullSlugOrIdOrUUID),type,query);
    }

    /**
     * Fetch multiple stories based on the given queryBuilder
     * @param query {@link StoryblokQuery}
     * @return
     * @throws StoryblokException
     */
    public Stories<Map<String,Object>> fetchStories(StoryblokQuery query) throws StoryblokException {
        return fetchMultiple("/stories",(Class<Map<String,Object>>)(Class)Map.class,query);
    }

    public <T> Stories<T> fetchStories(StoryblokQuery query, Class<T> type) throws StoryblokException {
        return fetchMultiple("/stories",type,query);
    }

    public <T extends StoryContent> ManagementStory<T> createStory(ManagementStory<T> story, Class<T> type) throws StoryblokException {
        if(this.MAPI_URL == null) throw new StoryblokException("Management API not initialized!");
        HttpResponse<JsonNode> response = null;
        try{
            response = Unirest.post(ObjectType.STORY.getPath(this.MAPI_URL))
                    .header("Authorization", this.OAUTH_TOKEN)
                    .header("Content-Type","application/json")
                    .body(gson.toJson(story)).asJson();
            if(response.getStatus() < 300){
                Type collectionType = TypeToken.getParameterized(ManagementStory.class,type).getType();
                return gson.fromJson(response.getBody().getObject().toString(),collectionType);
            }
        }catch (UnirestException e){
            throw new StoryblokException(e.getMessage());
        }
        throw new StoryblokException(response.getStatus(),response.getStatusText());
    }

    public <T extends StoryContent> ManagementStory<T> updateStory(ManagementStory<T> story, Class<T> type) throws StoryblokException {
        if(this.MAPI_URL == null) throw new StoryblokException("Management API not initialized!");
        HttpResponse<JsonNode> response = null;
        try{
            response = Unirest.put(ObjectType.STORY.getPath(this.MAPI_URL).concat(String.valueOf(story.getStory().getId())))
                    .header("Authorization", this.OAUTH_TOKEN)
                    .header("Content-Type","application/json")
                    .body(gson.toJson(story)).asJson();
            if(response.getStatus() < 300){
                Type collectionType = TypeToken.getParameterized(ManagementStory.class,type).getType();
                return gson.fromJson(response.getBody().getObject().toString(),collectionType);
            }
        }catch (UnirestException e){
            throw new StoryblokException(e.getMessage());
        }
        throw new StoryblokException(response.getStatus(),response.getStatusText());
    }

    public boolean deleteStory(Long storyId) throws StoryblokException {
        if(this.MAPI_URL == null) throw new StoryblokException("Management API not initialized!");
        HttpResponse<JsonNode> response = null;
        try{
            response = Unirest.delete(ObjectType.STORY.getPath(this.MAPI_URL).concat(String.valueOf(storyId)))
                    .header("Authorization", this.OAUTH_TOKEN).asJson();
            if(response.getStatus() < 300){
                return true;
            }
        }catch (UnirestException e){
            throw new StoryblokException(e.getMessage());
        }
        return false;
    }

    private <T> Story<T> fetch(String path, Class<T> type, StoryblokQuery storyblokQuery) throws StoryblokException {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(getRequestUrl(path,storyblokQuery)).asJson();
            if(response.getStatus() < 300){
                Type collectionType = TypeToken.getParameterized(Story.class,type).getType();
                return gson.fromJson(response.getBody().getObject().get("story").toString(),collectionType);
            }
        } catch (UnirestException e) {
            throw new StoryblokException(e.getMessage());
        }
        throw new StoryblokException(response.getStatus(),response.getStatusText());
    }

    private <T> Stories<T> fetchMultiple(String path, Class<T> type, StoryblokQuery storyblokQuery) throws StoryblokException {
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(getRequestUrl(path,storyblokQuery)).asJson();
            if(response.getStatus() < 300){
                Type collectionType = TypeToken.getParameterized(Stories.class,type).getType();
                Stories<T> stories = gson.fromJson(response.getBody().getObject().toString(),collectionType);
                stories.setPerPage(Integer.parseInt(response.getHeaders().getFirst("Per-Page")));
                stories.setTotal(Integer.parseInt(response.getHeaders().getFirst("Total")));
                return stories;
            }
        } catch (UnirestException e) {
            throw new StoryblokException(e.getMessage());
        }
        throw new StoryblokException(response.getStatus(),response.getStatusText());
    }

    private String getRequestUrl(String path,StoryblokQuery storyblokQuery){
        if(storyblokQuery == null){
            return this.API_URL.concat(path).concat("?token=").concat(this.API_KEY);
        }
        return this.API_URL.concat(path).concat("?token=").concat(this.API_KEY).concat(storyblokQuery.toString());
    }
}
