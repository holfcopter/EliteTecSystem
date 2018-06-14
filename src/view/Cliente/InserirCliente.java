/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Cliente;

import elitetesystem.frmCidades;
import dao.BairroDAO;
import dao.CidadeDAO;
import dao.ClienteDAO;
import elitetesystem.frmBairro;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Cliente;

/**
 *
 * @author DC CENTER PAES
 */
public class InserirCliente extends javax.swing.JDialog {

    /**
     * Creates new form InserirCliente
     */
    private boolean alterar;
    private Cliente cliente;
    ClienteDAO clienteDAO = new ClienteDAO();
    private Long codigoRetorno;
    private Long CodCidade;
    private Long CodBairro;

    public InserirCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        URL url = this.getClass().getResource("/imagens/ELITETECLOGO.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.getContentPane().setBackground(Color.BLUE);
        txtCNPJ.setEnabled(false);
        txtIE.setEnabled(false);
        txtRazao.setEnabled(false);
        txtBairro.setEditable(false);
        txtCidade.setEditable(false);
        txtDataCadastro.setEditable(false);
        txtUF.setEditable(false);
        txtUF.setEnabled(false);
        txtCidade.setEnabled(false);
        txtUF.setEnabled(false);
        txtBairro.setEnabled(false);
        txtEmpresa.setEnabled(false);
        txtCEP.setEnabled(false);
        chkParticular.setSelected(true);

        String dataFormatada;
        String horaFormatada;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatada = sdf.format(new Date());
        txtDataCadastro.setText(dataFormatada);
        txtDataCadastro.setEditable(false);


    }

