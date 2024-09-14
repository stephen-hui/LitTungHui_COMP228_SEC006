package lab1;

import java.time.LocalDate;

public class exercise1 {
    public static void main(String[] args) {
        Singers singer = new Singers();
        System.out.println("ID: " + singer.getId());
        System.out.println("Name: " + singer.getName());
        System.out.println("Address: " + singer.getAddress());
        System.out.println("Date of Birth: " + singer.getDateOfBirth());
        System.out.println("Number of albums published: " + singer.getNumOfAlbums());

        singer.setId(1);
        singer.setName("Taylor Swift");
        singer.setAddress("San Francisco, CA");
        singer.setDateOfBirth(LocalDate.of(1989, 12, 13));
        singer.setNumOfAlbums(5);
        System.out.println("-----------------------------------");
        System.out.println("ID: " + singer.getId());
        System.out.println("Name: " + singer.getName());
        System.out.println("Address: " + singer.getAddress());
        System.out.println("Date of Birth: " + singer.getDateOfBirth());
        System.out.println("Number of albums published: " + singer.getNumOfAlbums());

    }
}