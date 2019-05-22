import java.sql.*;
import java.util.*;

public class CarrosDao {
    private final static String sqlCreateTable = "create table carros"
                                                + "(idCarros bigint not null"
                                                + "generated always as identity (start with 1, increment by 1),"
                                                + "modelo varchar(30) not null,"
                                                + "marca varchar(30) not null,"
                                                + "ano varchar(4) not null,"
                                                + "categoria varchar(30) not null,"
                                                + "primary key (idCarros));";
    
    	private final String sqlC = "INSERT INTO carros(modelo,marca,ano,categoria) VALUES(?,?,?,?)";
	private final String sqlR = "SELECT * FROM carros";
	private final String sqlU = "UPDATE carros SET modelo=?,marca=?,ano=?,categoria=?WHERE id=?";
	private final String sqlD = "DELETE FROM professores WHERE id=?";	
	private final String sqlRById = "DELETE FROM carros WHERE id=?";
	private PreparedStatement stmC;
	private PreparedStatement stmR;
	private PreparedStatement stmU;
	private PreparedStatement stmD;
	private PreparedStatement stmRById;
	public CarrosDao(ConexaoJavaDb conexao) throws DaoException, ConexaoException {
		try {
			Connection con = conexao.getConnection();
            try {
                Statement stm = con.createStatement();
                stm.execute(sqlCreateTable);
                System.out.println("Tabela criada com sucesso!");
            } catch( SQLException ex ) {
                System.out.println("Tabela já existe!");
            }           
			stmC = con.prepareStatement(sqlC, Statement.RETURN_GENERATED_KEYS);
			stmR = con.prepareStatement(sqlR);
			stmU = con.prepareStatement(sqlU);
			stmD = con.prepareStatement(sqlD);
			stmRById = con.prepareStatement(sqlRById);
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao preparar statement: " + ex.getMessage());
		}
	}
    
	public long create(Carro c) throws DaoException {
		long id = 0;
		try {
                    stmC.setString(1,c.getModelo());
                    stmC.setString(2, c.getMarca());
                    stmC.setString(3, c.getAno());
                    stmC.setString(4, c.getCategoria());
                    stmC.executeUpdate();
			int r = stmC.executeUpdate();
			ResultSet rs = stmC.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao criar registro: " + ex.getMessage());
		}
		return id;
	}
	public List<Carro> read() throws DaoException {
		List<Carro> carros = new ArrayList<>();
		try {
			ResultSet rs = stmR.executeQuery();
			while(rs.next()) {
				long id = rs.getLong("id");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
                                String ano = rs.getString("Ano");
                                String categoria = rs.getNString("categoria");
				Carro c = new Carro(id, modelo,marca,ano,categoria);
				carros.add(c);
			}
			rs.close();
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao ler registros: " + ex.getMessage());
		}
		return carros;
	}
	public void update(Carro c) throws DaoException {
		try {
                    stmU.setString(1,c.getModelo());
                    stmU.setString(2, c.getMarca());
                    stmU.setString(3, c.getAno());
                    stmU.setString(4, c.getCategoria());
                    stmU.setLong(5, c.getId());
			int r = stmU.executeUpdate();
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao atualizar registro: " + ex.getMessage());
		}
	}
	public void delete(long id) throws DaoException {
		try {
			stmD.setLong(1, id);
			int r = stmD.executeUpdate();
		} catch(SQLException ex) {
			throw new DaoException("Falha ao apagar registro: " + ex.getMessage());
		}
	}
	public void close() throws DaoException {
		try {
			stmC.close();
			stmR.close();
			stmU.close();
			stmD.close();
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao fechar DAO: " + ex.getMessage());
		}
	}	 

	public Carro readById(long id) throws DaoException {
		Carro c = null;

		try {
			stmRById.setLong(1, id);
			ResultSet rs = stmRById.executeQuery();
			if (rs.next()) {
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
                                String ano = rs.getString("ano");
                                String categoria = rs.getString("categoria");
				c = new Carro(id,modelo,marca,ano,categoria);
			}
		} catch(SQLException ex) {
            ex.printStackTrace();
			throw new DaoException("Falha ao buscar pelo id: " + ex.getMessage());
		}
		return c;
	}

}
