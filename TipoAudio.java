public enum TipoAudio {
    MUSICA("Música"),
    PODCAST("Podcast");

    private final String descricao;

    TipoAudio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}