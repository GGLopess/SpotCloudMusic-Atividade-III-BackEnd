import static java.lang.IO.*;

import java.util.List;

public class Main {
    private static final GerenciadorAudio gerenciador = new GerenciadorAudio();

    public static void main(String[] args) {
        gerenciador.adicionarAudio(new Musica("conversa com uma menina branca", 100, "Djonga", "Rap"));
        gerenciador.adicionarAudio(new Musica("Welcome To The Jungle", 273, "Guns N' Roses", " Hard Rock"));

        boolean rodando = true;
        while (rodando) {
            exibirMenu();

            int opcao = Integer.parseInt(readln("Escolha uma opção: "));

            switch (opcao) {
                case 1 -> cadastrarMusica();
                case 2 -> listarAudios();
                case 3 -> reproduzirAudio();
                case 4 -> {
                    println("\nEncerrando o sistema... Até logo!");
                    rodando = false;
                }
                default -> println("Opção inválida! Escolha entre 1 e 4.");
            }
        }
    }

    private static void exibirMenu() {
        println("\n=== SpotCloudMusic ===");
        println("1. Cadastrar nova Música");
        println("2. Listar biblioteca");
        println("3. Tocar uma Música");
        println("4. Sair");
    }

    private static void cadastrarMusica() {
        println("\n--- Cadastro de Música ---");

        String titulo = readln("Título da música: ");
        while (titulo.trim().isEmpty()) {
            println("O título não pode ser vazio.");
            titulo = readln("Título da música: ");
        }

        String artista = readln("Nome do artista: ");
        while (artista.trim().isEmpty()) {
            println("O artista não pode ser vazio.");
            artista = readln("Nome do artista: ");
        }

        String genero = readln("Gênero musical: ");
        while (genero.trim().isEmpty()) {
            println("O gênero não pode ser vazio.");
            genero = readln("Gênero musical: ");
        }

        int duracao = lerInteiroPositivoValido("Duração em segundos: ");

        try {
            Musica novaMusica = new Musica(titulo, duracao, artista, genero);
            gerenciador.adicionarAudio(novaMusica);
            println("Música cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private static void listarAudios() {
        println("\n--- Biblioteca Musical ---");
        List<Audio> itens = gerenciador.getBiblioteca();
        if (itens.isEmpty()) {
            println("Nenhum áudio cadastrado.");
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            println((i + 1) + ". " + itens.get(i).getDetalhes());
        }
    }

    private static void reproduzirAudio() {
        println("\n--- Reproduzir Música ---");

        String titulo = readln("Digite o título da música: ");
        while (titulo.trim().isEmpty()) {
            println("O título não pode ser vazio.");
            titulo = readln("Digite o título da música: ");
        }

        Audio audio = gerenciador.buscarPorTitulo(titulo);

        if (audio != null) {
            audio.tocar();
            println(audio.getDetalhes());
        } else {
            println("Áudio não encontrado na biblioteca.");
        }
    }

    private static int lerInteiroValido(String mensagem) {
        while (true) {
            try {
                String entrada = readln(mensagem);
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                println("Digite um número inteiro válido.");
            }
        }
    }

    private static int lerInteiroPositivoValido(String mensagem) {
        while (true) {
            int valor = lerInteiroValido(mensagem);
            if (valor > 0) {
                return valor;
            }
            println("O valor deve ser maior que zero.");
        }
    }
}
