public class Musica extends Audio {
    private String artista;
    private String genero;

    public Musica(String titulo, int duracaoSegundos, String artista, String genero) {
        super(titulo, duracaoSegundos);
        setArtista(artista);
        setGenero(genero);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("O artista não pode ser vazio.");
        }
        this.artista = artista.trim();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("O gênero não pode ser vazio.");
        }
        this.genero = genero.trim();
    }

    @Override
    public TipoAudio getTipo() {
        return TipoAudio.MUSICA;
    }

    @Override
    public String getDetalhes() {
        int minutos = getDuracaoSegundos() / 60;
        int segundos = getDuracaoSegundos() % 60;
        return String.format("[%s] %s - %s (%02d:%02d) | Reproduções: %d | Gênero: %s",
                getTipo().getDescricao(), getTitulo(), artista, minutos, segundos, getTotalReproducoes(), genero);
    }
}