    public InserirCliente(java.awt.Frame parent, boolean modal, boolean alterar, final Cliente cliente) {
        super(parent, modal);
        initComponents();
        try {
            if (cliente.getStatusEmp().equals("EMPRESA")) {
                if (cliente.getStatus().equals("BLOQUEADO")) {
                    txtBairro.setEditable(false);
                    txtCidade.setEditable(false);
                    txtDataCadastro.setEditable(false);
                    txtUF.setEditable(false);
                    txtEmpresa.setEnabled(false);
                    txtBairro.setEnabled(false);
                    txtCEP.setEnabled(false);
                    txtCelular.setEnabled(false);
                    txtCidade.setEnabled(false);
                    txtDataCadastro.setEnabled(false);
                    txtEmpresa.setEnabled(false);
                    txtEndereco.setEnabled(false);
                    txtNome.setEnabled(false);
                    txtNumero.setEnabled(false);
                    txtObs.setEnabled(false);
                    txtTelefone.setEnabled(false);
                    txtUF.setEnabled(false);
                    chkEmpresa.setEnabled(false);
                    chkParticular.setEnabled(false);
                    btnBairro.setEnabled(false);
                    btnInserirCidade.setEnabled(false);
                    txtCPF.setEnabled(false);
                    txtRG.setEnabled(false);
                    txtNascimento.setEnabled(false);
                    txtEmail.setEnabled(false);
                    txtCNPJ.setEnabled(false);
                    txtIE.setEnabled(false);
                    txtRazao.setEnabled(false);

                } else if (!cliente.getStatus().equals("ATIVO")) {
                    txtBairro.setEditable(true);
                    txtCidade.setEditable(true);
                    txtDataCadastro.setEditable(true);
                    txtUF.setEditable(true);
                    txtEmpresa.setEnabled(true);
                    txtBairro.setEnabled(true);
                    txtCEP.setEnabled(true);
                    txtCelular.setEnabled(true);
                    txtCidade.setEnabled(true);
                    txtDataCadastro.setEnabled(true);
                    txtEmpresa.setEnabled(true);
                    txtEndereco.setEnabled(true);
                    txtNome.setEnabled(true);
                    txtNumero.setEnabled(true);
                    txtObs.setEnabled(true);
                    txtTelefone.setEnabled(true);
                    txtUF.setEnabled(true);
                    chkEmpresa.setEnabled(true);
                    chkParticular.setEnabled(true);
                    btnBairro.setEnabled(true);
                    btnInserirCidade.setEnabled(true);
                    txtEmail.setEnabled(true);
                    txtCNPJ.setEnabled(true);
                    txtIE.setEnabled(true);
                    txtRazao.setEnabled(true);

                }
//            if (cliente.getStatus().equals("BLOQUEADO")) {
//                txtBairro.setEditable(false);
//                txtCidade.setEditable(false);
//                txtDataCadastro.setEditable(false);
//                txtUF.setEditable(false);
//                txtEmpresa.setEnabled(false);
//                txtBairro.setEnabled(false);
//                txtCEP.setEnabled(false);
//                txtCelular.setEnabled(false);
//                txtCidade.setEnabled(false);
//                txtDataCadastro.setEnabled(false);
//                txtEmpresa.setEnabled(false);
//                txtEndereco.setEnabled(false);
//                txtNome.setEnabled(false);
//                txtNumero.setEnabled(false);
//                txtObs.setEnabled(false);
//                txtTelefone.setEnabled(false);
//                txtUF.setEnabled(false);
//                chkEmpresa.setEnabled(false);
//                chkParticular.setEnabled(false);
//                btnBairro.setEnabled(false);
//                btnInserirCidade.setEnabled(false);
//                txtCPF.setEnabled(false);
//                txtRG.setEnabled(false);
//                txtNascimento.setEnabled(false);
//                txtEmail.setEnabled(false);
//                txtCNPJ.setEnabled(false);
//                txtIE.setEnabled(false);
//                txtRazao.setEnabled(false);
//
//            } else if (!cliente.getStatus().equals("ATIVO")) {
//                txtBairro.setEditable(true);
//                txtCidade.setEditable(true);
//                txtDataCadastro.setEditable(true);
//                txtUF.setEditable(true);
//                txtEmpresa.setEnabled(true);
//                txtBairro.setEnabled(true);
//                txtCEP.setEnabled(true);
//                txtCelular.setEnabled(true);
//                txtCidade.setEnabled(true);
//                txtDataCadastro.setEnabled(true);
//                txtEmpresa.setEnabled(true);
//                txtEndereco.setEnabled(true);
//                txtNome.setEnabled(true);
//                txtNumero.setEnabled(true);
//                txtObs.setEnabled(true);
//                txtTelefone.setEnabled(true);
//                txtUF.setEnabled(true);
//                chkEmpresa.setEnabled(true);
//                chkParticular.setEnabled(true);
//                btnBairro.setEnabled(true);
//                btnInserirCidade.setEnabled(true);
//                txtCPF.setEnabled(true);
//                txtRG.setEnabled(true);
//                txtNascimento.setEnabled(true);
//                txtEmail.setEnabled(true);
//                txtCNPJ.setEnabled(true);
//                txtIE.setEnabled(true);
//                txtRazao.setEnabled(true);
//            }
            }
        } catch (Exception e) {
        }
        this.alterar = alterar;
        if (alterar) {
            this.cliente = cliente;
            try {

                if (cliente.getStatusEmp().equals("EMPRESA")) {
                    chkEmpresa.setSelected(true);
                    chkParticular.setSelected(false);
                    txtEmpresa.setEnabled(true);
                    txtCPF.setEnabled(false);
                    txtRG.setEnabled(false);
                    txtDataCadastro.setEnabled(false);
                    txtCNPJ.setEnabled(true);
                    txtIE.setEnabled(true);
                    txtRazao.setEnabled(true);
                    txtCPF.setText("");
                    txtRG.setText("");
                    txtNascimento.setText("");
                    txtNascimento.setEnabled(false);
                    txtCNPJ.grabFocus();
                    txtNascimento.setText("  /  /    ");
                    txtNome.selectAll();
                    txtNome.grabFocus();

                }
                if (cliente.getStatusEmp().equals("PARTICULAR")) {
                    chkParticular.setSelected(true);
                    chkEmpresa.setSelected(false);
                    txtEmpresa.setEnabled(false);
                    txtCNPJ.setEnabled(false);
                    txtIE.setEnabled(false);
                    txtCPF.setEnabled(true);
                    txtRG.setEnabled(true);
                    txtNascimento.setEnabled(true);
                    txtRazao.setEnabled(false);
                    txtCNPJ.setText("");
                    txtIE.setText("");
                    txtRazao.setText("");
                    txtCPF.grabFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "DISGRAMA");
            }
            txtNome.setText(cliente.getNome());
            txtEmpresa.setText(cliente.getEmpresa());
            txtBairro.setText(cliente.getBairro());
            txtCEP.setText(cliente.getCep());
            txtCelular.setText(cliente.getCelular());
            txtCNPJ.setText(cliente.getCnpj());
            txtIE.setText(cliente.getIe());
            txtRG.setText(cliente.getRg());
            txtCPF.setText(cliente.getCpf());
            txtRazao.setText(cliente.getRazao());
            txtEmail.setText(cliente.getEmail());
            try {
                String dataFormatada;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dataFormatada = sdf.format(cliente.getDataNascimento());
                txtNascimento.setText(dataFormatada.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            try {
                String dataFormatada;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dataFormatada = sdf.format(cliente.getDataCadastro());
                txtDataCadastro.setText(dataFormatada.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            txtEndereco.setText(cliente.getEndereco());
            txtNumero.setText(cliente.getNumero());
            txtObs.setText(cliente.getObs());
            txtTelefone.setText(cliente.getTelefone());
            txtCidade.setText(cliente.getCidade());
            txtUF.setText(cliente.getUf());
            try {
                if (cliente.getStatus().equals("BLOQUEADO")) {
                    chkBloqueado.setSelected(true);
                } else if (cliente.getStatus().equals("ATIVO")) {
                    chkBloqueado.setSelected(false);
                }
            } catch (Exception e) {
            }
            try {
                if (cliente.getTipo().equals("PARTICULAR")) {
                    chkParticular.setSelected(true);
                } else if (cliente.getTipo().equals("EMPRESA")) {
                    chkEmpresa.setSelected(true);
                }
            } catch (Exception e) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chkParticular = new javax.swing.JCheckBox();
        chkEmpresa = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JEditorPane();
        jLabel12 = new javax.swing.JLabel();
        txtDataCadastro = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        chkBloqueado = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        btnBairro = new javax.swing.JButton();
        txtCidade = new javax.swing.JTextField();
        txtUF = new javax.swing.JTextField();
        btnInserirCidade = new javax.swing.JButton();
        txtCEP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Cadastro de Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Inserir Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("Celular");

        jLabel3.setText("Tipo:");

        chkParticular.setText("Particular");
        chkParticular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkParticularActionPerformed(evt);
            }
        });

        chkEmpresa.setText("Empresa");
        chkEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEmpresaActionPerformed(evt);
            }
        });

