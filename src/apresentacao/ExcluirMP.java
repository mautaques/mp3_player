package apresentacao;

import dados.Musica;
import dados.Playlist;
import negocio.SisAplicativo;

import javax.swing.*;

public class ExcluirMP extends JFrame{

    private JButton excluirButton;
    private JPanel ExcluirMP;
    private JButton voltarButton;
    private JComboBox playlistsComboBox;
    private JComboBox musicasComboBox;

    public ExcluirMP(SisAplicativo s) {

        setContentPane(ExcluirMP);
        setTitle("Excluir Música");
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

        excluirButton.addActionListener(e -> {

            boolean retorno = true;

            for(Playlist i: s.getUlog().getPlaylists()) {
                if(i.getNome().equals(playlistsComboBox.getSelectedItem())) {
                    for (Musica j : s.getMusicas()) {
                        if (j.getNome().equals(musicasComboBox.getSelectedItem())) {
                            s.excluirMusicaPlaylist(i.getNome(),j.getNome());
                            JOptionPane.showMessageDialog(null, "Música Excluída",
                                    "Excluir Música da Playlist", JOptionPane.INFORMATION_MESSAGE);
                            retorno = false;
                            new Playlists(s);
                            dispose();
                        }
                    }
                }
            }
            if(retorno) {
                JOptionPane.showMessageDialog(null, "música não selecionada/ou vazia",
                        "Excluir Música", JOptionPane.ERROR_MESSAGE);
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
