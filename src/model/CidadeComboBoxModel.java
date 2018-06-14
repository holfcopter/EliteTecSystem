/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Jackson
 */
public class CidadeComboBoxModel implements ComboBoxModel{

    private List<Cidade> cidades;
    private Cidade cidadeSelecionada;


    public CidadeComboBoxModel(List<Cidade> cidades){
        this.cidades=cidades;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        cidadeSelecionada=(Cidade)anItem;
    }

    @Override
    public Object getSelectedItem() {
       return cidadeSelecionada;
    }

    @Override
    public int getSize() {
        return cidades.size();
    }

    @Override
    public Object getElementAt(int index) {
        return cidades.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
        cidades.clear();
    }

}

