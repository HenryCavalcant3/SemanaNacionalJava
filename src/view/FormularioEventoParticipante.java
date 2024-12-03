package view;

import controller.CursoController;
import controller.EventoController;
import controller.SemanaController;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Curso;
import model.Evento;
import model.Matricula;
import model.Participante;
import model.Semana;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.CertificadoModelo;

public class FormularioEventoParticipante extends javax.swing.JDialog {
    private SemanaController semanaController;
    private Semana semana;
    private boolean isAlterar = false;
    
    private CursoController cursoController;
    private List<Curso> cursos;
    
    private Participante participante;
    
    private EventoController eventoController;
    
    private static SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm dd/MM/yyyy");
    
    public FormularioEventoParticipante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        semanaController = new SemanaController();
        semana = new Semana();
        
        cursoController = new CursoController();
        cursos = cursoController.getAll();
        
        eventoController = new EventoController();
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
        this.isAlterar = true;
        
        labelNome.setText(semana.getNome());
        labelLocal.setText(semana.getLocal());
        labelInicio.setText(formatador.format(semana.getInicio()));
        labelFim.setText(formatador.format(semana.getFim()));
        labelObservacao.setText(semana.getObservacao().isBlank() ? " " : semana.getObservacao());
        labelOrganizador.setText(semana.getOrganizador().getNome());
        labelCurso.setText(semana.getOrganizador().getCurso().getSigla() + " - " + semana.getOrganizador().getCurso().getNome());
    
        btnEntrar.setVisible(semana.isAtiva());
        btnSair.setVisible(semana.isAtiva());
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
        
