package persistencia;

import dados.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistDAO {

    private PreparedStatement selectPlaylist;
    private PreparedStatement insertPlaylist;
    private static PlaylistDAO instance = null;

    public static PlaylistDAO getInstance() {
        if (instance == null)
            instance = new PlaylistDAO();
        return instance;
    }

    private PlaylistDAO() {
        Connection conn = Conexao.getConexao();
        try {
            selectPlaylist = conn.prepareStatement("select * from Playlist where nome = ?");
            insertPlaylist = conn.prepareStatement("insert into Playlist "
                    + "(nome) values (?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Playlist load(int code) {
        ResultSet rs;
        Playlist p = null;
        try {
            selectPlaylist.setInt(1, code);
            rs = selectPlaylist.executeQuery();
            if (rs.next()) {
                p = new Playlist();
                p.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
