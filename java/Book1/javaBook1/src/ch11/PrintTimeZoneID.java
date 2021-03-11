package ch11;

import java.util.TimeZone;

public class PrintTimeZoneID {
    public static void main(String[] args){
        String[] availablesIDs = TimeZone.getAvailableIDs();
        for(String id: availablesIDs){
            System.out.println(id);
        }
    }
}
