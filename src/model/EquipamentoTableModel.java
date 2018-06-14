/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author DC CENTER PAES
 */
public class EquipamentoTableModel implements TableModel {

    List<Equipamento> equipamentos;

    public EquipamentoTableModel(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
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
        return equipamentos.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Descrição";
            case 2:
                return "Cliente";
            case 3:
                return "Tipo";
            case 4:
                return "NSerie";
            case 5:
                return "Status Equipamento";
            case 6:
                return "Status";

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
                return String.class;
            case 6:
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
        Equipamento equipamento = equipamentos.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        switch (columnIndex) {
            case 0:
                return equipamento.getCodigo();
            case 1:
                return (equipamento.getDescricao());
            case 2:
                return equipamento.getCliente();
            case 3:
                return equipamento.getTipo();
            case 4:
                return equipamento.getNserie();
            case 5:
                return equipamento.getStatusEquipamento();
            case 6:
                return equipamento.getStatus();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String dados = aValue.toString();

        Equipamento equipamento = equipamentos.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 1:
                equipamento.setDescricao(dados);
        }

        equipamentos.set(rowIndex, equipamento);
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
