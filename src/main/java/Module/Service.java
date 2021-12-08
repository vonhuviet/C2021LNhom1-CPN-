/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Service {
    int IdService;
    String NameService;
    int PriceService;
    String Note;

    public Service() {
    }

    public Service(int IdService, String NameService, int PriceService, String Note) {
        this.IdService = IdService;
        this.NameService = NameService;
        this.PriceService = PriceService;
        this.Note = Note;
    }

    public Service(String NameService, int PriceService, String Note) {
        this.NameService = NameService;
        this.PriceService = PriceService;
        this.Note = Note;
    }
    

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int IdService) {
        this.IdService = IdService;
    }

    public Service(int IdService, String NameService) {
        this.IdService = IdService;
        this.NameService = NameService;
    }


    public String getNameService() {
        return NameService;
    }

    public void setNameService(String NameService) {
        this.NameService = NameService;
    }

    public int getPriceService() {
        return PriceService;
    }

    public void setPriceService(int PriceService) {
        this.PriceService = PriceService;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return NameService;
    }
    
    
}
