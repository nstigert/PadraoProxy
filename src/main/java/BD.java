import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Animal> animais = new HashMap<>();

    public static Animal getAnimal(Integer id) {
        return animais.get(id);
    }

    public static void addAnimal(Animal animal) {
        animais.put(animal.getId(), animal);
    }
}
