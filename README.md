Plaintext
# SpotCloudMusic - Sistema de Gestão de Plataforma de Música

## Descrição do Projeto

O **SpotCloudMusic** é uma aplicação de console desenvolvida em Java (JDK 25) para gerenciamento de biblioteca musical. O sistema permite o cadastro, listagem e reprodução simulada de mídias de áudio, aplicando os pilares da Programação Orientada a Objetos (POO):

- **Encapsulamento:** Proteção dos atributos com modificadores de acesso privados e métodos de validação no acesso/modificação.
- **Herança:** A classe `Musica` estende a classe abstrata `Audio`, reutilizando atributos e comportamentos comuns.
- **Polimorfismo:** Sobrescrita de métodos abstratos (`getDetalhes()`) e uso da interface `Reproduzivel` para desacoplamento de chamadas.
- **Abstração:** Uso da interface `Reproduzivel` e da classe abstrata `Audio` para definir contratos operacionais sem expor detalhes de implementação.
- **Tratamento de Exceções:** Validação de entradas no terminal para prevenir interrupções inesperadas (*crashes*) diante de dados inválidos ou malformados.

---

## Estrutura do Projeto

A arquitetura é composta por 6 arquivos:

1. `Reproduzivel.java`: Interface que define o contrato de execução de áudios.
2. `TipoAudio.java`: Enumeração para categorização dos tipos de áudio suportados.
3. `Audio.java`: Classe abstrata base que implementa a interface e centraliza validações e atributos gerais.
4. `Musica.java`: Classe concreta especializada com atributos de faixa musical (artista, gênero).
5. `GerenciadorAudio.java`: Classe de serviço responsável pelo gerenciamento e busca dos dados na memória.
6. `Main.java`: Ponto de entrada do sistema contendo a interface via terminal e o fluxo interativo.

---

## Integrantes do Projeto

- Gabriel Lopes Machado
- Guilherme Alves Barbosa

---

## Requisitos de Ambiente

- **JDK 25** ou superior instalado e configurado nas variáveis de ambiente (`JAVA_HOME` e `PATH`).

---

## Instruções de Compilação e Execução

### 1. Organização dos Arquivos
Certifique-se de que todos os arquivos `.java` estão salvos no mesmo diretório:


├── Audio.java

├── GerenciadorAudio.java

├── Main.java

├── Musica.java

├── Reproduzivel.java

└── TipoAudio.java

### 2. Compilação
Abra o terminal ou prompt de comando na pasta do projeto e execute o comando abaixo para compilar todas as classes:

javac --enable-preview --release 25 *.java

*Nota: Caso o seu ambiente Java 25 utilize recursos em preview do I/O nativo, a flag `--enable-preview` deve ser mantida.*

### 3. Execução
Após a compilação sem erros, execute a classe principal `Main`:

java --enable-preview Main

---

## Fluxo do Menu de Opções

1. **Cadastrar nova Música:** Solicita título, artista, gênero e duração em segundos, validando se as entradas não são vazias ou numéricas inválidas.
2. **Listar biblioteca:** Exibe todas as músicas cadastradas e seus respectivos detalhes (duração formatada em mm:ss, total de reproduções, artista e gênero).
3. **Tocar uma Música:** Busca uma música pelo título na biblioteca, incrementa o contador de reproduções e exibe o estado atualizado.
4. **Sair:** Finaliza o loop e encerra a aplicação.