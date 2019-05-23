package java.e.conexao;

import java.e.conexao.Carro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 class CarrosDao {
    private PreparedStatement stmtC;
    private PreparedStatement stmtR;
    private PreparedStatement stmtU;
    private PreparedStatement stmtD;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public CarrosDao(ConexaoJavaDb conexao) {
        try {
            Connection conn = conexao.getConexao();        
            String sqlC =  "INSERT INTO carros(modelo,marca,ano,categoria) VALUES(?,?,?,?)";
            String sqlR =  "SELECT * FROM carros";
            String sqlR1 = "SELECT * FROM carros where marca=? ";
            String sqlR2 = "SELECT * FROM carros where categoria=? ";
            String sqlU =  "UPDATE carros SET modelo=?, marca=?, ano =?, categoria=? WHERE id=?";
            String sqlD =  "DELETE FROM carros WHERE id=?";
            
            this.stmtC = conn.prepareStatement(sqlC,Statement.RETURN_GENERATED_KEYS);
            this.stmtR = conn.prepareStatement(sqlR);
            this.stmtR = conn.prepareStatement(sqlR1);
            this.stmtR = conn.prepareStatement(sqlR2);
            this.stmtU = conn.prepareStatement(sqlU);
            this.stmtD = conn.prepareStatement(sqlD);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Carro> lerTodos() {
        try{
            ResultSet rs = this.stmtR.executeQuery();
            List<Carro> carros = new ArrayList<>();
            
            while(rs.next()) {
                Carro aux = new Carro();
                aux.setId(rs.getInt("id"));
                aux.setModelo(rs.getString("modelo"));
                aux.setMarca(rs.getString("marca"));
                aux.setAno(rs.getString("ano"));
                aux.setCategoria(rs.getString("categoria"));
                carros.add(aux);
            }
            return carros;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Carro criar(Carro c) {
        try{
            this.stmtC.setString(1, c.getModelo());
            this.stmtC.setString(2, c.getMarca());
            this.stmtC.setString(3, c.getAno());
            this.stmtC.setString(4, c.getCategoria());
            
            this.stmtC.executeUpdate();
            ResultSet rs = this.stmtC.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                c.setId(id);
                return c;
            } 
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean atualizar(Carro c) {
        try{
            this.stmtU.setString(1, c.getModelo());
            this.stmtU.setString(2, c.getMarca());
            this.stmtU.setString(3, c.getAno());
            this.stmtU.setString(4, c.getCategoria());
            this.stmtU.setLong(5, c.getId());
            
            return this.stmtU.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean apagar(long id) {
        try{
            this.stmtD.setLong(1, id);
            return this.stmtD.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    long create(Carro c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Carro> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    long create(Carro c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
