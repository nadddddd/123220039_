/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatabuku;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import DAOImplement.DataBukuImplement;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lenovo
 */
public class DataBukuDAO implements DataBukuImplement{
    Connection connection;
    
    final String select = "SELECT * FROM `dataperpus`";
    final String genre = "SELECT DISTINCT genre FROM dataperpus ORDER BY genre ASC";
    final String searchByGenre = "SELECT * FROM dataperpus WHERE genre=?";
    final String insert = "INSERT INTO dataperpus(judul, genre, penulis, penerbit, lokasi, stock) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    final String delete = "delete from dataperpus where id=?";
    
    public DataBukuDAO() {
        connection = Connector.connection();
    }

    @Override
    public void insert(DataBuku p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataBuku p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(6, p.getStock());
            statement.setInt(7, p.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataBuku> getAll() {
        List<DataBuku> db = null;
        try{
            db = new ArrayList<DataBuku>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setGenre(rs.getString("genre"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setLokasi(rs.getString("lokasi"));
                buku.setStock(rs.getInt("stock"));
                db.add(buku);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataBukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return db;
        
    }
    
    public List<DataBuku> getBookByGenre(String genre){
        PreparedStatement statement = null;
        List<DataBuku> db = null;
        try{
            db = new ArrayList<DataBuku>();
            statement = connection.prepareStatement(searchByGenre);
            statement.setString(1, genre);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setGenre(rs.getString("genre"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setLokasi(rs.getString("lokasi"));
                buku.setStock(rs.getInt("stock"));
                db.add(buku);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataBukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return db;  
    };
    
    @Override
    public List<String> getGenre(){
        PreparedStatement statement = null;
        List<String> genreList = new ArrayList<String>();
        genreList.add("-");
        try{
            statement = connection.prepareStatement(genre);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                genreList.add(rs.getString("genre"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return genreList;
    }

    @Override
    public List<DataBuku> search(String by, String text) {
        String search = "SELECT * FROM dataperpus WHERE "+by+" LIKE ?";
        PreparedStatement statement = null;
        List<DataBuku> dbs = null;
        
        try{
            dbs = new ArrayList<DataBuku>();
            statement = connection.prepareStatement(search);
            statement.setString(1, "%"+text+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DataBuku buku = new DataBuku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setGenre(rs.getString("genre"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setLokasi(rs.getString("lokasi"));
                buku.setStock(rs.getInt("stock"));
                dbs.add(buku);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataBukuDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        return dbs;
    }

}
