package classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author F2258573
 */
@Entity
public class OrcamentoItem {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private int valor;
    private String Descricao;
    private String item;
    
 


    

public OrcamentoItem(){
    this.valor = 0;
    this.Descricao="";
    this.item = "";
    
    
   
}

    public OrcamentoItem(int valor, String Descricao, String item) {
        this.valor = valor;
        this.Descricao = Descricao;
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

  

   

    public String getDescricao() {
        return Descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

   

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}
