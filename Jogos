package projeto_CRUD;

import java.sql.Date;

public class Jogos{
    private long id;
    private String Nome_timeA;
    private String Nome_timeB;
    private long gol_timeA;
    private long gol_timeB;
   
    
    
    public Jogos(long id, String Nome_timeA,String Nome_timeB,long gol_timeA, long gol_timeB ) {
      this.id = id;
      this.gol_timeA = gol_timeA;
      this.gol_timeB = gol_timeB;
 
    }

    Jogos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
      public long getId() { return id; }
      public long getGoltimeAtimeA() { return gol_timeA; }
      public long getGoltimeAtimeB() { return gol_timeB; }
      public String getNometimeA() { return Nome_timeA; }
      public String getNometimeB() { return Nome_timeB; }


    public void setId(long id) { this.id = id; }
    public void setGoltimeAtimeA(long id) { this.gol_timeA = gol_timeA; }
    public void setGoltimeAtimeB(long id) { this.gol_timeB = gol_timeB; }
    public void setNome_timeA(String Nome_timeA) { Nome_timeA = Nome_timeA; }
    public void setNome_timeB(String Nome_timeB) { Nome_timeB = Nome_timeB; }
    
 }
    
    @Override
    public String toString() {
        return "Partidas: " 
                + this.Nome_timeA+ " - " 
                + this.Nome_timeB + " - "
                + this.GoltimeAtimeA+ " - "
                + this.GoltimeAtimeB + "(" 
                + this.id + ")";
    }

}
