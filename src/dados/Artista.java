package dados;

import java.util.ArrayList;
import java.util.List;

public class Artista {

    private int id;
    private String nome;
    private List<Musica> musicasArtista = new ArrayList<>();

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

    public List<Musica> getMusicasArtista() {
        return musicasArtista;
    }

    public Artista() {
    }

    public String toString() {

        return "" +
                nome +
                ", musicas: " +
                musicasArtista;
    }
}