        atualizarTabela();
    }
    
    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tableEvento.getModel();
        
        model.setRowCount(0);
        
        for(Evento evento : semana.getEventos()) {
            boolean isMatriculado = false;
            
            for(Matricula matricula: evento.getMatriculas()) {
                if(matricula.getParticipante().getProntuario().equals(participante.getProntuario())) {
                    isMatriculado = true;
                }
            }
            
            model.addRow(new Object[]{evento.getTitulo(), evento.getCargaHoraria(), evento.getNumeroVaga(), evento.getMatriculas().size(), formatadorHora.format(evento.getDataEvento()), isMatriculado ? "Sim" : "Não"});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnVoltar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labelNome = new javax.swing.JLabel();
        labelLocal = new javax.swing.JLabel();
        labelInicio = new javax.swing.JLabel();
        labelFim = new javax.swing.JLabel();
        labelObservacao = new javax.swing.JLabel();
        labelOrganizador = new javax.swing.JLabel();
        labelCurso = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEvento = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        btnCertificado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Semana");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel1.setText("Semana");

        jLabel2.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel2.setText("Nome*:");

        jLabel3.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel3.setText("Local*:");

        btnVoltar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel5.setText("Início*:");

        jLabel6.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel6.setText("Fim*:");

        jLabel8.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel8.setText("Observação:");

        jLabel10.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel10.setText("Organizador*:");

        labelNome.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelNome.setText("-");
        labelNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelLocal.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelLocal.setText("-");
        labelLocal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelInicio.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelInicio.setText("-");
        labelInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelFim.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelFim.setText("-");
        labelFim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelObservacao.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelObservacao.setText("-");
        labelObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelOrganizador.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelOrganizador.setText("-");
        labelOrganizador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelCurso.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        labelCurso.setText("-");
        labelCurso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        jLabel17.setText("Curso*:");

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("SourceSans3VF", 1, 24)); // NOI18N
        jLabel18.setText("Eventos");

        tableEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Carga horária", "Vagas", "Inscritos", "Data", "Inscrito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEvento.setRowHeight(30);
        tableEvento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEvento);

        btnSair.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEntrar.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnCertificado.setFont(new java.awt.Font("SourceSans3VF", 1, 18)); // NOI18N
        btnCertificado.setText("Certificado");
        btnCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(labelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(labelFim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(labelObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(labelLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(labelOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(labelCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNome)
                                    .addComponent(labelLocal)))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelInicio)
                            .addComponent(labelFim)
                            .addComponent(labelObservacao))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrganizador)
                    .addComponent(labelCurso))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCertificado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if (tableEvento.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this, "Selecione um evento na tabela!", "Sair", JOptionPane.WARNING_MESSAGE);
        else {
            Evento evento = semana.getEventos().get(tableEvento.getSelectedRow());
            
            int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja sair do evento: " + evento.getTitulo()+ "?",
                "Confirmação de Entrada",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if(confirmacao == JOptionPane.YES_OPTION) {
                for(Matricula matricula: semana.getEventos().get(semana.getEventos().indexOf(evento)).getMatriculas()) {
                    if(matricula.getParticipante().equals(participante)) {
                        semana.getEventos().get(semana.getEventos().indexOf(evento)).removeMatricula(matricula);
                        semanaController.edit(semana);
                        semana = semanaController.findById(semana.getId());
                        atualizarTabela();

                        JOptionPane.showMessageDialog(this, "Saiu do evento com sucesso!", "Sair", JOptionPane.INFORMATION_MESSAGE);

                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Você não entrou neste evento!", "Sair", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (tableEvento.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this, "Selecione um evento na tabela!", "Entrar", JOptionPane.WARNING_MESSAGE);
        else {
            Evento evento = semana.getEventos().get(tableEvento.getSelectedRow());
            
            if(evento.getQtdInscrito() == evento.getNumeroVaga()) {
                JOptionPane.showMessageDialog(this, "Evento sem vagas!", "Entrar", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja entrar do evento: " + evento.getTitulo()+ "?",
                "Confirmação de Entrada",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            for(Matricula matricula: semana.getEventos().get(semana.getEventos().indexOf(evento)).getMatriculas()) {
                if(matricula.getParticipante().equals(participante)) {
                    JOptionPane.showMessageDialog(this, "Você já entrou neste evento!", "Entrar", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            
            if(confirmacao == JOptionPane.YES_OPTION) {
                semana.getEventos().get(semana.getEventos().indexOf(evento)).addMatricula(new Matricula(participante, new Date()));
                semanaController.edit(semana);
                semana = semanaController.findById(semana.getId());
                atualizarTabela();
                
                JOptionPane.showMessageDialog(this, "Entrou no evento com sucesso!", "Entrar", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoActionPerformed
        if (tableEvento.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(this, "Selecione um evento na tabela!", "Certificado", JOptionPane.WARNING_MESSAGE);
        else {
            Evento evento = semana.getEventos().get(tableEvento.getSelectedRow());
            
            for(Matricula matricula: semana.getEventos().get(semana.getEventos().indexOf(evento)).getMatriculas()) {
                if(matricula.getParticipante().equals(participante) ) {
                    if(matricula.isAtiva() == true) {
                        JOptionPane.showMessageDialog(this, "Você não compareceu ao evento", "Certificado", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    CertificadoModelo certificadoModelo = new CertificadoModelo();
                    certificadoModelo.setNome(participante.getNome());
                    certificadoModelo.setProntuario(participante.getProntuario());
                    certificadoModelo.setEventoTitulo(evento.getTitulo());
                    certificadoModelo.setEventoCargaHoraria(""+evento.getCargaHoraria());
                    certificadoModelo.setSemanaNome(evento.getSemana().getNome());
                    certificadoModelo.setOrganizador(evento.getSemana().getOrganizador().getNome());
                    
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("nome", certificadoModelo.getNome());
                    parametros.put("prontuario", certificadoModelo.getProntuario());
                    parametros.put("eventoTitulo", certificadoModelo.getEventoTitulo());
                    parametros.put("eventoCargaHoraria", certificadoModelo.getEventoCargaHoraria());
                    parametros.put("semanaNome", certificadoModelo.getSemanaNome());
                    parametros.put("organizador", certificadoModelo.getOrganizador());
                    
                    try {
                        JasperReport relatorioCompilado
                                = JasperCompileManager.compileReport("src/Report/RelatorioCertificado.jrxml");

                        JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorioCompilado, parametros, new JREmptyDataSource());

                        JDialog tela = new JDialog(this, "Certificado", true);
                        tela.setSize(800, 400);

                        JRViewer painelRelatorio = new JRViewer(relatorioPreenchido);

                        tela.getContentPane().add(painelRelatorio);
                        tela.setVisible(true);
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(this, "Erro ao gerar o certificado", "Certificado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    return;
                }
            }
            
            JOptionPane.showMessageDialog(this, "Você não tem certificado deste evento!", "Certificado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCertificadoActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioEventoParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEventoParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                FormularioEventoParticipante dialog = new FormularioEventoParticipante(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCertificado;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelFim;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelLocal;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObservacao;
    private javax.swing.JLabel labelOrganizador;
    private javax.swing.JTable tableEvento;
    // End of variables declaration//GEN-END:variables
}