import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalProxyTest {

    @BeforeEach
    void setUp() {
        Animal animal1 = new Animal(1, "Marie", "11111111111");
        animal1.adicionarServico("Banho");
        animal1.adicionarServico("Tosa");
        animal1.adicionarServico("Banho");

        Animal animal2 = new Animal(2, "Nina", "11111111111");
        animal2.adicionarServico("Banho");

        BD.addAnimal(animal1);
        BD.addAnimal(animal2);
    }

    @Test
    void deveRetornarDadosAnimal() {
        AnimalProxy animal = new AnimalProxy(1);

        assertEquals(Arrays.asList("Marie", "11111111111"), animal.obterDadosAnimal());
    }

    @Test
    void deveRetonarServicosPrestadosAoAnimal() {
        Tutor tutor = new Tutor("Nathalia", "11111111111");
        AnimalProxy animal = new AnimalProxy(2);

        assertEquals(Arrays.asList("Banho"), animal.obterListaServicosPrestados(tutor));
    }

    @Test
    void deveRetonarAcaoNaoAutorizadaConsultarServicosPrestadosAoAnimal() {
        try {
            Tutor tutor = new Tutor("Marco", "22222222222");
            AnimalProxy animal = new AnimalProxy(2);

            animal.obterListaServicosPrestados(tutor);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Ação não autorizada", e.getMessage());
        }
    }
}