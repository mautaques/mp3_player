package dados;

import java.util.ArrayList;
import java.util.List;

public class Musica {

    private int id;
    private String nome;
    private List<Artista> artistasM = new ArrayList<>();
    private String arquivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Artista> getArtistasM() {
        return artistasM;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Musica() {
    }

    public String toString() {

        return "" +
                nome;
    }
}
