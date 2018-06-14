/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Jackson
 */
public class CidadeTableModel implements TableModel{

    
    List<Cidade> cidades;

    public CidadeTableModel(List<Cidade> cidades) {
        this.cidades = cidades;
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
        return cidades.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Código";
            case 1:
                return "Descrição";
            case 2:
                return "UF";
            case 3:
                return "CEP";
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
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        } else {
            return false;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidade cidade = cidades.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cidade.getCodigo();
            case 1:
                return cidade.getDescricao();
            case 2:
                return cidade.getUf();
            case 3:
                return cidade.getCep();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String dados = aValue.toString();
        Cidade cidade = cidades.get(rowIndex);

        switch (columnIndex) {
            case 1:
                cidade.setDescricao(dados);
            case 2:
                cidade.setUf(dados);
            case 3:
                cidade.setCep(dados);
        }

        cidades.set(rowIndex, cidade);
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
