package com.example.spinnerconcept;

public class Animal {

    int animalId;
    String animalName;
    int imageId;

    public Animal(int animalId, String animalName, int imageId) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.imageId = imageId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
