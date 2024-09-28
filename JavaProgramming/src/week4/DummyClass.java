package week4;

import lab1.Singers;

import java.time.LocalDateTime;


public class DummyClass {
    public static void getTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    public static void main(String[] args) {
        final Day day = Day.MONDAY;
        Singers s1 = new Singers();
        getTime();

        switch (day){
            case MONDAY: case TUESDAY:
                System.out.println("MON " + day);
             default:
                System.out.println("default ");
        }

        System.out.println(Day.MONDAY);
        System.out.println(Day.TUESDAY);
    }
}


