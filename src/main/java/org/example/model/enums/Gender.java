package org.example.model.enums;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
