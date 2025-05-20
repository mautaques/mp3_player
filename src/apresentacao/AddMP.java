package apresentacao;

import dados.Musica;
import dados.Playlist;
import negocio.SisAplicativo;

import javax.swing.*;

public class AddMP extends JFrame{

    private JPanel AddMP;
    private JButton adicionarButton;
    private JButton voltarButton;
    private JComboBox playlistsComboBox;
    private JComboBox musicasComboBox;

    public AddMP(SisAplicativo s) {

        setContentPane(AddMP);
        setTitle("Adicionar Música");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        for(Playlist i: s.getUlog().getPlaylists()) {
            playlistsComboBox.addItem(i.getNome());
        }

        for(Musica i: s.getMusicas()) {
            musicasComboBox.addItem(i.getNome());
        }

        adicionarButton.addActionListener(e -> {

            boolean retorno = true;

            for(Playlist i: s.getUlog().getPlaylists()) {
                if(i.getNome().equals(playlistsComboBox.getSelectedItem())) {
                    for (Musica j : s.getMusicas()) {
                        if (j.getNome().equals(musicasComboBox.getSelectedItem())) {
                            if(s.adicionarMusicaPlaylist(i.getNome(),j.getNome())) {
                                JOptionPane.showMessageDialog(null, "Música Adicionada",
                                        "Adicionar Música", JOptionPane.INFORMATION_MESSAGE);
                                retorno = false;
                                new Playlists(s);
                                dispose();
                            }
                        }
                    }
                }
            }

            if(retorno){
                JOptionPane.showMessageDialog(null, "música já adicionada ou musica/playlist vazias",
                        "Adicionar Música", JOptionPane.ERROR_MESSAGE);
                new Playlists(s);
                dispose();
            }
        });

        voltarButton.addActionListener(e -> {
            new Playlists(s);
            dispose();
        });
    }
}
