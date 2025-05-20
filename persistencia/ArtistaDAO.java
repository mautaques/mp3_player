package persistencia;

import dados.Artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistaDAO {

    private PreparedStatement selectArtista;
    private PreparedStatement insertArtista;
    private static ArtistaDAO instance = null;

    public static ArtistaDAO getInstance(){
        if (instance == null)
            instance = new ArtistaDAO();
        return instance;
    }

    private ArtistaDAO(){
        Connection conn = Conexao.getConexao();
        try{
            selectArtista = conn.prepareStatement("select * from Artista where nome = ?");
            insertArtista = conn.prepareStatement("insert into Artista "
            + "(nome) values (?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Artista load(int code){
        ResultSet rs;
        Artista a = null;
        try{
            selectArtista.setInt(1, code);
            rs = selectArtista.executeQuery();
            if(rs.next()){
                a = new Artista();
                a.setNome(rs.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return a;
    }

}
