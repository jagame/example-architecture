package infrastructure;

import domain.Personage;
import application.PersonageRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class InMemoryGameRepository implements PersonageRepository {

    private final Map<String, Personage> inMemoryPersistence = new HashMap<>();

    @Override
    public Personage findPersonage(String name) {
        var personageFound = inMemoryPersistence.get(name);
        if(personageFound == null) {
            throw new NoSuchElementException("Personage with name %s not found".formatted(name));
        }
        return personageFound;
    }

    @Override
    public void savePersonage(Personage personage) {
        Objects.requireNonNull(personage, "You must to specify a personage");
        inMemoryPersistence.put(personage.name(), personage);
    }
}
