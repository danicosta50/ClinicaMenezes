package DAO;

import DAO.JPAUtil;
import classes.Orcamento;
import classes.OrcamentoItem;
import classes.consulta;
import classes.paciente;
 import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
  
  public class OrcamentoItemDAO {
      
      public void cadastrar(OrcamentoItem o){
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
 
public List<OrcamentoItem> listar() {  
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String textoquery = " SELECT o FROM OrcamentoItem o "
             
               ;
        Query consultaSql = em.createQuery(textoquery);     
        
      

        List<OrcamentoItem> orcamentoLista = consultaSql.getResultList();
        return orcamentoLista;
    } catch(Exception e) {
        em.getTransaction().rollback();
        JOptionPane.showMessageDialog(null, "Erro ao listar itens de orcamento: " + e);
        throw e;
    } finally {
        JPAUtil.closeEntityManager();
    }
}

     public OrcamentoItem listarporId(Integer id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
         String textquery = "SELECT OI FROM OrcamentoItem OI WHERE  OI.id = :id";
          Query consulta = em.createQuery(textquery, OrcamentoItem.class);
           consulta.setParameter("id",id);
          
          return (OrcamentoItem) consulta.getSingleResult();
      }
      catch(Exception e){
             
               JOptionPane.showMessageDialog(null, "erro ao listar pacientes" + e);
              throw e;
                
          }
      finally{
          JPAUtil.closeEntityManager();
      }
    } 
       
         public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        OrcamentoItem o  = em.find(OrcamentoItem.class, id);
          if(o!= null){
              em.getTransaction().begin();
              em.remove(o);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
           JOptionPane.showMessageDialog(null, "erro ao excluir" + e);
          throw e;
      }
      finally{
          JPAUtil.closeEntityManager();
      }
    }  
         
         
   public void atualizar(OrcamentoItem orcamentoItem){
      EntityManager em = JPAUtil.getEntityManager();
      try{
        OrcamentoItem o  = em.find(OrcamentoItem.class, orcamentoItem.getId());

          if(o != null){
              em.getTransaction().begin();
             o.setDescricao(orcamentoItem.getDescricao());
             o.setItem(orcamentoItem.getItem());
             o.setValor(orcamentoItem.getValor());
             
            
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
