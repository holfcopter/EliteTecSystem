/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elitetesystem;

import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.EquipamentoDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.CidadeTableModel;
import model.Cliente;
import model.Equipamento;
import model.EquipamentoTableModel;
import view.Cliente.InserirCliente;
import view.Equipamento.InserirEquipamento;

/**
 *
 * @author DC CENTER PAES
 */
public class frmEquipamento extends javax.swing.JDialog {

    /**
     * Creates new form frmEquipamento
     */
    private EquipamentoDAO equipamentoDAO;
    private Equipamento equipamento;
    private boolean alterar;
    private Long codigoRetorno;

    public frmEquipamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        URL url = this.getClass().getResource("/imagens/ELITETECLOGO.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        equipamentoDAO = new EquipamentoDAO();
        atualizaTabela("");
        tblEquipamentos.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    int coluna = 0;
                    int linha = tblEquipamentos.getSelectedRow();
                    int altera = 1;
                    setCodigoRetorno(Long.valueOf(tblEquipamentos.getValueAt(linha, coluna).toString()));
                    dispose();
                }
            }

            public void mousePressed(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseReleased(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseEntered(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }

    public Long getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(Long codigoRetorno) {
        this.codigoRetorno = codigoRetorno;



    }

    public void atualizaTabela(String cliente) {
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        if (cliente.equals("")) {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listar()));
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);

        } else {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoCliente()));
            if (cliente.equals("")) {
                tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoCliente()));
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);
            }
        }
    }

    public void atualizaTabelaNSerie(String nserie) {
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        if (nserie.equals("")) {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoNSerie(nserie)));
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);

        } else {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoNSerie(nserie)));
            if (nserie.equals("")) {
                tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoNSerie(nserie)));
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);
            }
        }
    }

    public void atualizaTabelaCliente(String cliente) {
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        if (cliente.equals("")) {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoCliente(cliente)));
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);

        } else {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoCliente(cliente)));
            if (cliente.equals("")) {
                tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoCliente(cliente)));
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(200);
            }
        }
    }

    public void atualizaTabelaDescricao(String descricao) {
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        if (descricao.equals("")) {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoDescricao(descricao)));
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
            tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(200);
        } else {
            tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoDescricao(descricao)));
            if (descricao.equals("")) {
                tblEquipamentos.setModel(new EquipamentoTableModel(equipamentoDAO.listarEquipamentoDescricao(descricao)));
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(200);
                tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(200);
            }
        }
    }

    public void tamanhoColunas() {
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(400);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(100);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(200);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(150);
        tblEquipamentos.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(100);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipamentos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscaCliente = new javax.swing.JTextField();
        txtBuscaNSerie = new javax.swing.JTextField();
        txtBuscaDescricao = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Equipamentos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Equipamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        tblEquipamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        tblEquipamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblEquipamentos);

        jLabel1.setText("Buscar por nome Cliente:");

        jLabel2.setText("Buscar por nº Série:");

        jLabel3.setText("Buscar por descrição:");

        txtBuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaClienteKeyTyped(evt);
            }
        });

        txtBuscaNSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaNSerieKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNSerieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaNSerieKeyTyped(evt);
            }
        });

        txtBuscaDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaDescricaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaDescricaoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaDescricaoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBuscaNSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtBuscaDescricao)
                            .addComponent(txtBuscaCliente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscaNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBuscaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 55, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1323972017_fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301403_inserir.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301620_deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301494_alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnNovo)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        JDialog j = new InserirEquipamento(null, true);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        atualizaTabela("");
        tamanhoColunas();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtBuscaNSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNSerieKeyPressed
        atualizaTabelaNSerie(txtBuscaNSerie.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaNSerieKeyPressed

    private void txtBuscaNSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNSerieKeyReleased
        atualizaTabelaNSerie(txtBuscaNSerie.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaNSerieKeyReleased

    private void txtBuscaNSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNSerieKeyTyped
        atualizaTabelaNSerie(txtBuscaNSerie.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaNSerieKeyTyped

    private void txtBuscaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyPressed
        atualizaTabelaCliente(txtBuscaCliente.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaClienteKeyPressed

    private void txtBuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyReleased
        atualizaTabelaCliente(txtBuscaCliente.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaClienteKeyReleased

    private void txtBuscaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaClienteKeyTyped
        atualizaTabelaCliente(txtBuscaCliente.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaClienteKeyTyped

    private void txtBuscaDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDescricaoKeyPressed
        atualizaTabelaDescricao(txtBuscaDescricao.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaDescricaoKeyPressed

    private void txtBuscaDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDescricaoKeyReleased
        atualizaTabelaDescricao(txtBuscaDescricao.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaDescricaoKeyReleased

    private void txtBuscaDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDescricaoKeyTyped
        atualizaTabelaDescricao(txtBuscaDescricao.getText());
        tamanhoColunas();
    }//GEN-LAST:event_txtBuscaDescricaoKeyTyped

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int coluna = 0;
        int linha = tblEquipamentos.getSelectedRow();
        if (linha >= 0) {
            int x = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse equipamento???", "Excluir...",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                Long codigo = (Long) tblEquipamentos.getValueAt(linha, coluna);
                Equipamento equipamento = equipamentoDAO.selecionar(codigo);
                equipamento.setStatusControle("DESATIVADO");
                equipamentoDAO.gravar(equipamento);
                atualizaTabela("");
                tamanhoColunas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor!... Selecione um equipamento para excluir!!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int coluna = 0;
        int linha = tblEquipamentos.getSelectedRow();

        if (linha >= 0) {
            Long codigo = (Long) tblEquipamentos.getValueAt(linha, coluna);
            equipamento = equipamentoDAO.selecionar(codigo);
            JDialog j = new InserirEquipamento(null, true, true, equipamento);
            j.setLocationRelativeTo(null);
            j.setVisible(true);
            equipamento = new Equipamento();
            equipamentoDAO = new EquipamentoDAO();
            //corDAO.remover(cor);
            atualizaTabela("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor!... Selecione um equipamento para alterar!!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmEquipamento dialog = new frmEquipamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEquipamentos;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtBuscaDescricao;
    private javax.swing.JTextField txtBuscaNSerie;
    // End of variables declaration//GEN-END:variables
}
