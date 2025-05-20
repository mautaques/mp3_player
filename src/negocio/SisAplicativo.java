package negocio;

import dados.Artista;
import dados.Musica;
import dados.Playlist;
import dados.Usuario;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SisAplicativo {

    private List<Usuario> usuarios = new ArrayList<>();

    private List<Artista> artistas = new ArrayList<>();

    private List<Musica> musicas = new ArrayList<>();

    private Usuario ulog;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Usuario getUlog() {
        return ulog;
    }

    public boolean cadastrarUsuario(String username, String senha) {
        boolean retorno = true;
        Usuario u = new Usuario();

        for (Usuario i : usuarios){
            if (i.getUsername().equals(username)) {
                retorno = false;
                break;
            }
        }
        u.setUsername(username);
        u.setSenha(senha);

        usuarios.add(u);
        return retorno;
    }

    public boolean excluirUsuario(Usuario usuario){
        if(usuarios.size() == 0){
            return false;
        }
        usuarios.remove(usuario);
        return true;
    }

    public boolean loginUsuario(String username, String senha){
        boolean retorno = false;

        for(Usuario i: usuarios){
            if(i.getUsername().equals(username)){
                if(i.getSenha().equals(senha)){
                    this.ulog = i;
                    retorno = true;
                    break;
                }
            }
        }

        return retorno;
    }

    public void logoutUsuario(){
        this.ulog = null;
    }

    public boolean criarPlaylist(String nome){
        boolean retorno = true;

        Playlist p = new Playlist();

            for(Playlist i: ulog.getPlaylists()) {
                if (i.getNome().equals(nome)) {
                    retorno = false;
                    break;
                }
            }

            if(retorno){
                p.setNome(nome);
                ulog.getPlaylists().add(p);
            }

        return retorno;
    }

    public boolean adicionarMusicaPlaylist(String nomeP, String nomeM){

        boolean retorno = true;

        for(Playlist i: ulog.getPlaylists()){
            if(i.getNome().equals(nomeP)){
                for(Musica j: getMusicas()){
                    if(i.getPlaylist().contains(j)){
                        retorno = false;
                    }
                }
            }
        }

        if(retorno){
            for(Playlist i: ulog.getPlaylists()){
                if(i.getNome().equals(nomeP)){
                    for(Musica j: getMusicas()){
                        if(j.getNome().equals(nomeM)){
                            i.getPlaylist().add(j);
                        }
                    }
                }
            }
        }

        return retorno;
    }

    public boolean excluirMusicaPlaylist(String nomeP, String nomeM){
        boolean retorno = false;

        for(Playlist i: ulog.getPlaylists()){
            if(i.getNome().equals(nomeP)){
                for(Musica j: getMusicas()){
                    if(j.getNome().equals(nomeM)){
                        i.getPlaylist().remove(j);
                        break;
                    }
                }
            }
        }
        return retorno;
    }

    public boolean adicionarMusica(String nome, String nomeArtista, String arquivo) {
        boolean retorno = true;

        int cont = 0;
        Musica m = new Musica();
        Artista a = new Artista();

        for (Musica i : getMusicas()) {
            if (i.getNome().equals(nome)) {
                retorno = false;
                break;
            }
        }

        if (retorno) {

            m.setNome(nome);
            m.setArquivo(arquivo);
            a.setNome(nomeArtista);
            m.getArtistasM().add(a);
            getMusicas().add(m);

            for(Artista i: getArtistas()){
                if(i.getNome().equals(nomeArtista)) {
                    i.getMusicasArtista().add(m);
                    cont++;
                    break;
                }
            }

            if(cont == 0) {
                getArtistas().add(a);
                a.getMusicasArtista().add(m);
            }
        }

        return retorno;
    }

    public boolean excluirMusica (String nome){
        boolean retorno = false;

        for(int i = 0; i < getMusicas().size(); i++) {
            if(getMusicas().get(i).getNome().equals(nome)) {
                getMusicas().remove(getMusicas().get(i));
                retorno = true;
            }
        }

        if(retorno) {
            for(Artista i: getArtistas()) {
                for(int j = 0; j < i.getMusicasArtista().size(); j++){
                    if(i.getMusicasArtista().get(j).getNome().equals(nome)){
                        i.getMusicasArtista().remove(i.getMusicasArtista().get(j));
                    }
                }
            }
        }

        return retorno;
    }

    public boolean reproduzirMusica (String nome){
        boolean retorno = false;

        for (Musica i : getMusicas()) {
            if (i.getNome().equals(nome)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(i.getArquivo());
                    Player mp3 = new Player(fileInputStream);
                    mp3.play(300);
                } catch (JavaLayerException | FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public boolean adicionarArtista(String nomeM, String nomeA) {
        boolean retorno = false;

        int cont = 0, cont2 = 0;
        Artista a = new Artista();

        for (Musica i : getMusicas()) {
            if (i.getNome().equals(nomeM)) {
                for (Artista j : i.getArtistasM()) {
                    if (j.getNome().equals(nomeA)) {
                        cont++;
                        break;
                    }
                }
                break;
            }
        }

        if (cont == 0) {
            for(Musica i: getMusicas()) {
                if(i.getNome().equals(nomeM)) {
                    for (Artista j : getArtistas()) {
                        if (j.getNome().equals(nomeA)) {
                            i.getArtistasM().add(j);
                            cont2++;
                            retorno = true;
                            break;
                        }
                    }
                }
            }

            if(cont2 == 0){
                for(Musica i: getMusicas()) {
                    if(i.getNome().equals(nomeM)) {
                        a.setNome(nomeA);
                        a.getMusicasArtista().add(i);
                        i.getArtistasM().add(a);
                        getArtistas().add(a);
                        retorno = true;
                        break;
                    }
                }
            }
        }

            return retorno;
        }

    }
