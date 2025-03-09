/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author F2258573
 */
public class Orcamento {
    private int id;
   private int valor;
    private String Descricao;
    private int paciente_id;
 


    

public Orcamento(paciente paciente){
    this.valor = 0;
    this.Descricao="";
    this.paciente_id = paciente.getId();
    
   
}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
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
    
}
