package view;

import controller.CursoController;
import controller.SemanaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curso;
import model.Organizador;
import model.Semana;
import util.ValidacoesUtil;

public class FormularioSemana extends javax.swing.JDialog {
    private SemanaController semanaController;
    private Semana semana;
    private boolean isAlterar = false;
    
    private CursoController cursoController;
    private List<Curso> cursos;
    
    public FormularioSemana(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        semanaController = new SemanaController();
        semana = new Semana();
        
        cursoController = new CursoController();
        cursos = cursoController.getAll();
        
        for(Curso curso: cursos) {
            selectCurso.addItem(curso.getSigla() + " - " + curso.getNome());
        }
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
        this.isAlterar = true;
        
        inputNome.setText(semana.getNome());
        inputLocal.setText(semana.getLocal());
        inputInicio.setDate(semana.getInicio());
        inputFim.setDate(semana.getFim());
        inputObservacao.setText(semana.getObservacao());
        inputOrganizador.setText(semana.getOrganizador().getNome());
        selectCurso.setSelectedItem(semana.getOrganizador().getCurso().getSigla() + " - " + semana.getOrganizador().getCurso().getNome());
        
        btnSalvar.setText("Alterar");
    }
    
    private boolean verificarCampos() {
        List<String> erros = new ArrayList<>();
        
        ValidacoesUtil.verificarTexto(inputNome.getText(), "Nome", erros);
        ValidacoesUtil.verificarTexto(inputLocal.getText(), "Local", erros);
        ValidacoesUtil.verificarTexto(inputInicio.getDate() == null ? "" : (""+inputInicio.getDate().getYear()), "Início", erros);
        ValidacoesUtil.verificarTexto(inputFim.getDate() == null ? "" : (""+inputFim.getDate().getYear()), "Fim", erros);
        ValidacoesUtil.verificarTexto(inputOrganizador.getText(), "Organizador", erros);
        ValidacoesUtil.verificarTexto(selectCurso.getSelectedItem().toString(), "Curso", erros);
        
        ValidacoesUtil.verificarTamanho(inputNome.getText(), "Nome", 60, erros);
        ValidacoesUtil.verificarTamanho(inputLocal.getText(), "Local", 80, erros);
        ValidacoesUtil.verificarTamanho(inputOrganizador.getText(), "Organizador", 80, erros);
        if(!inputObservacao.getText().isBlank())
            ValidacoesUtil.verificarTamanho(inputObservacao.getText(), "Observação", 255, erros);

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
        inputNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        inputLocal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        inputInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        inputFim = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        inputObservacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        selectCurso = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        inputOrganizador = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Semana");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel1.setText("Semana");

        jLabel2.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel2.setText("Nome*:");

        inputNome.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnSalvar.setText("Adicionar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        inputLocal.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel3.setText("Local*:");

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

        inputInicio.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel5.setText("Início*:");

        inputFim.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel6.setText("Fim*:");

        inputObservacao.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel8.setText("Observação:");

        selectCurso.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel9.setText("Curso*:");

        inputOrganizador.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel10.setText("Organizador*:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNome)
                    .addComponent(inputObservacao)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(inputOrganizador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(selectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(inputLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(inputInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(inputFim, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputFim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            semana.setNome(inputNome.getText());
            semana.setLocal(inputLocal.getText());
            semana.setInicio(inputInicio.getDate());
            semana.setFim(inputFim.getDate());
            semana.setObservacao(inputObservacao.getText());
            semana.setOrganizador(new Organizador(semana, inputOrganizador.getText(), cursos.get(selectCurso.getSelectedIndex())));
            
            if(isAlterar)
                semanaController.edit(semana);
            else
                semanaController.insert(semana);
            
            JOptionPane.showMessageDialog(this, "Curso " + (isAlterar ? "alterado " : "adicionado ") + "com sucesso!", "Curso", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioSemana dialog = new FormularioSemana(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser inputFim;
    private com.toedter.calendar.JDateChooser inputInicio;
    private javax.swing.JTextField inputLocal;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputObservacao;
    private javax.swing.JTextField inputOrganizador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> selectCurso;
    // End of variables declaration//GEN-END:variables
}
