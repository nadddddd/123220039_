/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdatabuku.DataBukuDAO;
import DAOImplement.DataBukuImplement;
import model.*;
import view.MainView;
/**
 *
 * @author lenovo
 */
public class DataBukuController {
    MainView frame;
    DataBukuImplement impldatabuku;
    List<DataBuku> db;
    
    public DataBukuController(MainView frame){
        this.frame = frame;
        impldatabuku = new DataBukuDAO();
        db = impldatabuku.getAll();
    }
    
    public void isitabel(){
        db = impldatabuku.getAll();
        ModelTabelDataBuku mb = new ModelTabelDataBuku(db);
        frame.getTabelDatabuku().setModel(mb);
    }
    
    public void insert(){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getjTxtjudul().getText());
        db.setGenre(frame.getjTxtgenre().getText());
        db.setPenulis(frame.getjTxtpenulis().getText());
        db.setPenerbit(frame.getjTxtpenerbit().getText());
        db.setLokasi(frame.getjTxtlokasi().getText());
        db.setStock(Integer.parseInt(frame.getjTxtstock().getText()));
        impldatabuku.insert(db);
    }
    
     public void update(){
        DataBuku db = new DataBuku();
        db.setJudul(frame.getjTxtjudul().getText());
        db.setGenre(frame.getjTxtgenre().getText());
        db.setPenulis(frame.getjTxtpenulis().getText());
        db.setPenerbit(frame.getjTxtpenerbit().getText());
        db.setLokasi(frame.getjTxtlokasi().getText());
        db.setStock(Integer.parseInt(frame.getjTxtstock().getText()));
        db.setId(Integer.parseInt(frame.getjTxtid().getText()));
        impldatabuku.update(db);
    }
     
     public void delete(){
         int id = Integer.parseInt(frame.getjTxtid().getText());
         impldatabuku.delete(id);
     }
     
     public void searchGenre(){
         String genre = frame.getListgenre().getSelectedItem().toString();
         db = impldatabuku.getBookByGenre(genre);
         ModelTabelDataBuku mb = new ModelTabelDataBuku(db);
         frame.getTabelDatabuku().setModel(mb);
     }
     
     public void isiGenre(){
         frame.getListgenre().removeAllItems();// mengkosongkan list pada comoBox
         List<String> genreList = impldatabuku.getGenre();
         for(String genre : genreList) {
             frame.getListgenre().addItem(genre); // Mengisi comboBox dengan daftar genre
        }
     }
     
     public void search(){
         String by = frame.getSearchBy().getSelectedItem().toString();
         by = by.toLowerCase();
         String text = frame.getjTextsearch().getText();
         db = impldatabuku.search(by , text);
         ModelTabelDataBuku mb = new ModelTabelDataBuku(db);
         frame.getTabelDatabuku().setModel(mb);
     };
}
