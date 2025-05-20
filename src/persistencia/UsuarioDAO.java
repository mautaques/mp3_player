package persistencia;

import dados.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private PreparedStatement selectUsuario;
    private PreparedStatement insertUsuario;
    private static UsuarioDAO instance = null;

    public static UsuarioDAO getInstance() {
        if (instance == null)
            instance = new UsuarioDAO();
        return instance;
    }

    private UsuarioDAO() {
        Connection conn = Conexao.getConexao();
        try {
            selectUsuario = conn.prepareStatement("select * from Usuario where nome = ?");
            insertUsuario = conn.prepareStatement("insert into Usuario "
                    + "(nome, arquivo) values (?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario load(int code) {
        ResultSet rs;
        Usuario u = null;
        try {
            selectUsuario.setInt(1, code);
            rs = selectUsuario.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setUsername(rs.getString("username"));
                u.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
