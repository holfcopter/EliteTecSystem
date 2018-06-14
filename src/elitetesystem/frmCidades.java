/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elitetesystem;

import dao.CidadeDAO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.HashSet;
import javax.swing.JOptionPane;
import model.Cidade;
import model.CidadeTableModel;

/**
 *
 * @author DC CENTER PAES
 */
public class frmCidades extends javax.swing.JDialog {

    private CidadeDAO cidadeDAO;
    private Cidade cidade;
    private Long codigoRetorno;

    /**
     * Creates new form frmCidades
     */
    public frmCidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.BLUE);
        txtLocalizaPorNome.grabFocus();
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        URL url = this.getClass().getResource("/imagens/ELITETECLOGO.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setIconImage(imagemTitulo);
        atualizaTabelaChkUf("");
        chkUf.setSelected(true);
        tblCidades.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                //JOptionPane.showMessageDialog(null, "ERROR ERROR ERROR ERROR ERROR ERROR");
                if (e.getClickCount() == 2) {

                    int coluna = 0;
                    int linha = tblCidades.getSelectedRow();
                    int altera = 1;
                    setCodigoRetorno(Long.valueOf(tblCidades.getValueAt(linha, coluna).toString()));
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

    public void atualizaTabelaChkCodigo(String descricao) {
        CidadeDAO cidadeDAO = new CidadeDAO();

        if (descricao.equals("")) {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.listarCidadeByNome()));
            tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
            tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);

        } else {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.buscaCidadePorNome(descricao)));
            if (descricao.equals("")) {
                tblCidades.setModel(new CidadeTableModel(cidadeDAO.listarCidadeByNome()));
                tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
                tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
            }
        }
    }

    public void atualizaTabelaChkUf(String uf) {
        CidadeDAO cidadeDAO = new CidadeDAO();

        if (uf.equals("")) {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.listar1()));
            tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
            tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);

        } else {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.buscaCidadePorNome(uf)));
            if (uf.equals("")) {
                tblCidades.setModel(new CidadeTableModel(cidadeDAO.listar1()));
                tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
                tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
            }
        }
    }

    public void atualizaTabela(String nome) {
        CidadeDAO cidadeDAO = new CidadeDAO();


        if (nome.equals("")) {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.listar1()));
            tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
            tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);

        } else {
            tblCidades.setModel(new CidadeTableModel(cidadeDAO.buscaCidadePorNome(nome)));
            if (nome.equals("")) {
                tblCidades.setModel(new CidadeTableModel(cidadeDAO.listar1()));
                tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
                tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
                tblCidades.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(70);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidades = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtLocalizaPorNome = new javax.swing.JTextField();
        chkNomeCidade = new javax.swing.JCheckBox();
        chkUf = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Controle de Cidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblCidades.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCidades.setDropMode(javax.swing.DropMode.ON);
        jScrollPane1.setViewportView(tblCidades);

        jLabel1.setText("Localiza por Cidade:       ");

        txtLocalizaPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizaPorNomeActionPerformed(evt);
            }
        });
        txtLocalizaPorNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocalizaPorNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalizaPorNomeKeyReleased(evt);
            }
        });

        chkNomeCidade.setText("Nome da Cidade");
        chkNomeCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNomeCidadeActionPerformed(evt);
            }
        });

        chkUf.setText("UF");
        chkUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUfActionPerformed(evt);
            }
        });

        jLabel3.setText("Organizar por:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkNomeCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkUf))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLocalizaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkNomeCidade)
                    .addComponent(chkUf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLocalizaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1323972017_fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtLocalizaPorNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizaPorNomeKeyReleased
    }//GEN-LAST:event_txtLocalizaPorNomeKeyReleased

    private void txtLocalizaPorNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalizaPorNomeKeyPressed
        atualizaTabela(txtLocalizaPorNome.getText());
        tblCidades.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        tblCidades.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(200);
        tblCidades.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(50);
    }//GEN-LAST:event_txtLocalizaPorNomeKeyPressed

    private void txtLocalizaPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizaPorNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizaPorNomeActionPerformed

    private void chkNomeCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNomeCidadeActionPerformed
        try {
            if (chkNomeCidade.isSelected()) {
                chkUf.setSelected(false);
                atualizaTabelaChkCodigo("");
                txtLocalizaPorNome.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO NO CHKCIDADE");
        }
    }//GEN-LAST:event_chkNomeCidadeActionPerformed

    private void chkUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUfActionPerformed
        try {
            if (chkUf.isSelected()) {
                chkNomeCidade.setSelected(false);
                atualizaTabelaChkUf("");
                txtLocalizaPorNome.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO NO CHKUF");
        }
    }//GEN-LAST:event_chkUfActionPerformed

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
            java.util.logging.Logger.getLogger(frmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmCidades dialog = new frmCidades(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox chkNomeCidade;
    private javax.swing.JCheckBox chkUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCidades;
    private javax.swing.JTextField txtLocalizaPorNome;
    // End of variables declaration//GEN-END:variables
}
