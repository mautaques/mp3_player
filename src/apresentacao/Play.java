package apresentacao;

import dados.Musica;
import negocio.SisAplicativo;

import javax.swing.*;

public class Play extends JFrame{
    private JPanel Play;
    private JButton okButton;
    private JComboBox musicaComboBox;
    private JButton playButton;

    public Play(SisAplicativo s) {

        setContentPane(Play);
        setTitle("Player");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        for(Musica i: s.getMusicas()) {
            musicaComboBox.addItem(i.getNome());
        }

        playButton.addActionListener(e -> {

            int cont = 0;

            for(Musica i: s.getMusicas()){
                if(i.getNome().equals(musicaComboBox.getSelectedItem())){
                    if(s.reproduzirMusica(i.getNome())) {
                        cont++;
                        break;
                    }
                }
            }

            if(cont == 0){
                JOptionPane.showMessageDialog(null, "Não foi possível reproduzir a música",
                        "Player", JOptionPane.ERROR_MESSAGE);
            }
        });

        okButton.addActionListener(e -> dispose());

    }
}
