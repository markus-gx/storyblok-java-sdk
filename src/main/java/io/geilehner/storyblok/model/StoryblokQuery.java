package io.geilehner.storyblok.model;

import io.geilehner.storyblok.model.content.FilterOperation;
import io.geilehner.storyblok.model.content.ResolveLinks;
import io.geilehner.storyblok.model.content.StoryVersion;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StoryblokQuery{
    private String startsWith;
    private List<UUID> byUUIDs;
    private List<String> bySlugs;
    private List<String> excludingSlugs;
    private List<UUID> byUUIDsOrdered;
    private List<Long> excludingIds;
    private List<String> excludingFields;
    private String inWorkflowStages;
    private String searchTerm;
    private LocalDateTime firstPublishedAtGt;
    private LocalDateTime firstPublishedAtLt;
    private LocalDateTime publishedAtGt;
    private LocalDateTime publishedAtLt;
    private Boolean isStartPage;
    private Integer page;
    private Integer perPage;


    private String findBy;
    private StoryVersion version;
    private ResolveLinks resolveLinks;
    private String resolveRelations;
    private String fromRelease;
    private String cv;
    private String language;
    private String fallbackLang;
    private Set<FilterQueryParameter> filterQueryParameters;

    private StoryblokQuery(String startsWith, List<UUID> byUUIDs, List<String> bySlugs, List<String> excludingSlugs, List<UUID> byUUIDsOrdered, List<Long> excludingIds, List<String> excludingFields, String inWorkflowStages, String searchTerm, LocalDateTime firstPublishedAtGt, LocalDateTime firstPublishedAtLt, LocalDateTime publishedAtGt, LocalDateTime publishedAtLt, Boolean isStartPage, Integer page, Integer perPage, String findBy, StoryVersion version, ResolveLinks resolveLinks, String resolveRelations, String fromRelease, String cv, String language, String fallbackLang, Set<FilterQueryParameter> filterQueryParameters) {
        this.startsWith = startsWith;
        this.byUUIDs = byUUIDs;
        this.bySlugs = bySlugs;
        this.excludingSlugs = excludingSlugs;
        this.byUUIDsOrdered = byUUIDsOrdered;
        this.excludingIds = excludingIds;
        this.excludingFields = excludingFields;
        this.inWorkflowStages = inWorkflowStages;
        this.searchTerm = searchTerm;
        this.firstPublishedAtGt = firstPublishedAtGt;
        this.firstPublishedAtLt = firstPublishedAtLt;
        this.publishedAtGt = publishedAtGt;
        this.publishedAtLt = publishedAtLt;
        this.isStartPage = isStartPage;
        this.page = page;
        this.perPage = perPage;
        this.findBy = findBy;
        this.version = version;
        this.resolveLinks = resolveLinks;
        this.resolveRelations = resolveRelations;
        this.fromRelease = fromRelease;
        this.cv = cv;
        this.language = language;
        this.fallbackLang = fallbackLang;
        this.filterQueryParameters = filterQueryParameters;
    }

    @Override
    /**
     * Converts the StoryblokQuery to an appendable string query e.g &key=value&key2=value2
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(startsWith != null){
            stringBuilder.append("&starts_with=").append(this.startsWith);
        }
        if(byUUIDs != null && !byUUIDs.isEmpty()){
            stringBuilder.append("&by_uuids=").append(byUUIDs.stream().map(UUID::toString).collect(Collectors.joining(",")));
        }
        if(bySlugs != null && !bySlugs.isEmpty()){
            stringBuilder.append("&by_slugs=").append(String.join(",", bySlugs));
        }
        if(excludingSlugs != null && !excludingSlugs.isEmpty()){
            stringBuilder.append("&excluding_slugs=").append(String.join(",",excludingSlugs));
        }
        if(byUUIDsOrdered != null && !byUUIDsOrdered.isEmpty()){
            stringBuilder.append("&by_uuids_ordered=").append(byUUIDsOrdered.stream().map(UUID::toString).collect(Collectors.joining(",")));
        }
        if(excludingIds != null && !excludingIds.isEmpty()){
            stringBuilder.append("&excluding_ids=").append(excludingIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
        if(excludingFields != null && !excludingFields.isEmpty()){
            stringBuilder.append("&excluding_fields=").append(String.join(",",excludingFields));
        }
        if(inWorkflowStages != null){
            stringBuilder.append("&in_workflow_stages=").append(inWorkflowStages);
        }
        if(searchTerm != null){
            stringBuilder.append("&search_term=").append(searchTerm);
        }
        if(firstPublishedAtGt != null){
            stringBuilder.append("&first_published_at_gt=").append(firstPublishedAtGt.toString());
        }
        if(firstPublishedAtLt != null){
            stringBuilder.append("&first_published_at_lt=").append(firstPublishedAtLt.toString());
        }

        if(publishedAtGt != null){
            stringBuilder.append("&published_at_gt=").append(publishedAtGt.toString());
        }
        if(publishedAtLt != null){
            stringBuilder.append("&published_at_lt=").append(publishedAtLt.toString());
        }
        if(isStartPage != null){
            stringBuilder.append("&is_startpage=").append(isStartPage ? "1" : "0");
        }
        if(page != null){
            stringBuilder.append("&page=").append(page);
        }
        if(perPage != null){
            stringBuilder.append("&per_page=").append(perPage);
        }
        if(findBy != null){
            stringBuilder.append("&find_by=").append(findBy);
        }
        if(version != null){
            stringBuilder.append("&version=").append(version.name());
        }
        if(resolveLinks != null){
            stringBuilder.append("&resolve_links=").append(resolveLinks.toString());
        }
        if(resolveRelations != null){
            stringBuilder.append("&resolve_relations=").append(resolveRelations);
        }
        if(fromRelease  != null){
            stringBuilder.append("&from_release=").append(fromRelease);
        }
        if(cv != null){
            stringBuilder.append("&cv=").append(cv);
        }
        if(language != null){
            stringBuilder.append("&language=").append(language);
        }
        if(fallbackLang != null){
            stringBuilder.append("&fallback_lang=").append(fallbackLang);
        }
        if(filterQueryParameters != null && !filterQueryParameters.isEmpty()){
            filterQueryParameters.forEach(fq -> {
                stringBuilder.append("&").append(fq.build());
            });
        }
        return stringBuilder.toString();
    }

    public static class StoryblokQueryBuilder {
        private StoryblokQueryBuilder(){}

        private String startsWith;
        private List<UUID> byUUIDs;
        private List<String> bySlugs;
        private List<String> excludingSlugs;
        private List<UUID> byUUIDsOrdered;
        private List<Long> excludingIds;
        private List<String> excludingFields;
        private String inWorkflowStages;
        private String searchTerm;
        private LocalDateTime firstPublishedAtGt;
        private LocalDateTime firstPublishedAtLt;
        private LocalDateTime publishedAtGt;
        private LocalDateTime publishedAtLt;
        private Boolean isStartPage;
        private Integer page;
        private Integer perPage;


        private String findBy;
        private StoryVersion version;
        private ResolveLinks resolveLinks;
        private String resolveRelations;
        private String fromRelease;
        private String cv;
        private String language;
        private String fallbackLang;
        private Set<FilterQueryParameter> filterQueryParameters;

        /**
         * Create a new Builder;
         * @return
         */
        public static StoryblokQueryBuilder newBuilder(){
            return new StoryblokQueryBuilder();
        }


        /**
         * Filter by full_slug. Can be used to retrieve all entries form a specific folder.
         * Examples: de/beitraege, en/posts.
         * Attention: If you use field level translations and a root folder with the same name of a language code you need to prepend [default] to the path to retrieve the default language (Example: starts_with=[default]/de/home).
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/stories}
         * @param startsWith
         * @return {@link StoryblokQueryBuilder}
         */
        public StoryblokQueryBuilder startsWith(String startsWith) {
            this.startsWith = startsWith;
            return this;
        }

        /**
         * Get stories by UUIDs.
         * To get a specific language you need to combine this filter with starts_with=en/* (replace en with your langauge)
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/stories}
         * @param uuid
         * @return {@link StoryblokQueryBuilder}
         */
        public StoryblokQueryBuilder addByUUID(UUID uuid){
            if(this.byUUIDs == null){
                this.byUUIDs = new ArrayList<>();
            }
            this.byUUIDs.add(uuid);
            return this;
        }

        /**
         * Get stories by full_slug's.
         * You can also specify wildcards with *.
         * Examples: authors/john, authors/max, authors/*,articles/*
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/stories}
         * @param slug
         * @return
         */
        public StoryblokQueryBuilder addBySlug(String slug) {
            if(this.bySlugs == null){
                this.bySlugs = new ArrayList<>();
            }
            this.bySlugs.add(slug);
            return this;
        }

        /**
         * Exclude stories by full_slug's.
         * You can also specify wildcards with *.
         * Examples: authors/john, authors/max, authors/*,articles/*
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/stories}
         * @param slug
         * @return
         */
        public StoryblokQueryBuilder addExcludingSlug(String slug) {
            if(this.excludingSlugs == null){
                this.excludingSlugs = new ArrayList<>();
            }
            this.excludingSlugs.add(slug);
            return this;
        }

        /**
         * Get stories added uuid's ordered by the sequence provided
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/stories}
         * @param uuid
         * @return
         */
        public StoryblokQueryBuilder addByUUIDsOrdered(UUID uuid){
            if(this.byUUIDsOrdered== null){
                this.byUUIDsOrdered = new ArrayList<>();
            }
            this.byUUIDsOrdered.add(uuid);
            return this;
        }

        /***
         * Exclude stories with the id added
         * @param excludingId
         * @return
         */
        public StoryblokQueryBuilder addExcludingId(Long excludingId) {
            if(this.excludingIds == null){
                this.excludingIds = new ArrayList<>();
            }
            this.excludingIds.add(excludingId);
            return this;
        }

        /**
         * Add fields to exclude from your content object
         * @param excludingField
         * @return
         */
        public StoryblokQueryBuilder addExcludingFields(String excludingField) {
            if(this.excludingFields == null){
                this.excludingFields = new ArrayList<>();
            }
            this.excludingFields.add(excludingField);
            return this;
        }

        /**
         * Comma separated list of ids. Example: in_workflow_stages=3,4
         * @param inWorkflowStages
         * @return
         */
        public StoryblokQueryBuilder inWorkflowStages(String inWorkflowStages) {
            this.inWorkflowStages = inWorkflowStages;
            return this;
        }

        /**
         * Search content items by full text.
         * @param searchTerm
         * @return
         */
        public StoryblokQueryBuilder searchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
            return this;
        }

        /**
         * After a specific first published date (Format: 2018-03-03 10:00)
         * @param firstPublishedAtGt
         * @return
         */
        public StoryblokQueryBuilder firstPublishedAtGt(LocalDateTime firstPublishedAtGt) {
            this.firstPublishedAtGt = firstPublishedAtGt;
            return this;
        }

        /**
         * Before a specific first published date (Format: 2018-03-03 10:00)
         * @param firstPublishedAtLt
         * @return
         */
        public StoryblokQueryBuilder firstPublishedAtLt(LocalDateTime firstPublishedAtLt) {
            this.firstPublishedAtLt = firstPublishedAtLt;
            return this;
        }

        /**
         * After a specific published date (Format: 2018-03-03 10:00)
         * @param publishedAtGt
         * @return
         */
        public StoryblokQueryBuilder publishedAtGt(LocalDateTime publishedAtGt) {
            this.publishedAtGt = publishedAtGt;
            return this;
        }

        /**
         * Before a specific published date (Format: 2018-03-03 10:00)
         * @param publishedAtLt
         * @return
         */
        public StoryblokQueryBuilder publishedAtLt(LocalDateTime publishedAtLt) {
            this.publishedAtLt = publishedAtLt;
            return this;
        }

        /**
         * Filter by folder startpage. Use {true} to only return startpages and {false} to exclude startpages from the result.
         * @param startPage
         * @return
         */
        public StoryblokQueryBuilder startPage(boolean startPage) {
            isStartPage = startPage;
            return this;
        }

        /**
         * When retrieving multiple stories, the page which should be fetched can be set.
         * See {https://www.storyblok.com/docs/api/content-delivery#topics/pagination}
         * @param page
         * @return
         */
        public StoryblokQueryBuilder page(int page) {
            this.page = page;
            return this;
        }

        /**
         * How many entries per page should be fetched.
         * Default: 25. Max: 100
         * @param perPage
         * @return
         */
        public StoryblokQueryBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        /**
         * Added if you want to query by uuid instead of using the numeric id
         * @param findBy
         * @return
         */
        public StoryblokQueryBuilder findBy(String findBy) {
            this.findBy = findBy;
            return this;
        }

        /**
         * The version of the story
         * @param version {@link StoryVersion}
         * @return
         */
        public StoryblokQueryBuilder version(StoryVersion version) {
            this.version = version;
            return this;
        }

        /**
         * The parameter resolve_links will automatically resolve internal links of the multilink field type.
         * If the value is 'story' the whole story object will be included.
         * If the value is 'url' only uuid, id, name, path, slug and url (url is a computed property which returns the "Real path" if defined to use it for navigation links) will be included.
         * The limit of resolved links per Story is 50 when resolving with story and 100 when resolving with url.
         * See {https://www.storyblok.com/docs/api/content-delivery#core-resources/stories/retrieve-one-story}
         * @param resolveLinks
         * @return
         */
        public StoryblokQueryBuilder resolveLinks(ResolveLinks resolveLinks) {
            this.resolveLinks = resolveLinks;
            return this;
        }

        /***
         * Resolve relationships to other Stories of a multi-option or single-option field-type.
         * Provide the component name and the field key as comma separated string. The limit of resolved relationships is 100 Stories.
         * See {https://www.storyblok.com/tp/using-relationship-resolving-to-include-other-content-entries}
         * @param resolveRelations
         * @return
         */
        public StoryblokQueryBuilder resolveRelations(String resolveRelations) {
            this.resolveRelations = resolveRelations;
            return this;
        }

        /**
         * Access version of specific release by release id
         * @param fromRelease
         * @return
         */
        public StoryblokQueryBuilder fromRelease(String fromRelease) {
            this.fromRelease = fromRelease;
            return this;
        }

        /**
         * Add a cache version
         * Read more at {https://www.storyblok.com/docs/api/content-delivery#topics/cache-invalidation}
         * @param cv
         * @return
         */
        public StoryblokQueryBuilder cv(String cv) {
            this.cv = cv;
            return this;
        }

        /**
         * Add the language i18n code as query parameter to receive a localized version when using a numeric id or uuid as path parameter
         * @param language
         * @return
         */
        public StoryblokQueryBuilder language(String language) {
            this.language = language;
            return this;
        }

        /**
         * Define a custom fallback language (i18n code). By default the fallback language is the one defined in the space settings
         * @param fallbackLang
         * @return
         */
        public StoryblokQueryBuilder fallbackLang(String fallbackLang) {
            this.fallbackLang = fallbackLang;
            return this;
        }

        /**
         * Add a filter query parameter to the query
         * @param attribute
         * @param filterOperation
         * @param value
         * @return
         */
        public StoryblokQueryBuilder addFilterQueryParameter(String attribute, FilterOperation filterOperation, String value){
            return addFilterQueryParameter(FilterQueryParameter.of(attribute,filterOperation,value));
        }

        /**
         * Add a filter query parameter to the query
         * @param queryParameter
         * @return
         */
        public StoryblokQueryBuilder addFilterQueryParameter(FilterQueryParameter queryParameter){
            if(this.filterQueryParameters == null){
                this.filterQueryParameters = new HashSet<>();
            }
            this.filterQueryParameters.add(queryParameter);
            return this;
        }

        public StoryblokQuery build(){
            return new StoryblokQuery(startsWith,byUUIDs,bySlugs,excludingSlugs,byUUIDsOrdered,excludingIds,excludingFields,inWorkflowStages,searchTerm,firstPublishedAtGt,firstPublishedAtLt,publishedAtGt,publishedAtLt,isStartPage,page,perPage,findBy,version,resolveLinks,resolveRelations,fromRelease,cv,language,fallbackLang,filterQueryParameters);
        }
    }
}

