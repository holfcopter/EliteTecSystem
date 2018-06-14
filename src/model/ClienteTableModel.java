/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DC CENTER PAES
 */
public class ClienteTableModel implements TableModel {

    List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
        MouseAdapter mouseAdapter = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // e por aqui dá para saber a coluna
                //int colIndex = table.getColumnModel().getColumnIndexAtX(getColumnCount())
            }
        };

        this.addTableModelListener(mouseAdapter);
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 21;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Nome";
            case 2:
                return "Nome Fantasia";
            case 3:
                return "Razão Social";
            case 4:
                return "Status";
            case 5:
                return "Data Cadastro";
            case 6:
                return "Endereço";
            case 7:
                return "Nº";
            case 8:
                return "Bairro";
            case 9:
                return "Cidade";
            case 10:
                return "UF";
            case 11:
                return "CEP";
            case 12:
                return "Telefone";
            case 13:
                return "Celular";
            case 14:
                return "CPF";
            case 15:
                return "RG";
            case 16:
                return "CNPJ";
            case 17:
                return "IE";
            case 18:
                return "Email";
            case 19:
                return "Data nascimento";
            case 20:
                return "Observação";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Date.class;
            case 6:
                return String.class;
            case 7:
                return String.class;
            case 8:
                return String.class;
            case 9:
                return String.class;
            case 10:
                return String.class;
            case 11:
                return String.class;
            case 12:
                return String.class;
            case 13:
                return String.class;
            case 14:
                return String.class;
            case 15:
                return String.class;
            case 16:
                return String.class;
            case 17:
                return String.class;
            case 18:
                return String.class;
            case 19:
                return Date.class;
            case 20:
                return String.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public boolean columnSelectionAllowed() {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        switch (columnIndex) {
            case 0:
                return cliente.getCodigo();
            case 1:
                return (cliente.getNome());
            case 2:
                return (cliente.getEmpresa());
            case 3:
                return (cliente.getRazao());
            case 4:
                return (cliente.getStatus());
            case 5:
                return (cliente.getDataCadastro());
            case 6:
                return (cliente.getEndereco());
            case 7:
                return (cliente.getNumero());
            case 8:
                return (cliente.getBairro());
            case 9:
                return (cliente.getCidade());
            case 10:
                return (cliente.getUf());
            case 11:
                return (cliente.getCep());
            case 12:
                return (cliente.getTelefone());
            case 13:
                return (cliente.getCelular());
            case 14:
                return (cliente.getCpf());
            case 15:
                return (cliente.getRg());
            case 16:
                return (cliente.getCnpj());
            case 17:
                return (cliente.getIe());
            case 18:
                return (cliente.getEmail());
            case 19:
                return (cliente.getDataNascimento());
            case 20:
                return (cliente.getObs());
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String dados = aValue.toString();

        Cliente cliente = clientes.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 1:
                cliente.setNome(dados);
            case 2:
                cliente.setEmpresa(dados);
            case 3:
                cliente.setTipo(dados);
            case 4:
                cliente.setStatus(dados);
            case 5:
                try {
                    cliente.setDataCadastro(format.parse(dados));
                } catch (ParseException ex) {
                }
            case 6:
                cliente.setEndereco(dados);
            case 7:
                cliente.setNumero(dados);
            case 8:
                cliente.setBairro(dados);
            case 9:
                cliente.setCidade(dados);
            case 10:
                cliente.setUf(dados);
            case 11:
                cliente.setCep(dados);
            case 12:
                cliente.setTelefone(dados);
            case 13:
                cliente.setCelular(dados);
            case 14:
                cliente.setCpf(dados);
            case 15:
                cliente.setRg(dados);
            case 16:
                cliente.setCnpj(dados);
            case 17:
                cliente.setIe(dados);
            case 18:
                cliente.setEmail(dados);
            case 19:
                try {
                    cliente.setDataNascimento(format.parse(dados));
                } catch (ParseException ex) {
                }
            case 20:
                cliente.setObs(dados);
        }

        clientes.set(rowIndex, cliente);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    private void addTableModelListener(MouseAdapter mouseAdapter) {
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
