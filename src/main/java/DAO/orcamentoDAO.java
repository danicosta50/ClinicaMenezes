package DAO;

import DAO.JPAUtil;
import classes.Orcamento;
import classes.consulta;
import classes.paciente;
 import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
  
  public class orcamentoDAO {
      
      public void cadastrar(Orcamento o){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(o);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              JOptionPane.showMessageDialog(null, "erro ao cadastrar orcamento" + e);
              throw e;
          }
      
          finally{
              JPAUtil.closeEntityManager();
          }
      }
 
public List<Orcamento> listar(int paciente_id) {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = " SELECT o FROM Orcamento o "
                + "WHERE ( O.id_paciente = :paciente_id ) "
               ;
        Query consultaSql = em.createQuery(textoquery);     
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
       
        consultaSql.setParameter("paciente_id", paciente_id );       

        List<Orcamento> orcamentoLista = consultaSql.getResultList();
        return orcamentoLista;
    } catch(Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e);
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

    
       
         public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        Orcamento o  = em.find(Orcamento.class, id);
          if(o!= null){
              em.getTransaction().begin();
              em.remove(o);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
           JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    }  
         
         
   public void atualizar(Orcamento orcamento){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        Orcamento o  = em.find(Orcamento.class, orcamento.getId());

          if(o != null){
              em.getTransaction().begin();
             o.setDescricao(orcamento.getDescricao());
             o.setPaciente_id(orcamento.getPaciente_id());
             o.setValor(orcamento.getValor());
             
            
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "erro ao cadastrar consulta" + e);
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    } 
     
     
    
}
