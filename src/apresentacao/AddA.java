package apresentacao;

import dados.Musica;
import negocio.SisAplicativo;

import javax.swing.*;

public class AddA extends JFrame{

    private JButton voltarButton;
    private JTextField nomeArtistaField;
    private JButton adicionarButton;
    private JPanel AddA;
    private JComboBox musicasComboBox;

    public AddA(SisAplicativo s) {

        setContentPane(AddA);
        setTitle("Adicionar Artista");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        for(Musica i: s.getMusicas()) {
            musicasComboBox.addItem(i.getNome());
        }

        adicionarButton.addActionListener(e -> {

            int cont = 0;

            String nomeA = nomeArtistaField.getText();

            if (nomeA.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome da música e/ou nome do artista estão vazios",
                        "Adicionar Artista", JOptionPane.ERROR_MESSAGE);
            } else {

                for(Musica i: s.getMusicas()){
                    if(i.getNome().equals(musicasComboBox.getSelectedItem())){
                        if(s.adicionarArtista(i.getNome(),nomeArtistaField.getText())) {
                            JOptionPane.showMessageDialog(null, "Artista Adicionado",
                                    "Adicionar Artista", JOptionPane.INFORMATION_MESSAGE);
                            cont++;
                            new Musicas(s);
                            dispose();
                        }
                    }
                }

                if(cont == 0){
                    JOptionPane.showMessageDialog(null, "não foi possível adicionar artista",
                            "Adicionar Artista", JOptionPane.ERROR_MESSAGE);
                    new Musicas(s);
                    dispose();
                }
            }
        });

        voltarButton.addActionListener(e -> {
            new Musicas(s);
            dispose();
        });
    }
}
