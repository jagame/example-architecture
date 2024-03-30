package application;

import domain.Personage;

public interface PersonageRepository {

    Personage findPersonage(String name);
    void savePersonage(Personage personage);

}
