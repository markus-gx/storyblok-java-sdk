package io.geilehner.storyblok.exception;

public class StoryblokException extends Exception{
    public StoryblokException(String message){
        super(message);
    }

    public StoryblokException(int httpStatus, String text){
        super(text.concat(" - ").concat(httpStatus+""));
    }
}
