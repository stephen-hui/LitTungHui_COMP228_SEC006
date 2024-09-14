package lab1;
import java.time.LocalDate;

public class Singers {
    private int id;
    private String name;
    private String address;
    private LocalDate dateOfBirth;
    private int numOfAlbums;

    public Singers(){}
    public Singers(int id){
        this.id = id;
    }
    public Singers(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Singers(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public Singers(int id, String name, String address, LocalDate dateOfBirth){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
    public Singers(int id, String name, String address, LocalDate dateOfBirth, int numOfAlbums){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numOfAlbums = numOfAlbums;
    }

    public void setAll(int id, String name, String address, LocalDate dateOfBirth, int numOfAlbums){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numOfAlbums = numOfAlbums;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setNumOfAlbums(int numOfAlbums){
        this.numOfAlbums = numOfAlbums;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public int getNumOfAlbums(){
        return numOfAlbums;
    }

}
