/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatabuku.databukuDAO;
import DAOImplement.databukuimplement;
import model.*;
import view.MainView;
/**
 *
 * @author arap
 */
public class databukucontroller {
    MainView frame;
    databukuimplement impldatabuku;
    List<databuku> dabuk;
    
    public databukucontroller(MainView frame){
        this.frame = frame;
        impldatabuku = new databukuDAO();
        dabuk = impldatabuku.getAll();
    }
    public void isitabel(){
        dabuk = impldatabuku.getAll();
        modeltabeldatabuku mp = new modeltabeldatabuku(dabuk);
        frame.getTabelDatabuku().setModel(mp);
    }
    
    public void insert(){
        databuku dabuk = new databuku();
        dabuk.setJudul(frame.getJTxtjudul().getText());
        dabuk.setGenre(frame.getJtxtgenre().getText());
        dabuk.setPenulis(frame.getJtxtpenulis().getText());
        dabuk.setPenerbit(frame.getJtxtpenerbit().getText());
        dabuk.setLokasi(frame.getJtxtlokasi().getText());
        dabuk.setStock(frame.getJtxtstock().getText());
        impldatabuku.insert(dabuk);
        
    }
    
    public void update(){
        databuku dabuk = new databuku();
        dabuk.setJudul(frame.getJTxtjudul().getText());
        dabuk.setGenre(frame.getJtxtgenre().getText());
        dabuk.setPenulis(frame.getJtxtpenulis().getText());
        dabuk.setPenerbit(frame.getJtxtpenerbit().getText());
        dabuk.setLokasi(frame.getJtxtlokasi().getText());
        dabuk.setStock(frame.getJtxtstock().getText());
        dabuk.setId(Integer.parseInt(frame.getJTxtid().getText()));
        impldatabuku.update(dabuk);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impldatabuku.delete(id);
    }
    
    public void cari(String keyword, String category) {
    List<databuku> datasearch = new ArrayList<>();
    List<databuku> allData = impldatabuku.getAll();

    for (databuku buku : allData) {
        if (category.equalsIgnoreCase("Judul")) {
            if (buku.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Genre")) {
            if (buku.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penulis")) {
            if (buku.getPenulis().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        } else if (category.equalsIgnoreCase("Penerbit")) {
            if (buku.getPenerbit().toLowerCase().contains(keyword.toLowerCase())) {
                datasearch.add(buku);
            }
        }
    }
    modeltabeldatabuku model = new modeltabeldatabuku(datasearch);
    frame.getTabelDatabuku().setModel(model);
}

}
