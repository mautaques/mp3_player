package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    private int id;
    private String username;
    private String senha;

    private List<Playlist> playlists = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Usuario() {
    }

    public String toString() {
        return "username: " + username +
                ", senha: " + senha +
                ", playlists: " + playlists;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getUsername(), usuario.getUsername());
    }
}
