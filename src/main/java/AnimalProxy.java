import java.util.List;

public class AnimalProxy implements IAnimal {

    private Animal animal;

    private Integer id;

    public AnimalProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosAnimal() {
        if (this.animal == null) {
            this.animal = new Animal(this.id);
        }
        return this.animal.obterDadosAnimal();
    }

    @Override
    public List<String> obterListaServicosPrestados(Tutor tutor) {
        if (this.animal == null) {
            this.animal = new Animal(this.id);
        }
        if (!tutor.getCpf().equals(this.animal.getCpfTutor())) {
            throw new IllegalArgumentException("Ação não autorizada");
        }
        return this.animal.obterListaServicosPrestados(tutor);
    }
}
