package cz.unicode.webapp.managers;

import cz.unicode.webapp.models.AnimalModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalManager {
   ArrayList<AnimalModel> animals = new ArrayList<>();

    public  ArrayList<AnimalModel> getAllAnimals() {
        return animals;
    }
    private int id = 0;
    public void addAnimals(AnimalModel animal) {
        animal.setId(id);
        id++;
        animals.add(animal);
    }

    public boolean removeAnimal(int id) {
        return animals.remove(returnAnimal(id));
    }

    public boolean editAnimals(int id, AnimalModel editedVersion) {
        if(doesAnimalExist(id)){
            AnimalModel currentAnimal = returnAnimal(id);
            currentAnimal.setName(editedVersion.getName());
            currentAnimal.setAge(editedVersion.getAge());
            currentAnimal.setGender(editedVersion.getGender());
            return true;
        } else {
            return false;
        }
    }

    public  AnimalModel returnAnimal(int id) {
        return  animals.stream()
                .filter(animalStream -> id == animalStream.getId())
                .findAny()
                .orElse(null);
    }

    public  boolean doesAnimalExist(int id) {
        return  animals.stream()
                .filter(animalStream -> id == animalStream.getId())
                .findAny()
                .orElse(null) != null;
    }
}
