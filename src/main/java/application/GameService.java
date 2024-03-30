package application;

import domain.Personage;
import domain.Stats;

public class GameService {

    // En el service es donde consultas la BBDD (haciendo uso de un ORM o similar, no directamente)
    private final PersonageRepository personageRepository;

    public GameService(PersonageRepository personageRepository) {
        this.personageRepository = personageRepository;
    }

    public void createDefaultPersonage(String name) {
        var personage = new Personage();
        personage.setName(name);
        personage.setStatsBase(new Stats());
        personage.setHealthPoints(personage.statsBase().vitality()*10);

        personageRepository.savePersonage(personage);
    }

    public void hitPersonage(String personageName, int damagePoints) {
        var personage = personageRepository.findPersonage(personageName);
        int currentHp = personage.healthPoints();
        personage.setHealthPoints(currentHp - damagePoints);
        personageRepository.savePersonage(personage);
    }

}
