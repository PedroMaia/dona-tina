package com.app.donatina.donatina;

/**
 * Class that contain the card view element
 *
 * @author Pedro Maia <pedromaia@nutrium.io>
 * @version 1.0
 * @since 07/10/2016.
 */
public class Card {
    public String name;
    public String description;
    public String imageUrl;

    public Card(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
