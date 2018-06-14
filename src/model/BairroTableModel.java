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
public class BairroTableModel implements TableModel {

    List<Bairro> bairros;

    public BairroTableModel(List<Bairro> bairros) {
        this.bairros = bairros;
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
        return bairros.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Descrição";          
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
        Bairro bairro = bairros.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        switch (columnIndex) {
            case 0:
                return bairro.getCodigo();
            case 1:
                return (bairro.getDescricao());         
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String dados = aValue.toString();

        Bairro bairro = bairros.get(rowIndex);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        switch (columnIndex) {
            case 1:
                bairro.setDescricao(dados);
        }

        bairros.set(rowIndex, bairro);
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

    

