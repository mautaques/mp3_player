package apresentacao;

import negocio.SisAplicativo;

import javax.swing.*;

public class AddM extends JFrame{
    private JTextField nomeField;
    private JTextField arquivoField;
    private JTextField artistaField;
    private JButton adicionarButton;
    private JPanel AddM;
    private JButton voltarButton;

    public AddM(SisAplicativo s) {

        setContentPane(AddM);
        setTitle("Adicionar Música");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        adicionarButton.addActionListener(e -> {

            String nome = nomeField.getText();

            String artista = artistaField.getText();

            String arquivo = arquivoField.getText();

            if (nome.isEmpty() || artista.isEmpty() || arquivo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome e/ou arquivo estão vazios",
                        "Adicionar Música", JOptionPane.ERROR_MESSAGE);
            } else {

                if (s.adicionarMusica(nome,artista,arquivo)) {
                    JOptionPane.showMessageDialog(null, "Música adicionada",
                            "Adicionar Música", JOptionPane.INFORMATION_MESSAGE);
                    new Musicas(s);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Música já existe",
                            "Adicionar Música", JOptionPane.ERROR_MESSAGE);
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
