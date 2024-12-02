package view;

import controller.AdministradorController;
import controller.ParticipanteController;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Administrador;
import model.Participante;

public class Login extends javax.swing.JFrame {
    private AdministradorController administradorController;
    private ParticipanteController participanteController;
    
    public Login() {
        initComponents();
        
        this.administradorController = new AdministradorController();
        this.participanteController = new ParticipanteController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        inputLogin = new javax.swing.JTextField();
        barLogin = new javax.swing.JPanel();
        labelSenha = new javax.swing.JLabel();
        barSenha = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JPanel();
        labelEntrar = new javax.swing.JLabel();
        labelEsqueceu = new javax.swing.JLabel();
        barEsqueceu = new javax.swing.JPanel();
        inputSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));
        jPanel1.setForeground(new java.awt.Color(253, 253, 253));

        jPanel2.setBackground(new java.awt.Color(100, 152, 254));
        jPanel2.setForeground(new java.awt.Color(100, 152, 254));

        jLabel2.setBackground(new java.awt.Color(253, 253, 253));
        jLabel2.setFont(new java.awt.Font("SourceSans3VF", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 253, 253));
        jLabel2.setText("Semana Nacional");

        jLabel1.setBackground(new java.awt.Color(253, 253, 253));
        jLabel1.setFont(new java.awt.Font("SourceSans3VF", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 253, 253));
        jLabel1.setText("de Ciência e Tecnologia");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/exit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        labelLogin.setBackground(new java.awt.Color(104, 104, 104));
        labelLogin.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(104, 104, 104));
        labelLogin.setLabelFor(inputLogin);
        labelLogin.setText("Login");

        inputLogin.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        inputLogin.setBorder(null);
        inputLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputLoginFocusLost(evt);
            }
        });

        barLogin.setBackground(new java.awt.Color(104, 104, 104));
        barLogin.setForeground(new java.awt.Color(104, 104, 104));
        barLogin.setPreferredSize(new java.awt.Dimension(163, 1));

        javax.swing.GroupLayout barLoginLayout = new javax.swing.GroupLayout(barLogin);
        barLogin.setLayout(barLoginLayout);
        barLoginLayout.setHorizontalGroup(
            barLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barLoginLayout.setVerticalGroup(
            barLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        labelSenha.setBackground(new java.awt.Color(104, 104, 104));
        labelSenha.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(104, 104, 104));
        labelSenha.setLabelFor(inputLogin);
        labelSenha.setText("Senha");

        barSenha.setBackground(new java.awt.Color(104, 104, 104));
        barSenha.setForeground(new java.awt.Color(104, 104, 104));
        barSenha.setPreferredSize(new java.awt.Dimension(163, 1));

        javax.swing.GroupLayout barSenhaLayout = new javax.swing.GroupLayout(barSenha);
        barSenha.setLayout(barSenhaLayout);
        barSenhaLayout.setHorizontalGroup(
            barSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        barSenhaLayout.setVerticalGroup(
            barSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        btnEntrar.setBackground(new java.awt.Color(100, 152, 254));
        btnEntrar.setForeground(new java.awt.Color(100, 152, 254));
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });

        labelEntrar.setBackground(new java.awt.Color(253, 253, 253));
        labelEntrar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelEntrar.setForeground(new java.awt.Color(253, 253, 253));
        labelEntrar.setText("Entrar");

        javax.swing.GroupLayout btnEntrarLayout = new javax.swing.GroupLayout(btnEntrar);
        btnEntrar.setLayout(btnEntrarLayout);
        btnEntrarLayout.setHorizontalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEntrarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelEntrar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnEntrarLayout.setVerticalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEntrarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelEntrar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        labelEsqueceu.setBackground(new java.awt.Color(100, 152, 254));
        labelEsqueceu.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelEsqueceu.setForeground(new java.awt.Color(100, 152, 254));
        labelEsqueceu.setText("Esqueceu sua senha?");
        labelEsqueceu.setBorder(null);
        labelEsqueceu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEsqueceuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEsqueceuMouseExited(evt);
            }
        });

        barEsqueceu.setBackground(new java.awt.Color(100, 152, 254));
        barEsqueceu.setForeground(new java.awt.Color(100, 152, 254));
        barEsqueceu.setPreferredSize(new java.awt.Dimension(163, 1));

        javax.swing.GroupLayout barEsqueceuLayout = new javax.swing.GroupLayout(barEsqueceu);
        barEsqueceu.setLayout(barEsqueceuLayout);
        barEsqueceuLayout.setHorizontalGroup(
            barEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );
        barEsqueceuLayout.setVerticalGroup(
            barEsqueceuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        inputSenha.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        inputSenha.setBorder(null);
        inputSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputSenhaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputLogin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEsqueceu)
                            .addComponent(barEsqueceu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(barLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(inputSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(labelLogin)
                .addGap(0, 0, 0)
                .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(barSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(barEsqueceu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelEsqueceu)))
                .addGap(29, 29, 29))
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

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        this.btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnExit.setIcon(new ImageIcon(getClass().getResource("/view/icon/exit-focus.png")));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        this.btnExit.setIcon(new ImageIcon(getClass().getResource("/view/icon/exit.png")));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void inputLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLoginFocusGained
        this.inputLogin.setForeground(new Color(100,152,254));
        
        this.labelLogin.setForeground(new Color(100,152,254));
        this.labelLogin.setBackground(new Color(100,152,254));
        
        this.barLogin.setForeground(new Color(100,152,254));
        this.barLogin.setBackground(new Color(100,152,254));
    }//GEN-LAST:event_inputLoginFocusGained

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        this.btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnEntrar.setForeground(new Color(70,128,193));
        this.btnEntrar.setBackground(new Color(70,128,193));
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        this.btnEntrar.setForeground(new Color(100,152,254));
        this.btnEntrar.setBackground(new Color(100,152,254));
    }//GEN-LAST:event_btnEntrarMouseExited

    private void labelEsqueceuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEsqueceuMouseEntered
        this.labelEsqueceu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.labelEsqueceu.setForeground(new Color(70,128,193));
        this.labelEsqueceu.setBackground(new Color(70,128,193));
        
        this.barEsqueceu.setForeground(new Color(70,128,193));
        this.barEsqueceu.setBackground(new Color(70,128,193));
    }//GEN-LAST:event_labelEsqueceuMouseEntered

    private void labelEsqueceuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEsqueceuMouseExited
        this.labelEsqueceu.setForeground(new Color(100,152,254));
        this.labelEsqueceu.setBackground(new Color(100,152,254));
        
        this.barEsqueceu.setForeground(new Color(100,152,254));
        this.barEsqueceu.setBackground(new Color(100,152,254));
    }//GEN-LAST:event_labelEsqueceuMouseExited

    private void inputLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputLoginFocusLost
        this.inputLogin.setForeground(new Color(104,104,104));
        
        this.labelLogin.setForeground(new Color(104,104,104));
        this.labelLogin.setBackground(new Color(104,104,104));
        
        this.barLogin.setForeground(new Color(104,104,104));
        this.barLogin.setBackground(new Color(104,104,104));
    }//GEN-LAST:event_inputLoginFocusLost

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        String login = this.inputLogin.getText();
        String senha = this.inputSenha.getText();
        
        Administrador administrador = administradorController.getByLogin(login, senha);
        
        if(administrador != null) {
            MenuAdministrador menuAdmin = new MenuAdministrador(this, rootPaneCheckingEnabled);
            
            this.setVisible(false);
            
            menuAdmin.setAdministrador(administrador);
            menuAdmin.setVisible(true);
            
            inputLogin.setText("");
            inputSenha.setText("");
            
            this.setVisible(true);
        }
        else {
            Participante participante = participanteController.getByLogin(login, senha);
            
            if(participante != null) {
                MenuParticipante menuParticipante = new MenuParticipante(this, rootPaneCheckingEnabled);

                this.setVisible(false);
                
                menuParticipante.setParticipante(participante);
                menuParticipante.setVisible(true);
                
                inputLogin.setText("");
                inputSenha.setText("");
                
                this.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEntrarMouseClicked

    private void inputSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSenhaFocusGained
        this.inputSenha.setForeground(new Color(100,152,254));
        
        this.labelSenha.setForeground(new Color(100,152,254));
        this.labelSenha.setBackground(new Color(100,152,254));
        
        this.barSenha.setForeground(new Color(100,152,254));
        this.barSenha.setBackground(new Color(100,152,254));
    }//GEN-LAST:event_inputSenhaFocusGained

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barEsqueceu;
    private javax.swing.JPanel barLogin;
    private javax.swing.JPanel barSenha;
    private javax.swing.JPanel btnEntrar;
    private javax.swing.JLabel btnExit;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelEntrar;
    private javax.swing.JLabel labelEsqueceu;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    // End of variables declaration//GEN-END:variables
}
