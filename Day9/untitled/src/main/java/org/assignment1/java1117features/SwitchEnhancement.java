package org.assignment1.java1117features;

public class SwitchEnhancement {
    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    public static void main(String[] args) {
        WeekDay day = WeekDay.TUESDAY;
        switch (day) {
            case MONDAY -> System.out.println("It's Monday");
            case TUESDAY -> System.out.println("It's Tuesday");
            case WEDNESDAY -> System.out.println("It's Wednesday");
            case THURSDAY -> System.out.println("It's Thursday");
            case FRIDAY -> System.out.println("It's Friday");
            case SATURDAY -> System.out.println("It's Saturday");
            case SUNDAY -> System.out.println("It's Sunday");
            default -> System.out.println("It's not a day");
        }

    }






}


