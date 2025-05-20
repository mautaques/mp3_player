package persistencia;

import dados.Musica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicaDAO {

    private PreparedStatement selectMusica;
    private PreparedStatement insertMusica;
    private static MusicaDAO instance = null;

    public static MusicaDAO getInstance(){
        if (instance == null)
            instance = new MusicaDAO();
        return instance;
    }

    private MusicaDAO(){
        Connection conn = Conexao.getConexao();
        try{
            selectMusica = conn.prepareStatement("select * from Musica where nome = ?");
            insertMusica = conn.prepareStatement("insert into Musica "
                    + "(nome, arquivo) values (?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Musica load(int code){
        ResultSet rs;
        Musica m = null;
        try{
            selectMusica.setInt(1, code);
            rs = selectMusica.executeQuery();
            if(rs.next()){
                m = new Musica();
                m.setNome(rs.getString("nome"));
                m.setArquivo(rs.getString("arquivo"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return m;
    }

}
