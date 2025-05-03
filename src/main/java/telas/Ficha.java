/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import DAO.OrcamentoItemDAO;
import DAO.consultaDAO;
import DAO.orcamentoDAO;
import DAO.pacienteDAO;
import classes.Orcamento;
import classes.OrcamentoItem;
import classes.consulta;
import classes.paciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
  import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author F2258573
 */
public class Ficha extends javax.swing.JFrame {

    paciente paciente;
    
  public Ficha(paciente paciente) {
    initComponents();
   
    this.paciente = paciente;
    TxtHistMed.setText(paciente.getHistorico_medico());

        String[] colunas = { "Data da consulta", "Observação", "Valor", "Realizada?" };
        DefaultTableModel tabeloModelo = new DefaultTableModel(colunas, 0);
        consultaDAO consultaDAO = new consultaDAO();
        List<consulta> lista= consultaDAO.listar(paciente.getNome());
        String dataConsultaString ;
        String obs ;
        Boolean consultaRealizada;
        Boolean pago ;
         String pagamento ;
        String consultaRealizadaString ;
        String valor ;
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
       for(int i = 0; i < lista.size(); i++) {
      // Extraímos os dados
     consulta consulta= lista.get(i);
        Date dataConsulta = consulta.getDataConsulta(); 
        dataConsultaString = dateFormat.format(dataConsulta);
        obs = consulta.getReceitaObservacoes();
         consultaRealizada = consulta.isConsultaRealizada();
  
    
        consultaRealizadaString = consultaRealizada ? "Sim" : "Não";
        valor = consulta.getValor();
        
            String[] linha = { 
            dataConsultaString, obs, valor, consultaRealizadaString
        };

      tabeloModelo.addRow(linha);      
      };
  

        
      TabelaListaConsultas.setModel(tabeloModelo);
      preenchertabelaorcamento();
  
    }


public void atualizarTabelaOrcamento() {
    preenchertabelaorcamento(); // Chama a função de atualização
}


public class OrcamentoRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtém o valor da coluna "Pago?" da linha atual
        String statusPagamento = table.getValueAt(row, 4).toString();
        
        if ("Não".equals(statusPagamento) && !isSelected) {
            comp.setBackground(Color.RED); // Define a linha como vermelha se não estiver selecionada
        } else if (isSelected) {
            comp.setBackground(table.getSelectionBackground()); // Mantém a cor de seleção padrão
        } else {
            comp.setBackground(Color.WHITE); // Mantém o fundo padrão para os demais
        }

        return comp;
    }
}



     public void preenchertabelaorcamento(){
          String[] colunas = { "Id", "Item","Descrição", "Valor","Pago?"};
        DefaultTableModel tabeloModelo = new DefaultTableModel(colunas, 0);
        tabelaorcamento.setDefaultRenderer(Object.class, new OrcamentoRenderer());
tabelaorcamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); // Garante que apenas uma linha seja selecionada


       orcamentoDAO orcamentoDAO = new orcamentoDAO();
       OrcamentoItemDAO OrcamentoItemDAO  = new OrcamentoItemDAO();
       List<OrcamentoItem> ListaItens = OrcamentoItemDAO.listar();
        List<Orcamento> lista= orcamentoDAO.listar(paciente.getId());
                 for(int i = 0; i < lista.size(); i++) {
                    // Extraímos os dados
                    Orcamento orcamento = lista.get(i);
                    Integer Id_item = orcamento.getId_item();
                    boolean pago = orcamento.isPago();
                    OrcamentoItem OrcamentoItem = OrcamentoItemDAO.listarporId(Id_item);
                  //  OrcamentoItem OrcamentoItem = ListaItens.get(orcamento.getId_item()-1);
                   //vai ter que pegar cada orcamento, e pelo id do item deste orcamento, pegar descricao, nome, etc deste item
                    String statusPagamento = pago ? "Sim" : "Não";
                    String[] linha = { 
                       String.valueOf(orcamento.getId()) ,OrcamentoItem.getItem(),OrcamentoItem.getDescricao(),Integer.toString(OrcamentoItem.getValor()),statusPagamento
                    };
                    tabeloModelo.addRow(linha);

                    tabelaorcamento.setModel(tabeloModelo);

                     tabelaorcamento.repaint();
    }
        
     }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtHistMed = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaListaConsultas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaorcamento = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ficha");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Histórico médico:");

        TxtHistMed.setBackground(new java.awt.Color(255, 255, 255));
        TxtHistMed.setColumns(20);
        TxtHistMed.setForeground(new java.awt.Color(0, 0, 0));
        TxtHistMed.setRows(5);
        jScrollPane1.setViewportView(TxtHistMed);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Histórico consultas:");

        TabelaListaConsultas.setBackground(new java.awt.Color(255, 255, 255));
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
        jScrollPane2.setViewportView(TabelaListaConsultas);

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Detalhe Consulta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Orçamentos:");

        tabelaorcamento.setBackground(new java.awt.Color(255, 255, 255));
        tabelaorcamento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelaorcamento);

        jButton3.setBackground(new java.awt.Color(153, 153, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Editar orçamento selecionado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        paciente.setHistorico_medico(TxtHistMed.getText());
        pacienteDAO pacienteDAO = new pacienteDAO();
        pacienteDAO.atualizar(paciente);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int selectedRow = tabelaorcamento.getSelectedRow(); // Obtém a linha selecionada na tabela.
        if (selectedRow != -1) { // Verifica se uma linha foi selecionada.
         int idSelecionado = Integer.parseInt(tabelaorcamento.getValueAt(selectedRow, 0).toString()); 
           orcamentoDAO orcamentODAO = new  orcamentoDAO();

            Orcamento OrcamentoSelecionado = orcamentODAO.listarporId(idSelecionado);

           OrcamentoTelaEditar OrcamentoTelaEditar = new OrcamentoTelaEditar(OrcamentoSelecionado, this);


            
            OrcamentoTelaEditar.setVisible(true);
         

        } else {
            JOptionPane.showMessageDialog(this, "Selecione um orçamento ."); // Exibe mensagem de erro.
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaListaConsultas;
    private javax.swing.JTextArea TxtHistMed;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaorcamento;
    // End of variables declaration//GEN-END:variables
}
