public abstract class Audio implements Reproduzivel {
    private String titulo;
    private int duracaoSegundos;
    private int totalReproducoes;

    public Audio(String titulo, int duracaoSegundos) {
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
        this.totalReproducoes = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.titulo = titulo.trim();
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    protected void incrementarReproducoes() {
        this.totalReproducoes++;
    }

    @Override
    public void tocar() {
        incrementarReproducoes();
        System.out.println("Tocando: " + titulo);
    }

    @Override
    public void pausar() {
        System.out.println("Pausado: " + titulo);
    }

    public abstract TipoAudio getTipo();
}