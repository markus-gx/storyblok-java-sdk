# Storyblok Java SDK
## Currently only a Richtextresolver, but possibly an API will be created around it.
 
This (currently) small project is for resolving a JSON "Story-Blok" to HTML Text.

# What is Storyblok?
* Website: https://www.storyblok.com

# How to use?
Just include the class in src folder and use it like: 
``RichTextResolver.resolveTextOfEntry(<textToResolve>);``

# Example
If you retrieve a "blok" from the Storyblok API you can pass the `text` field into the above method. 
You can see a static JSON Example in the test files. 
