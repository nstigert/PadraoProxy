import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal implements IAnimal {
    private Integer id;
    private String nome;
    private String cpfTutor;
    private ArrayList<String> servicos;

    public Animal(int id) {
        this.id = id;
        Animal objeto = BD.getAnimal(id);
        this.nome = objeto.nome;
        this.cpfTutor = objeto.cpfTutor;
        this.servicos = objeto.servicos;
    }

    public Animal(Integer id, String nome, String cpfTutor) {
        this.id = id;
        this.nome = nome;
        this.cpfTutor = cpfTutor;
        this.servicos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getCpfTutor() {
        return cpfTutor;
    }

    public void adicionarServico(String servico) {
        this.servicos.add(servico);
    }

    @Override
    public List<String> obterDadosAnimal() {
        return Arrays.asList(this.nome, this.cpfTutor);
    }

    @Override
    public List<String> obterListaServicosPrestados(Tutor tutor) {
        return this.servicos;
    }
}
