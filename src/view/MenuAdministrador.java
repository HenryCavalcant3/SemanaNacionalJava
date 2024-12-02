package view;

import java.awt.Color;
import java.awt.Cursor;
import model.Administrador;

public class MenuAdministrador extends javax.swing.JDialog {
    private Administrador administrador;
    
    public MenuAdministrador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnSemana = new javax.swing.JLabel();
        barSemana = new javax.swing.JPanel();
        btnParticipante = new javax.swing.JLabel();
        barParticipante = new javax.swing.JPanel();
        barCurso = new javax.swing.JPanel();
        btnCurso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setForeground(new java.awt.Color(253, 253, 253));

        jPanel2.setBackground(new java.awt.Color(70, 128, 193));
        jPanel2.setForeground(new java.awt.Color(70, 128, 193));

        jLabel2.setBackground(new java.awt.Color(253, 253, 253));
        jLabel2.setFont(new java.awt.Font("SourceSans3VF", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 253, 253));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/icon.png"))); // NOI18N
        jLabel2.setText("SNCT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(new java.awt.Color(100, 152, 254));
        jPanel3.setForeground(new java.awt.Color(100, 152, 254));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(70, 128, 193));
        jPanel4.setForeground(new java.awt.Color(70, 128, 193));

        btnSemana.setBackground(new java.awt.Color(253, 253, 253));
        btnSemana.setFont(new java.awt.Font("SourceSans3VF", 1, 20)); // NOI18N
        btnSemana.setForeground(new java.awt.Color(253, 253, 253));
        btnSemana.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSemana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/calendario.png"))); // NOI18N
        btnSemana.setText("Semanas");
        btnSemana.setAutoscrolls(true);
        btnSemana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSemanaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSemanaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSemanaMouseExited(evt);
            }
        });

        barSemana.setBackground(new java.awt.Color(253, 253, 253));
        barSemana.setForeground(new java.awt.Color(253, 253, 253));

        javax.swing.GroupLayout barSemanaLayout = new javax.swing.GroupLayout(barSemana);
        barSemana.setLayout(barSemanaLayout);
        barSemanaLayout.setHorizontalGroup(
            barSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barSemanaLayout.setVerticalGroup(
            barSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        btnParticipante.setBackground(new java.awt.Color(253, 253, 253));
        btnParticipante.setFont(new java.awt.Font("SourceSans3VF", 1, 20)); // NOI18N
        btnParticipante.setForeground(new java.awt.Color(253, 253, 253));
        btnParticipante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnParticipante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/person.png"))); // NOI18N
        btnParticipante.setText("Participantes");
        btnParticipante.setAutoscrolls(true);
        btnParticipante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParticipanteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnParticipanteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnParticipanteMouseExited(evt);
            }
        });

        barParticipante.setBackground(new java.awt.Color(253, 253, 253));
        barParticipante.setForeground(new java.awt.Color(253, 253, 253));

        javax.swing.GroupLayout barParticipanteLayout = new javax.swing.GroupLayout(barParticipante);
        barParticipante.setLayout(barParticipanteLayout);
        barParticipanteLayout.setHorizontalGroup(
            barParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barParticipanteLayout.setVerticalGroup(
            barParticipanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        barCurso.setBackground(new java.awt.Color(253, 253, 253));
        barCurso.setForeground(new java.awt.Color(253, 253, 253));

        javax.swing.GroupLayout barCursoLayout = new javax.swing.GroupLayout(barCurso);
        barCurso.setLayout(barCursoLayout);
        barCursoLayout.setHorizontalGroup(
            barCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barCursoLayout.setVerticalGroup(
            barCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        btnCurso.setBackground(new java.awt.Color(253, 253, 253));
        btnCurso.setFont(new java.awt.Font("SourceSans3VF", 1, 20)); // NOI18N
        btnCurso.setForeground(new java.awt.Color(253, 253, 253));
        btnCurso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/curso.png"))); // NOI18N
        btnCurso.setText("Cursos");
        btnCurso.setAutoscrolls(true);
        btnCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCursoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCursoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCursoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(btnCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnSemana)
                .addGap(0, 0, 0)
                .addComponent(barSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnParticipante)
                .addGap(0, 0, 0)
                .addComponent(barParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCurso)
                .addGap(0, 0, 0)
                .addComponent(barCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(104, 104, 104));
        jLabel5.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(104, 104, 104));
        jLabel5.setText("Semanas");

        jPanel8.setBackground(new java.awt.Color(251, 251, 251));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(104, 104, 104), 1, true));
        jPanel8.setForeground(new java.awt.Color(104, 104, 104));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSemanaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemanaMouseEntered
        this.btnSemana.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.btnSemana.setForeground(new Color(104,104,104));
        this.btnSemana.setBackground(new Color(104,104,104));
        
        this.barSemana.setForeground(new Color(104,104,104));
        this.barSemana.setBackground(new Color(104,104,104));
    }//GEN-LAST:event_btnSemanaMouseEntered

    private void btnSemanaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemanaMouseExited
        this.btnSemana.setForeground(new Color(253,253,253));
        this.btnSemana.setBackground(new Color(253,253,253));
        
        this.barSemana.setForeground(new Color(253,253,253));
        this.barSemana.setBackground(new Color(253,253,253));
    }//GEN-LAST:event_btnSemanaMouseExited

    private void btnParticipanteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipanteMouseEntered
        this.btnParticipante.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.btnParticipante.setForeground(new Color(104,104,104));
        this.btnParticipante.setBackground(new Color(104,104,104));
        
        this.btnParticipante.setForeground(new Color(104,104,104));
        this.btnParticipante.setBackground(new Color(104,104,104));
    }//GEN-LAST:event_btnParticipanteMouseEntered

    private void btnParticipanteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipanteMouseExited
        this.btnParticipante.setForeground(new Color(253,253,253));
        this.btnParticipante.setBackground(new Color(253,253,253));
        
        this.btnParticipante.setForeground(new Color(253,253,253));
        this.btnParticipante.setBackground(new Color(253,253,253));
    }//GEN-LAST:event_btnParticipanteMouseExited

    private void btnCursoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursoMouseEntered
        this.btnCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.btnCurso.setForeground(new Color(104,104,104));
        this.btnCurso.setBackground(new Color(104,104,104));
        
        this.btnCurso.setForeground(new Color(104,104,104));
        this.btnCurso.setBackground(new Color(104,104,104));
    }//GEN-LAST:event_btnCursoMouseEntered

    private void btnCursoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursoMouseExited
        this.btnCurso.setForeground(new Color(253,253,253));
        this.btnCurso.setBackground(new Color(253,253,253));
        
        this.btnCurso.setForeground(new Color(253,253,253));
        this.btnCurso.setBackground(new Color(253,253,253));
    }//GEN-LAST:event_btnCursoMouseExited

    private void btnSemanaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemanaMouseClicked
        Semanas semanas = new Semanas(null, rootPaneCheckingEnabled);
        
        this.setVisible(false);
        semanas.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnSemanaMouseClicked

    private void btnParticipanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticipanteMouseClicked
        Participantes participantes = new Participantes(null, rootPaneCheckingEnabled);
        
        this.setVisible(false);
        participantes.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnParticipanteMouseClicked

    private void btnCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCursoMouseClicked
        Cursos cursos = new Cursos(null, rootPaneCheckingEnabled);
        
        this.setVisible(false);
        cursos.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_btnCursoMouseClicked

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
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuAdministrador dialog = new MenuAdministrador(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel barCurso;
    private javax.swing.JPanel barParticipante;
    private javax.swing.JPanel barSemana;
    private javax.swing.JLabel btnCurso;
    private javax.swing.JLabel btnParticipante;
    private javax.swing.JLabel btnSemana;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