        jLabel4.setText("Fantasia:");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyReleased(evt);
            }
        });

        jLabel5.setText("Telefone Fixo:");

        jLabel6.setText("Endereço:");

        jLabel7.setText("UF:");

        jLabel8.setText("Cidade:");

        jLabel9.setText("CEP:");

        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyReleased(evt);
            }
        });

        jLabel10.setText("Bairro:");

        txtBairro.setText("Clique no botão ao lado para selecionar um Bairro!!");
        txtBairro.setFocusable(false);

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setText("Obs:");

        txtObs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtObs);

        jLabel12.setText("Data Cadastro:");

        txtDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtDataCadastro.setFocusable(false);

        jLabel13.setText("Status:");

        chkBloqueado.setText("Bloqueado");
        chkBloqueado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBloqueadoActionPerformed(evt);
            }
        });

        jLabel14.setText("Nº:");

        btnBairro.setText("...");
        btnBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBairroActionPerformed(evt);
            }
        });

        txtCidade.setText("Clique no botão ao lado para selecionar uma Cidade!");
        txtCidade.setFocusable(false);
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        btnInserirCidade.setText("...");
        btnInserirCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirCidadeActionPerformed(evt);
            }
        });

        jLabel15.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel16.setText("RG:");

        jLabel17.setText("Data Nascimento:");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel18.setText("CNPJ:");

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel19.setText("I.E.:");

        jLabel20.setText("Razão:");

        jLabel21.setText("E-MAIL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addComponent(txtCNPJ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtRazao)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chkParticular, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(chkEmpresa))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmpresa))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtBairro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBairro))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnInserirCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkBloqueado)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndereco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chkParticular)
                    .addComponent(chkEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserirCidade)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(chkBloqueado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1323972017_fechar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1324324710_registro.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBairroActionPerformed
        frmBairro j = new frmBairro(null, true);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        CodBairro = j.getCodigoRetorno();

        BairroDAO bairroDAO = new BairroDAO();
        txtBairro.setText(bairroDAO.getBairroByCodigo(CodBairro).getDescricao());
        txtBairro.setEnabled(true);

    }//GEN-LAST:event_btnBairroActionPerformed

    private void chkParticularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkParticularActionPerformed
        try {
            if (chkParticular.isSelected()) {
                chkEmpresa.setSelected(false);
                txtEmpresa.setEnabled(false);
                txtCNPJ.setEnabled(false);
                txtIE.setEnabled(false);
                txtCPF.setEnabled(true);
                txtRG.setEnabled(true);
                txtNascimento.setEnabled(true);
                txtRazao.setEnabled(false);
                txtCNPJ.setText("");
                txtIE.setText("");
                txtRazao.setText("");
                txtCPF.grabFocus();
            } else if (!chkParticular.isSelected() || !chkEmpresa.isSelected()) {
                chkParticular.setSelected(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_chkParticularActionPerformed

    private void chkEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEmpresaActionPerformed
        try {
            if (chkEmpresa.isSelected()) {
                chkParticular.setSelected(false);
                txtEmpresa.setEnabled(true);
                txtCPF.setEnabled(false);
                txtRG.setEnabled(false);
                txtDataCadastro.setEnabled(false);
                txtCNPJ.setEnabled(true);
                txtIE.setEnabled(true);
                txtRazao.setEnabled(true);
                txtCPF.setText("");
                txtRG.setText("");
                txtNascimento.setText("");
                txtNascimento.setEnabled(false);
                txtCNPJ.grabFocus();
                txtNascimento.setText("  /  /    ");
            } else if (!chkEmpresa.isSelected() || !chkParticular.isSelected()) {
                txtEmpresa.setEnabled(false);
                chkParticular.setSelected(true);
                txtEmpresa.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_chkEmpresaActionPerformed

    private void btnInserirCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirCidadeActionPerformed
        frmCidades j = new frmCidades(null, true);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        CodCidade = j.getCodigoRetorno();

        CidadeDAO cidadeDAO = new CidadeDAO();
        txtCidade.setText(cidadeDAO.getCidadeByCodigo(CodCidade).getDescricao());
        txtUF.setText(cidadeDAO.getCidadeByCodigo(CodCidade).getUf());
        txtCEP.setText(cidadeDAO.getCidadeByCodigo(CodCidade).getCep());
        txtCidade.setEnabled(true);
        txtUF.setEnabled(true);
        txtCEP.setEnabled(true);

    }//GEN-LAST:event_btnInserirCidadeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!alterar) {
            cliente = new Cliente();
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        cliente.setNome(txtNome.getText());
        cliente.setEmpresa(txtEmpresa.getText());
        cliente.setCelular(txtCelular.getText());
        cliente.setTelefone(txtTelefone.getText());
        cliente.setBairro(txtBairro.getText());
        cliente.setCep(txtCEP.getText());
        cliente.setCidade(txtCidade.getText());
        cliente.setCnpj(txtCNPJ.getText());
        cliente.setIe(txtIE.getText());
        cliente.setRazao(txtRazao.getText());
        cliente.setCpf(txtCPF.getText());
        cliente.setRg(txtRG.getText());
        cliente.setEmail(txtEmail.getText());
        try {
            if (!txtCNPJ.getText().equals("  .   .   /    -  ")) {
                cliente.setStatusEmp("EMPRESA");
            } else {
                cliente.setStatusEmp("PARTICULAR");
            }
        } catch (Exception e) {
        }
        try {
            cliente.setDataNascimento(format.parse(txtNascimento.getText()));
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            cliente.setDataCadastro(format.parse(txtDataCadastro.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        cliente.setEndereco(txtEndereco.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.setObs(txtObs.getText());
        cliente.setUf(txtUF.getText());
        try {
            if (chkBloqueado.isSelected()) {
                cliente.setStatus("BLOQUEADO");
            } else {
                cliente.setStatus("ATIVO");
            }
        } catch (Exception e) {
        }
        boolean retorno = false;
        if (!alterar) {
            retorno = clienteDAO.gravar(cliente);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Cadastro do cliente salvo com Sucesso!!");
                this.dispose();
            }
        } else {
            retorno = clienteDAO.gravar(cliente);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Cadastro do cliente alterado com sucesso!!");
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void chkBloqueadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBloqueadoActionPerformed

        if (cliente.getStatusEmp().equals("EMPRESA")) {
            if (chkBloqueado.isSelected()) {
                txtBairro.setEditable(false);
                txtCidade.setEditable(false);
                txtDataCadastro.setEditable(false);
                txtUF.setEditable(false);
                txtEmpresa.setEnabled(false);
                txtBairro.setEnabled(false);
                txtCEP.setEnabled(false);
                txtCelular.setEnabled(false);
                txtCidade.setEnabled(false);
                txtDataCadastro.setEnabled(false);
                txtEmpresa.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtNome.setEnabled(false);
                txtNumero.setEnabled(false);
                txtObs.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtUF.setEnabled(false);
                chkEmpresa.setEnabled(false);
                chkParticular.setEnabled(false);
                btnBairro.setEnabled(false);
                btnInserirCidade.setEnabled(false);
                txtCPF.setEnabled(false);
                txtRG.setEnabled(false);
                txtNascimento.setEnabled(false);
                txtEmail.setEnabled(false);
                txtCNPJ.setEnabled(false);
                txtIE.setEnabled(false);
                txtRazao.setEnabled(false);
            } else if (!chkBloqueado.isSelected()) {
                txtBairro.setEditable(false);
                txtCidade.setEditable(false);
                txtDataCadastro.setEditable(false);
                txtUF.setEditable(false);
                txtEmpresa.setEnabled(true);
                txtBairro.setEnabled(true);
                txtCEP.setEnabled(true);
                txtCelular.setEnabled(true);
                txtCidade.setEnabled(true);
                txtDataCadastro.setEnabled(true);
                txtEmpresa.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtNome.setEnabled(true);
                txtNumero.setEnabled(true);
                txtObs.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtUF.setEnabled(true);
                btnBairro.setEnabled(true);
                btnInserirCidade.setEnabled(true);
                chkEmpresa.setEnabled(true);
                chkParticular.setEnabled(true);
                txtEmail.setEnabled(true);
                txtCNPJ.setEnabled(true);
                txtIE.setEnabled(true);
                txtRazao.setEnabled(true);
            }
        }
        if (cliente.getStatusEmp().equals("EMPRESA")) {
            if (chkBloqueado.isSelected()) {
                txtBairro.setEditable(false);
                txtCidade.setEditable(false);
                txtDataCadastro.setEditable(false);
                txtUF.setEditable(false);
                txtEmpresa.setEnabled(false);
                txtBairro.setEnabled(false);
                txtCEP.setEnabled(false);
                txtCelular.setEnabled(false);
                txtCidade.setEnabled(false);
                txtDataCadastro.setEnabled(false);
                txtEmpresa.setEnabled(false);
                txtEndereco.setEnabled(false);
                txtNome.setEnabled(false);
                txtNumero.setEnabled(false);
                txtObs.setEnabled(false);
                txtTelefone.setEnabled(false);
                txtUF.setEnabled(false);
                chkEmpresa.setEnabled(false);
                chkParticular.setEnabled(false);
                btnBairro.setEnabled(false);
                btnInserirCidade.setEnabled(false);
                txtCPF.setEnabled(false);
                txtRG.setEnabled(false);
                txtNascimento.setEnabled(false);
                txtEmail.setEnabled(false);
                txtCNPJ.setEnabled(false);
                txtIE.setEnabled(false);
                txtRazao.setEnabled(false);
            } else if (!chkBloqueado.isSelected()) {
                txtBairro.setEditable(false);
                txtCidade.setEditable(false);
                txtDataCadastro.setEditable(false);
                txtUF.setEditable(false);
                txtEmpresa.setEnabled(true);
                txtBairro.setEnabled(true);
                txtCEP.setEnabled(true);
                txtCelular.setEnabled(true);
                txtCidade.setEnabled(true);
                txtDataCadastro.setEnabled(true);
                txtEmpresa.setEnabled(true);
                txtEndereco.setEnabled(true);
                txtNome.setEnabled(true);
                txtNumero.setEnabled(true);
                txtObs.setEnabled(true);
                txtTelefone.setEnabled(true);
                txtUF.setEnabled(true);
                btnBairro.setEnabled(true);
                btnInserirCidade.setEnabled(true);
                chkEmpresa.setEnabled(true);
                chkParticular.setEnabled(true);
                txtEmail.setEnabled(true);
                txtCPF.setEnabled(false);
                txtRG.setEnabled(false);
                txtNascimento.setEnabled(false);
            }
        }

    }//GEN-LAST:event_chkBloqueadoActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        JTextField tf = (JTextField) evt.getComponent();
        if (evt.getKeyCode() != 32 & evt.getKeyCode() != 8 & evt.getKeyCode() != 37 & evt.getKeyCode() != 39) {
            tf.setText(tf.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyReleased
        JTextField tf = (JTextField) evt.getComponent();
        if (evt.getKeyCode() != 32 & evt.getKeyCode() != 8 & evt.getKeyCode() != 37 & evt.getKeyCode() != 39) {
            tf.setText(tf.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtEmpresaKeyReleased

    private void txtEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyReleased
        JTextField tf = (JTextField) evt.getComponent();
        if (evt.getKeyCode() != 32 & evt.getKeyCode() != 8 & evt.getKeyCode() != 37 & evt.getKeyCode() != 39) {
            tf.setText(tf.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtEnderecoKeyReleased

    private void txtObsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsKeyReleased
        JTextField tf = (JTextField) evt.getComponent();
        if (evt.getKeyCode() != 32 & evt.getKeyCode() != 8 & evt.getKeyCode() != 37 & evt.getKeyCode() != 39) {
            tf.setText(tf.getText().toUpperCase());
        }
    }//GEN-LAST:event_txtObsKeyReleased

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
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                InserirCliente dialog = new InserirCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBairro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserirCidade;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkBloqueado;
    private javax.swing.JCheckBox chkEmpresa;
    private javax.swing.JCheckBox chkParticular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIE;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JEditorPane txtObs;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
