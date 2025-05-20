package dados;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private int id;
    private int idUlog;
    private String nome;
    private List<Musica> playlist = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUlog() {
        return idUlog;
    }

    public void setIdUlog(int idUlog) {
        this.idUlog = idUlog;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Musica> playlist) {
        this.playlist = playlist;
    }

    public Playlist(String nome) {
        this.nome = nome;
    }

    public Playlist() {
    }

    public String toString() {
        return "" +
                "nome: " + nome +
                ", musicas: " + playlist;
    }

}
