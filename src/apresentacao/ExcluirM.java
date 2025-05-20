package apresentacao;

import dados.Musica;
import negocio.SisAplicativo;

import javax.swing.*;

public class ExcluirM extends JFrame{

    private JButton voltarButton;
    private JButton excluirButton;
    private JPanel ExcluirM;
    private JComboBox musicasComboBox;

    public ExcluirM(SisAplicativo s) {

        setContentPane(ExcluirM);
        setTitle("Excluir Música");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        for(Musica i: s.getMusicas()) {
            musicasComboBox.addItem(i.getNome());
        }

        excluirButton.addActionListener(e -> {

            int cont = 0;

            for(int i = 0; i < s.getMusicas().size(); i++){
                if(s.getMusicas().get(i).getNome().equals(musicasComboBox.getSelectedItem())){
                    if(s.excluirMusica(s.getMusicas().get(i).getNome())) {
                        JOptionPane.showMessageDialog(null, "Música Excluída",
                                "Excluir Música", JOptionPane.INFORMATION_MESSAGE);
                        cont++;
                        new Musicas(s);
                        dispose();
                    }
                }
            }

            if(cont == 0) {
                JOptionPane.showMessageDialog(null, "não foi possível exlcuir a música",
                        "Excluir Música", JOptionPane.ERROR_MESSAGE);
                new Musicas(s);
                dispose();
            }
        });

        voltarButton.addActionListener(e -> {
            new Musicas(s);
            dispose();
        });
    }
}
