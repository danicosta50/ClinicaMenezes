/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DAO.consultaDAO;
import classes.consulta;

/**
 *
 * @author F2258573
 */
public class Detalhe_Consulta extends javax.swing.JFrame {

  Lista_Consultas Tela_inicial;
  consulta consulta;
    public Detalhe_Consulta() {
        initComponents();
    }

 public Detalhe_Consulta(Lista_Consultas Tela_inicial, consulta consulta) {
    initComponents();
    this.Tela_inicial = Tela_inicial;
    this.consulta = consulta;

    TxtReceitaObs.setText(consulta.getReceitaObservacoes());

    check_consulta_realizada.setSelected(consulta.isConsultaRealizada());
    check_consulta_realizada.setEnabled(true);

  
}

public Detalhe_Consulta(consulta consulta) {
    initComponents();
    this.consulta = consulta;

    TxtReceitaObs.setText(consulta.getReceitaObservacoes());

    check_consulta_realizada.setSelected(consulta.isConsultaRealizada());
    check_consulta_realizada.setEnabled(true);
  
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        check_consulta_realizada = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtReceitaObs = new javax.swing.JTextPane();
        BtnSalvar = new javax.swing.JButton();
        BtnPacientes8 = new javax.swing.JButton();
        BtnPacientes9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Detalhes da consulta");

        check_consulta_realizada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        check_consulta_realizada.setForeground(new java.awt.Color(0, 0, 0));
        check_consulta_realizada.setText("Consulta realizada");
        check_consulta_realizada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                check_consulta_realizadaFocusGained(evt);
            }
        });
        check_consulta_realizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_consulta_realizadaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Receita e observações:");

        TxtReceitaObs.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TxtReceitaObs);

        BtnSalvar.setBackground(new java.awt.Color(153, 153, 0));
        BtnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnSalvar.setForeground(new java.awt.Color(0, 0, 0));
        BtnSalvar.setText("Salvar");
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });

        BtnPacientes8.setBackground(new java.awt.Color(153, 153, 0));
        BtnPacientes8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPacientes8.setForeground(new java.awt.Color(0, 0, 0));
        BtnPacientes8.setText("Sair");
        BtnPacientes8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPacientes8ActionPerformed(evt);
            }
        });

        BtnPacientes9.setBackground(new java.awt.Color(153, 153, 0));
        BtnPacientes9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPacientes9.setForeground(new java.awt.Color(0, 0, 0));
        BtnPacientes9.setText("Excluir");
        BtnPacientes9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPacientes9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_consulta_realizada, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnPacientes9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(BtnPacientes8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(check_consulta_realizada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPacientes8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPacientes9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check_consulta_realizadaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_check_consulta_realizadaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_check_consulta_realizadaFocusGained

    private void check_consulta_realizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_consulta_realizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_consulta_realizadaActionPerformed

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed
        consulta.setReceitaObservacoes(TxtReceitaObs.getText());  
        consulta.setConsultaRealizada(check_consulta_realizada.isSelected());
      
        consulta.setConsultaRealizada(check_consulta_realizada.isSelected());
        consultaDAO consultaDAO = new consultaDAO();
        consultaDAO.atualizar(consulta);
        dispose();
    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void BtnPacientes8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPacientes8ActionPerformed
        dispose();
    }//GEN-LAST:event_BtnPacientes8ActionPerformed

    private void BtnPacientes9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPacientes9ActionPerformed
        consultaDAO consultaDAO = new consultaDAO();
        consultaDAO.excluir(consulta.getId());
        dispose();
    }//GEN-LAST:event_BtnPacientes9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Detalhe_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalhe_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalhe_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalhe_Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalhe_Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPacientes8;
    private javax.swing.JButton BtnPacientes9;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JTextPane TxtReceitaObs;
    private javax.swing.JCheckBox check_consulta_realizada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
