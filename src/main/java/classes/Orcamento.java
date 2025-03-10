/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Orcamento {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private int id_item;

    private int paciente_id;
 


    

public Orcamento(paciente paciente){
 
    
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

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }


   

    
}
