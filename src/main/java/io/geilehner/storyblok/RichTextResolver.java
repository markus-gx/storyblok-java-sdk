package io.geilehner.storyblok;

import io.geilehner.storyblok.exception.NotResolveableException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//todo Refactor
public class RichTextResolver {
    public static String resolveTextOfEntry(Map<String,Object> text) throws NotResolveableException {
        List<Map<String,Object>> content = (List<Map<String, Object>>) text.get("content");
        if(content!= null && !content.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            content.forEach(map -> resolveNode(map, stringBuilder));
            return stringBuilder.toString();
        }
        throw new NotResolveableException("Text cannot be resolved!");
    }

    private static void resolveNode(Map<String,Object> map, StringBuilder stringBuilder){
        final String type = (String) map.get("type");
        if(type.equalsIgnoreCase("horizontal_rule")){
            stringBuilder.append("<hr/>");
        }
        else{
            final String typeTag = getTagByName(type, (Map<String, Object>) map.get("attrs"),true);
            final List<Map<String,Object>> content = (List<Map<String, Object>>) map.get("content");
            stringBuilder.append(typeTag);
            if(content != null){
                content.forEach(cmap -> resolveNode(cmap, stringBuilder));
            }
            final List<Map<String,Object>> marks = (List<Map<String, Object>>) map.get("marks");
            if(marks != null && marks.size() > 0){
                final List<Object> markTypes = marks.stream().map(m -> m.get("type")).filter(Objects::nonNull).collect(Collectors.toList());
                stringBuilder.append(markTypes.stream().map(o -> getTagByName((String) o, (Map<String, Object>) marks.get(0).get("attrs"), true)).collect(Collectors.joining("", "", String.valueOf(map.get("text")))));
                Collections.reverse(markTypes);
                stringBuilder.append(markTypes.stream().map(o -> getTagByName((String) o, (Map<String, Object>) marks.get(0).get("attrs"), false)).collect(Collectors.joining()));
            }
            else if(type.equalsIgnoreCase("text")){
                stringBuilder.append(map.get("text"));
            }
            stringBuilder.append(getTagByName(type,(Map<String, Object>) map.get("attrs"),false));
        }
    }

    private static String getTagByName(String name,Map<String,Object> attrs, boolean opening){
        switch (name){
            case "paragraph": return opening ? "<p>" : "</p>";
            case "bold": return opening ? "<b>" : "</b>";
            case "italic": return opening ? "<i>" : "</i>";
            case "strike": return opening ? "<strike>" : "</strike>";
            case "underline": return opening ? "<u>" : "</u>";
            case "heading": {
                if(attrs != null){
                    int l = Integer.parseInt(replacePointAndNumbers("" + attrs.get("level")));
                    return opening ? "<h" + l + ">" : "</h" + l + ">";
                }
                return opening ? "<h1>" : "</h1>";
            }
            case "bullet_list": return opening ? "<ul>" : "</ul>";
            case "ordered_list": return opening ? "<ol>" : "</ol>";
            case "list_item": return opening ? "<li>" : "</li>";
            case "blockquote": return opening ? "<blockquote>" : "</blockquote>";
            case "link": {
                final String href = (String) attrs.get("href");
                final String target = (String) attrs.get("target");
                final String linktype = (String) attrs.get("linktype");
                return opening ? buildAnchorOpening(href,target,linktype) : "</a>";
            }
            case "image": {
                String img = (String) attrs.get("src");
                return opening ? "<img src=\"" + img + "\">" : "</img>";
            }
            case "code": return opening ? "<code>" : "</code>";
            case "code_block": {
                if(attrs != null){
                    final String clazz = (String) attrs.get("class");
                    return opening ? "<pre><code class=\"" + clazz + "\">" : "</code></pre>";
                }
                return opening ? "<pre><code>" : "</code></pre>";
            }
        }
        return "";
    }

    private static String buildAnchorOpening(String href, String target, String linktype){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<a");
        if(href != null){
            stringBuilder.append(" href=\"").append(href).append("\"");
        }
        if(target != null){
            stringBuilder.append(" target=\"").append(target).append("\"");
        }
        if(linktype != null){
            stringBuilder.append(" linktype=\"").append(linktype).append("\"");
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    private static String replacePointAndNumbers(String var){
        return var.substring(0,var.indexOf(".") > 0 ? var.indexOf(".") : var.length()-1);
    }
}
