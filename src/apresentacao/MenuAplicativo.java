package apresentacao;

import negocio.SisAplicativo;

import javax.swing.*;

public class MenuAplicativo extends JFrame{
    private JButton opcoesButton;
    private JButton playlistsButton;
    private JButton artistasButton;
    private JButton musicasButton;
    private JPanel MenuAplicativo;

    public MenuAplicativo(SisAplicativo s) {

        setContentPane(MenuAplicativo);
        setTitle("MenuAplicativo");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        playlistsButton.addActionListener(e -> {
            new Playlists(s);
            dispose();
        });

        artistasButton.addActionListener(e -> {
            new Artistas(s);
            dispose();
        });

        musicasButton.addActionListener(e -> {
            new Musicas(s);
            dispose();
        });

        opcoesButton.addActionListener(e -> {
            new Opcoes(s);
            dispose();
        });
    }
}
