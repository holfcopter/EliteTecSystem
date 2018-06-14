/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elitetesystem;

import dao.ClienteDAO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.*;
import view.Cliente.InserirCliente;

/**
 *
 * @author DC CENTER PAES
 */
public class frmCliente extends javax.swing.JDialog {

    /**
     * Creates new form frmCliente
     */
    private ClienteDAO clienteDAO;
    private Cliente cliente;
    private boolean alterar;
    private Long codigoRetorno;

    public frmCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        URL url = this.getClass().getResource("/imagens/ELITETECLOGO.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.getContentPane().setBackground(Color.BLUE);
        txtBuscaNome.requestFocus();
        btnAlterar.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnAlterar.doClick();
                        } else {
                        }
                    }
                });
        btnCancelar.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnCancelar.doClick();
                        } else {
                        }
                    }
                });
        btnExcluir.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnExcluir.doClick();
                        } else {
                        }
                    }
                });
        btnInserir.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnInserir.doClick();
                        } else {
                        }
                    }
                });
        btnBuscaPorCel.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnBuscaPorCel.doClick();
                        } else {
                        }
                    }
                });
        btnNovaPesquisa.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            btnNovaPesquisa.doClick();
                        } else {
                        }
                    }
                });
        this.setIconImage(imagemTitulo);
        atualizaTabela("");
        clienteDAO = new ClienteDAO();
        tblCliente.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    int coluna = 0;
                    int linha = tblCliente.getSelectedRow();
                    int altera = 1;
                    setCodigoRetorno(Long.valueOf(tblCliente.getValueAt(linha, coluna).toString()));
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

    public void atualizaTabela(String nome) {
        ClienteDAO clienteDAO = new ClienteDAO();


        if (nome.equals("")) {
            tblCliente.setModel(new ClienteTableModel(clienteDAO.listar()));
            tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
            tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
            tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
            tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
            tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
            tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
            tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
            tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
            tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
            tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
            tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
            tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);


        } else {
            tblCliente.setModel(new ClienteTableModel(clienteDAO.buscaClientePorNome(nome)));
            if (nome.equals("")) {
                tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
                tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
                tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
                tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
                tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
                tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
                tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
                tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
                tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
                tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
                tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
                tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);
            }
        }
    }

    public void atualizaTabelaClientes(String cel) {
        ClienteDAO clienteDAO = new ClienteDAO();
        if (cel.equals("")) {
            tblCliente.setModel(new ClienteTableModel(clienteDAO.listar()));
            tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
            tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
            tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
            tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
            tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
            tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
            tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
            tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
            tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
            tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
            tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
            tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
            tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
            tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
            tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);

        } else {
            tblCliente.setModel(new ClienteTableModel(clienteDAO.buscaClientePorCel(cel)));
            if (cel.equals("")) {
                tblCliente.setModel(new ClienteTableModel(clienteDAO.listar()));
                tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
                tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
                tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
                tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
                tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
                tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
                tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
                tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
                tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
                tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
                tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
                tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
                tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
                tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
                tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);

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
        tblCliente = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaNome = new javax.swing.JTextField();
        txtBuscaCel = new javax.swing.JFormattedTextField();
        btnBuscaPorCel = new javax.swing.JButton();
        btnNovaPesquisa = new javax.swing.JButton();
        lblStatusCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro do Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Cadastro de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1323972017_fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301620_deletar.png"))); // NOI18N
        btnExcluir.setText("Excluir Cadastro Cliente");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301494_alterar.png"))); // NOI18N
        btnAlterar.setText("Alterar Cadastro Cliente");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324301403_inserir.png"))); // NOI18N
        btnInserir.setText("Cadastrar Novo Cliente");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por Cel:");

        txtBuscaNome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyTyped(evt);
            }
        });

        try {
            txtBuscaCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBuscaCel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBuscaCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaCelActionPerformed(evt);
            }
        });
        txtBuscaCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaCelKeyPressed(evt);
            }
        });

        btnBuscaPorCel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscaPorCel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/6247_32x32.png"))); // NOI18N
        btnBuscaPorCel.setText("Buscar");
        btnBuscaPorCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaPorCelActionPerformed(evt);
            }
        });

        btnNovaPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1360448044_zoom in.png"))); // NOI18N
        btnNovaPesquisa.setText("Nova Pesquisa");
        btnNovaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaPesquisaActionPerformed(evt);
            }
        });

        lblStatusCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStatusCliente.setText("STATUS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscaNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBuscaCel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscaPorCel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNovaPesquisa)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addComponent(lblStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscaNome, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtBuscaCel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscaPorCel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovaPesquisa)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        JDialog j = new InserirCliente(null, true);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        atualizaTabela("");
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int coluna = 0;
        int linha = tblCliente.getSelectedRow();

        if (linha >= 0) {
            Long codigo = (Long) tblCliente.getValueAt(linha, coluna);
            cliente = clienteDAO.selecionar(codigo);
            JDialog j = new InserirCliente(null, true, true, cliente);
            j.setLocationRelativeTo(null);
            j.setVisible(true);
            cliente = new Cliente();
            clienteDAO = new ClienteDAO();
            //corDAO.remover(cor);
            atualizaTabela("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor!... Selecione um cliente para alterar!!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtBuscaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyPressed
        atualizaTabela(txtBuscaNome.getText());
        tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
        tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
        tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
        tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
        tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
        tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
        tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
        tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
        tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
        tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
        tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
        tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);
    }//GEN-LAST:event_txtBuscaNomeKeyPressed

    private void txtBuscaCelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaCelKeyPressed
    }//GEN-LAST:event_txtBuscaCelKeyPressed

    private void btnBuscaPorCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPorCelActionPerformed
        atualizaTabelaClientes(txtBuscaCel.getText());
        tblCliente.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
        tblCliente.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(70);
        tblCliente.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(90);
        tblCliente.getTableHeader().getColumnModel().getColumn(6).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(7).setPreferredWidth(75);
        tblCliente.getTableHeader().getColumnModel().getColumn(8).setPreferredWidth(150);
        tblCliente.getTableHeader().getColumnModel().getColumn(9).setPreferredWidth(200);
        tblCliente.getTableHeader().getColumnModel().getColumn(10).setPreferredWidth(30);
        tblCliente.getTableHeader().getColumnModel().getColumn(11).setPreferredWidth(80);
        tblCliente.getTableHeader().getColumnModel().getColumn(12).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(13).setPreferredWidth(110);
        tblCliente.getTableHeader().getColumnModel().getColumn(14).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(15).setPreferredWidth(100);
        tblCliente.getTableHeader().getColumnModel().getColumn(16).setPreferredWidth(130);
        tblCliente.getTableHeader().getColumnModel().getColumn(17).setPreferredWidth(110);
        tblCliente.getTableHeader().getColumnModel().getColumn(18).setPreferredWidth(300);
        tblCliente.getTableHeader().getColumnModel().getColumn(19).setPreferredWidth(130);
        tblCliente.getTableHeader().getColumnModel().getColumn(20).setPreferredWidth(500);
        btnBuscaPorCel.setEnabled(false);
        btnNovaPesquisa.grabFocus();
    }//GEN-LAST:event_btnBuscaPorCelActionPerformed

    private void btnNovaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaPesquisaActionPerformed
        this.dispose();
        JDialog j = new frmCliente(null, true);
        txtBuscaCel.grabFocus();
        j.setLocationRelativeTo(null);
        j.setVisible(true);

    }//GEN-LAST:event_btnNovaPesquisaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int coluna = 0;
        int linha = tblCliente.getSelectedRow();
        if (linha >= 0) {
            int x = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse cliente???", "Excluir...",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                Long codigo = (Long) tblCliente.getValueAt(linha, coluna);
                Cliente cliente = clienteDAO.selecionar(codigo);
                clienteDAO.remover(cliente);
                atualizaTabela("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor!... Selecione um cliente para excluir!!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyReleased
        JTextField tf = (JTextField) evt.getComponent();
        if (evt.getKeyCode() != 32 & evt.getKeyCode() != 8 & evt.getKeyCode() != 37 & evt.getKeyCode() != 39) {
            tf.setText(tf.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtBuscaNomeKeyReleased

    private void txtBuscaNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyTyped
    }//GEN-LAST:event_txtBuscaNomeKeyTyped

    private void txtBuscaCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaCelActionPerformed
        txtBuscaCel.addKeyListener(
                new KeyAdapter() {

                    public void keyPressed(KeyEvent evt) {
                        int ln_ke_pressionado = evt.getKeyCode();
                        if (ln_ke_pressionado == KeyEvent.VK_ENTER) {
                            try {
                                if (!txtBuscaCel.getText().equals("(  )    -    ")) {
                                    btnBuscaPorCel.requestFocus();
                                }
                            } catch (Exception e) {
//                                if(txtBuscaCel.getText().equals("(  )    -    ")){
                                JOptionPane.showMessageDialog(null, "Por favor digite um número de telefone válido!");
//                                }
                            }
                        } else {
                        }
                    }
                });

    }//GEN-LAST:event_txtBuscaCelActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int coluna = 0;
        int linha = tblCliente.getSelectedRow();
        try {
            if (linha >= 0) {
                Long codigo = (Long) tblCliente.getValueAt(linha, coluna);
                cliente = clienteDAO.selecionar(codigo);
                if (cliente.getStatus().equals("ATIVO")) {
                    lblStatusCliente.setText(cliente.getStatus());
                    lblStatusCliente.setForeground(Color.GREEN);

                } else if (cliente.getStatus().equals("BLOQUEADO")) {
                    lblStatusCliente.setForeground(Color.RED);
                    lblStatusCliente.setText(cliente.getStatus());
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblClienteMouseClicked

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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmCliente dialog = new frmCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscaPorCel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnNovaPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatusCliente;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtBuscaCel;
    private javax.swing.JTextField txtBuscaNome;
    // End of variables declaration//GEN-END:variables
}
