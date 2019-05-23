package java.e.conexao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kelly Ortiz F
 */
public class Carro {
private long id;
    private String modelo;
    private String marca;
    private String Ano;
    private String categoria;
    
    
    public Carro(long id, String mod, String ano, String m, String categ) {
      this.id = id;
        modelo = mod;
        marca = m;
        Ano = ano;
        categoria = categ;
    }

   
    public long getId() { return id; }
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public String getAno(){ return Ano; }
    public String getCategoria() { return categoria; }
    
    
    public void setId(long id) { this.id = id; }
    public void setModelo(String mod) { modelo = mod; }
    public void setMarca(String m) { marca = m; }
    public void setAno(String ano) { Ano = ano; }
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
