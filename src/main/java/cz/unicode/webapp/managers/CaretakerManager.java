package cz.unicode.webapp.managers;

import cz.unicode.webapp.models.AnimalModel;
import cz.unicode.webapp.models.CaretakerModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class CaretakerManager {
    ArrayList<CaretakerModel> careTakers = new ArrayList<>();

    public  ArrayList<CaretakerModel> getAllCareTakers() {
        return careTakers;
    }
    private int id = 0;
    public void addCareTaker(CaretakerModel careTaker) {
        careTaker.setId(id);
        id++;
        careTakers.add(careTaker);
    }

    public boolean removeCareTaker(int id) {
        return careTakers.remove(returnCareTaker(id));
    }

    public boolean editCareTaker(int id, CaretakerModel editedVersion) {
        if(doesCareTakerExists(id)){
            CaretakerModel currentCareTaker = returnCareTaker(id);
            currentCareTaker.setFirstName(editedVersion.getFirstName());
            currentCareTaker.setLastName(editedVersion.getLastName());
            currentCareTaker.setGender(editedVersion.getGender());
            return true;
        } else {
            return false;
        }
    }

    public CaretakerModel returnCareTaker(int id) {
        return  careTakers.stream()
                .filter(caretaker -> id == caretaker.getId())
                .findAny()
                .orElse(null);
    }

    public  boolean doesCareTakerExists(int id) {
        return  careTakers.stream()
                .filter(animalStream -> id == animalStream.getId())
                .findAny()
                .orElse(null) != null;
    }
}
