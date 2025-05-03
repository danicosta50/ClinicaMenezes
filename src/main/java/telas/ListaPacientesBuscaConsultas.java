/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DAO.consultaDAO;
import classes.consulta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author F2258573
 */
public class ListaPacientesBuscaConsultas extends javax.swing.JPanel {


    public ListaPacientesBuscaConsultas() {
        
        initComponents();
        
          String[] colunas = { "Paciente", "Data da consulta"};
        DefaultTableModel tabeloModelo = new DefaultTableModel(colunas, 0);
        consultaDAO consultaDAO = new consultaDAO();
         List<consulta> lista= consultaDAO.listar();
       
                 for(int i = 0; i < lista.size(); i++) {
      // Extraímos os dados
     consulta consulta= lista.get(i);
    Date dataConsulta = consulta.getDataConsulta(); 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
    String dataConsultaString = dateFormat.format(dataConsulta);
      String[] linha = { 
         consulta.getNomePaciente(), dataConsultaString
      };
      tabeloModelo.addRow(linha);
        
      TabelaListaConsultas.setModel(tabeloModelo);
  
    }
    }

  
private void buscarConsultas() { 
    String nomePaciente = TxtNome.getText(); 
    String cpfPaciente = TxtCpf.getText();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date dataInicial = null;
    Date dataFinal = null;

    try { 
        // Check if TxtData1 and TxtData2 are empty
        if (TxtData1.getText().isEmpty()) {
            // Set dataInicial to the 1st of the month
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, 1);
            dataInicial = cal.getTime();
             String dataInicialString = dateFormat.format(dataInicial);
             TxtData1.setText(dataInicialString);
        } else {
            dataInicial = dateFormat.parse(TxtData1.getText());
        }

        if (TxtData2.getText().isEmpty()) {
            // Set dataFinal to the 30th of the month
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_MONTH, 30);
            dataFinal = cal.getTime();
             String dataFinalString = dateFormat.format(dataFinal); 
             TxtData2.setText(dataFinalString);
        } else {
            dataFinal = dateFormat.parse(TxtData2.getText());
        }

        System.out.println("Data Inicial convertida: " + dataInicial); 
        System.out.println("Data Final convertida: " + dataFinal); 
    } catch (ParseException e) {
        e.printStackTrace();
    }
      carregarTabela(dataInicial, dataFinal, nomePaciente, cpfPaciente); 
}

 

private void carregarTabela(Date dataInicio, Date dataFim, String nomePaciente, String cpfPaciente) { 
    String[] colunas = { "Paciente", "Data da consulta" };
    DefaultTableModel tabelaModelo = new DefaultTableModel(colunas, 0); 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      consultaDAO consultaDAO = new consultaDAO();
         List<consulta> lista= consultaDAO.listar();
    for (consulta consulta : lista) {
        Date dataConsulta = consulta.getDataConsulta(); 
        String dataConsultaString = dateFormat.format(dataConsulta);

        boolean dentroDoIntervalo = (dataConsulta.after(dataInicio) || dataConsulta.equals(dataInicio)) &&
                                    (dataConsulta.before(dataFim) || dataConsulta.equals(dataFim));
        
        boolean nomeCorresponde = nomePaciente.isEmpty() || consulta.getNomePaciente().equalsIgnoreCase(nomePaciente);
        
        boolean cpfCorresponde = cpfPaciente.isEmpty() || consulta.getCpf().equals(cpfPaciente);
        
        if (dentroDoIntervalo && nomeCorresponde && cpfCorresponde) {
            String[] linha = {consulta.getNomePaciente(), dataConsultaString};
            tabelaModelo.addRow(linha);
        }
    } 
    TabelaListaConsultas.setModel(tabelaModelo); 
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        TxtCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtData1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtData2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TabelaModelo = new javax.swing.JScrollPane();
        TabelaListaConsultas = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jTextField1.setBackground(new java.awt.Color(153, 153, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setText("Consultas");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do paciente");

        TxtNome.setBackground(new java.awt.Color(255, 255, 255));
        TxtNome.setForeground(new java.awt.Color(0, 0, 0));
        TxtNome.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TxtNomeCaretUpdate(evt);
            }
        });

        TxtCpf.setBackground(new java.awt.Color(255, 255, 255));
        TxtCpf.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CPF");

        TxtData1.setBackground(new java.awt.Color(255, 255, 255));
        TxtData1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data inicial");

        TxtData2.setBackground(new java.awt.Color(255, 255, 255));
        TxtData2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Data final");

        jButton3.setBackground(new java.awt.Color(153, 153, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Detalhe");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TabelaListaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelaModelo.setViewportView(TabelaListaConsultas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TabelaModelo)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(TxtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(TabelaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarConsultas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = TabelaListaConsultas.getSelectedRow(); // Obtém a linha selecionada na tabela.
        if (selectedRow != -1) { // Verifica se uma linha foi selecionada.
          consultaDAO consultaDAO = new consultaDAO();
          
            consulta consultaSelecionada = consultaDAO.listar().get(selectedRow);

            Detalhe_Consulta detalheTela = new Detalhe_Consulta(consultaSelecionada);
            detalheTela.setVisible(true);
           dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta na tabela ."); // Exibe mensagem de erro.
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void TxtNomeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TxtNomeCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomeCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaListaConsultas;
    private javax.swing.JScrollPane TabelaModelo;
    private javax.swing.JTextField TxtCpf;
    private javax.swing.JTextField TxtData1;
    private javax.swing.JTextField TxtData2;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
