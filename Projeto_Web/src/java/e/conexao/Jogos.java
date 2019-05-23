package projeto_CRUD;

import java.sql.Date;

public class Jogos{
    private long id;
    private String modelo;
    private String marca;
    private Date Ano;
    private String categoria;
    
    
    public Jogos(long id, String mod, Date ano, String m, String categ) {
      this.id = id;
        modelo = mod;
        marca = m;
        Ano = ano;
        categoria = categ;
    }

    Jogos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    public long getId() { return id; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public Date getAno(){ return Ano; }
    public String getCategoria() { return categoria; }
    
    
    public void setId(long id) { this.id = id; }
    public void setModelo(String mod) { modelo = mod; }
    public void setMarca(String m) { marca = m; }
    public void setAno(Date ano) { Ano = ano; }
    public void setCategoria(String categ) { categoria = categ; }
    
    @Override
    public String toString() {
        return "Veiculo: " 
                + this.modelo+ " - " 
                + this.marca + " - "
                + this.Ano + " - "
                + this.categoria + "(" 
                + this.id + ")";
    }

}
