package apresentacao;

import dados.Usuario;
import negocio.SisAplicativo;

import javax.swing.*;

public class ExcluirU extends JFrame{

    private JButton excluirButton;
    private JPanel ExcluirU;
    private JButton voltarButton;
    private JComboBox usuariosComboBox;

    public ExcluirU(SisAplicativo s) {

        setContentPane(ExcluirU);
        setTitle("Excluir Usuário");
        setSize(500, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        for(Usuario i: s.getUsuarios()) {
            usuariosComboBox.addItem(i);
        }

        excluirButton.addActionListener(e -> {

            for(Usuario i: s.getUsuarios()) {
                if (usuariosComboBox.equals(i)) {
                    s.excluirUsuario(i);
                    JOptionPane.showMessageDialog(null, "Usuário removido",
                            "Excluir usuário", JOptionPane.INFORMATION_MESSAGE);
                    new MenuAplicativo(s);
                    dispose();
                }
            }

            JOptionPane.showMessageDialog(null, "Não foi possível excluir usuário",
                    "Excluir usuário", JOptionPane.ERROR_MESSAGE);
        });

        voltarButton.addActionListener(e -> {
            new MenuAplicativo(s);
            dispose();
        });
    }
}
