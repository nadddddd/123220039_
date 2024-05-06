/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author lenovo
 */
public class ModelTabelDataBuku extends AbstractTableModel{
    
    List<DataBuku> db;
     public ModelTabelDataBuku(List<DataBuku> db) {
        this.db = db;
    }
 
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "id";
            case 1:
                return "judul";
            case 2:
                return "genre";
            case 3:
                return "penulis";
            case 4:
                return "penerbit";
            case 5:
                return "lokasi";
            case 6:
                return "stock";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
       switch(column){
            case 0:
                return db.get(row).getId();
            case 1:
                return db.get(row).getJudul();
            case 2:
                return db.get(row).getGenre();
            case 3:
                return db.get(row).getPenulis();
            case 4:
                return db.get(row).getPenerbit();
            case 5:
                return db.get(row).getLokasi();
            case 6:
                return db.get(row).getStock();
            default:
                return null;
        }
    }
    
}
