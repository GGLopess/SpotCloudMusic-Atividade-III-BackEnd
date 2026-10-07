import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorAudio {
    private final List<Audio> biblioteca = new ArrayList<>();

    public void adicionarAudio(Audio audio) {
        if (audio == null) {
            throw new IllegalArgumentException("Não é possível adicionar um item nulo.");
        }
        biblioteca.add(audio);
    }

    public List<Audio> getBiblioteca() {
        return Collections.unmodifiableList(biblioteca);
    }

    public Audio buscarPorTitulo(String titulo) {
        for (Audio a : biblioteca) {
            if (a.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return a;
            }
        }
        return null;
    }
}