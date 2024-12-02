package view;

import controller.EventoController;
import controller.SemanaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Evento;
import model.Participante;
import model.Responsavel;
import model.Semana;
import util.ValidacoesUtil;

public class FormularioSemanaEvento extends javax.swing.JDialog {
    private EventoController eventoController;
    private Evento evento;
    private boolean isAlterar = false;
    
    private SemanaController semanaController;
    private Semana semana;
    
    private Participante participante;
    
    private static SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
    
    public FormularioSemanaEvento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        eventoController = new EventoController();
        semanaController = new SemanaController();
    }
    
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tableResponsavel.getModel();
        
        model.setRowCount(0);
        
        for(Responsavel responsavel : evento.getResponsaveis()) {
            model.addRow(new Object[]{responsavel.getParticipante().getNome(), (responsavel.getParticipante().getCurso().getNome() + " - " + responsavel.getParticipante().getCurso().getSigla())});
        }
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
        evento = new Evento();
    }
    
    public void setEventoIndex(int index) {
        this.evento = semana.getEventos().get(index);
        this.isAlterar = true;
        
        inputTitulo.setText(evento.getTitulo());
        inputCarga.setText("" + evento.getCargaHoraria());
        inputVaga.setText("" + evento.getNumeroVaga());
        inputData.setDate(evento.getDataEvento());
        inputHora.setText(sdfh.format(evento.getDataEvento()));
        
        btnSalvar.setText("Alterar");
        
        atualizarTabela();
    }
    
    public static Date combinarDataHora(Calendar dataCalendar, String horaTexto) {
        SimpleDateFormat horaFormato = new SimpleDateFormat("HH:mm");
        Date hora;
        
        Calendar horaCalendar = Calendar.getInstance();
        
        try {
            hora = horaFormato.parse(horaTexto);
            horaCalendar.setTime(hora);
        } catch (ParseException ex) {
            Logger.getLogger(FormularioSemanaEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int horas = horaCalendar.get(Calendar.HOUR_OF_DAY);
        int minutos = horaCalendar.get(Calendar.MINUTE);

        dataCalendar.set(Calendar.HOUR_OF_DAY, horas);
        dataCalendar.set(Calendar.MINUTE, minutos);
        dataCalendar.set(Calendar.SECOND, 0);
        dataCalendar.set(Calendar.MILLISECOND, 0);

        return dataCalendar.getTime();
    }
    
    private boolean verificarCampos() {
        List<String> erros = new ArrayList<>();
        
        ValidacoesUtil.verificarTexto(inputTitulo.getText(), "Título", erros);
        ValidacoesUtil.verificarTexto(inputCarga.getText(), "Carga horária", erros);
        ValidacoesUtil.verificarTexto(inputVaga.getText(), "Vagas", erros);
        ValidacoesUtil.verificarTexto(inputData.getDate() == null ? "" : (""+inputData.getDate().getYear()), "Data", erros);
        ValidacoesUtil.verificarTexto(inputHora.getText().replaceAll("[^0-9]", ""), "Hora", erros);
        
        ValidacoesUtil.verificarTamanho(inputTitulo.getText(), "Título", 85, erros);
        ValidacoesUtil.verificarTamanho(inputCarga.getText(), "Carga horária", 2, erros);
        ValidacoesUtil.verificarTamanho(inputVaga.getText(), "Vagas", 3, erros);

        if(!erros.isEmpty()) {
            String mensagem = "Preencha os campos: " + String.join(", ", erros);
            JOptionPane.showMessageDialog(this, mensagem, "Campos obrigatórios", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        inputTitulo = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        inputCarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        inputData = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        inputVaga = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputHora = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResponsavel = new javax.swing.JTable();
        btnMais = new javax.swing.JButton();
        btnMenos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evento");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel1.setText("Evento");

        jLabel2.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel2.setText("Título*:");

        inputTitulo.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnSalvar.setText("Adicionar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        inputCarga.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel3.setText("Carga horária*:");

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("SourceSans3VF", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Campos marcado por \"*\" São obrigatórios!");

        btnCancelar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        inputData.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel6.setText("Data*:");

        inputVaga.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel7.setText("Vagas*:");

        try {
            inputHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputHora.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel8.setText("Hora*:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel5.setText("Responsáveis");

        tableResponsavel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResponsavel.setRowHeight(30);
        tableResponsavel.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableResponsavel);

        btnMais.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnMais.setText("Mais um");
        btnMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisActionPerformed(evt);
            }
        });

        btnMenos.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnMenos.setText("Menos um");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator4)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(inputCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(inputVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)))))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMais, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputData, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenos)
                    .addComponent(btnMais))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(verificarCampos()) {
            if(evento.getResponsaveis() == null || evento.getResponsaveis().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Adicione pelo menos um responsável!", "Campos obrigatórios", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            evento.setSemana(semana);
            evento.setTitulo(inputTitulo.getText());
            evento.setCargaHoraria(Integer.parseInt(inputCarga.getText()));
            evento.setNumeroVaga(Integer.parseInt(inputVaga.getText()));
            
            evento.setDataEvento(combinarDataHora(inputData.getCalendar(), inputHora.getText()));
            
            if(isAlterar)
                eventoController.edit(evento);
            else {
                semana.addEvento(evento);
                semanaController.edit(semana);
            }
            
            JOptionPane.showMessageDialog(this, "Evento " + (isAlterar ? "alterado " : "adicionado ") + "com sucesso!", "Evento", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisActionPerformed
        participante = null;
        
        SelectParticipante selectParticipante = new SelectParticipante(null, rootPaneCheckingEnabled);
        selectParticipante.setFormularioSemanaEvento(this);
        selectParticipante.setVisible(true);
        
        if(participante == null)
            JOptionPane.showMessageDialog(this, "Nenhum responsável selecionado.", "Seleção de responsável", JOptionPane.ERROR_MESSAGE);
        else {
            boolean isAdded = false;
            
            for(Responsavel responsavel : evento.getResponsaveis()) {
                if(responsavel.getParticipante().equals(participante))
                    isAdded = true;
            }
            
            if(isAdded)
                JOptionPane.showMessageDialog(this, "O responsável selecionado já foi inserido.", "Seleção de responsável", JOptionPane.ERROR_MESSAGE);
            else
                evento.addResponsavel(new Responsavel(participante));
            atualizarTabela();
        }
    }//GEN-LAST:event_btnMaisActionPerformed

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        if (tableResponsavel.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this, "Selecione um responsável na tabela!", "Exclusão", JOptionPane.WARNING_MESSAGE);
        else {
            Responsavel responsavel = evento.getResponsaveis().get(tableResponsavel.getSelectedRow());
            
            int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir o responsável: " + responsavel.getParticipante().getNome()+ "?",
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if(confirmacao == JOptionPane.YES_OPTION) {
                evento.removeResponsavel(responsavel);
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_btnMenosActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioSemanaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSemanaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSemanaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSemanaEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioSemanaEvento dialog = new FormularioSemanaEvento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnMais;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField inputCarga;
    private com.toedter.calendar.JDateChooser inputData;
    private javax.swing.JFormattedTextField inputHora;
    private javax.swing.JTextField inputTitulo;
    private javax.swing.JTextField inputVaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tableResponsavel;
    // End of variables declaration//GEN-END:variables
}
