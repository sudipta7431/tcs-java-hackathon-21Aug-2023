import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Scanner;

class Satellite {
    private int satelliteId;
    private String satelliteName;
    private String country;
    private int boostersCountUsed;
    private String purpose;
    private int expense;

    public Satellite(int satelliteId, String satelliteName, String country, int boostersCountUsed, String purpose, int expense) {
        this.satelliteId = satelliteId;
        this.satelliteName = satelliteName;
        this.country = country;
        this.boostersCountUsed = boostersCountUsed;
        this.purpose = purpose;
        this.expense = expense;
    }

    public int getSatelliteId() {
        return satelliteId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public String getCountry() {
        return country;
    }

    public int getBoostersCountUsed() {
        return boostersCountUsed;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getExpense() {
        return expense;
    }
}

public class MyClass {
    public static Satellite getSatelliteWithHighestExpense(Satellite[] satellites, String purpose) {
        Satellite highestExpenseSatellite = null;
        int maxExpense = -1;

        for (Satellite satellite : satellites) {
            if (satellite.getPurpose().equalsIgnoreCase(purpose) && satellite.getExpense() > maxExpense) {
                highestExpenseSatellite = satellite;
                maxExpense = satellite.getExpense();
            }
        }

        return highestExpenseSatellite;
    }

    public static int getSatelliteBasedOnGivenCountry(Satellite[] satellites, String country, int minBoostersCount) {
        for (Satellite satellite : satellites) {
            if (satellite.getCountry().equalsIgnoreCase(country) && satellite.getBoostersCountUsed() > minBoostersCount) {
                return satellite.getSatelliteId();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Satellite[] satellites = new Satellite[4];

        for (int i = 0; i < 4; i++) {
            int satelliteId = scanner.nextInt();
            String satelliteName = scanner.next();
            String country = scanner.next();
            int boostersCountUsed = scanner.nextInt();
            String purpose = scanner.next();
            int expense = scanner.nextInt();

            satellites[i] = new Satellite(satelliteId, satelliteName, country, boostersCountUsed, purpose, expense);
        }

        String purpose = scanner.next();
        int minBoostersCount = scanner.nextInt();
        String country = scanner.next();

        Satellite highestExpenseSatellite = getSatelliteWithHighestExpense(satellites, purpose);
        if (highestExpenseSatellite != null) {
            System.out.println(highestExpenseSatellite.getSatelliteId());
            System.out.println(highestExpenseSatellite.getSatelliteName());
            System.out.println(highestExpenseSatellite.getCountry());
        } else {
            System.out.println("No such Satellite");
        }

        int satelliteIdForCountry = getSatelliteBasedOnGivenCountry(satellites, country, minBoostersCount);
        if (satelliteIdForCountry > 0) {
            System.out.println(satelliteIdForCountry);
        } else {
            System.out.println("No such type");
        }
    }
}



/*
Testcase 1: 
Input:
1001
Chandrayan1
India
4
Education
100
1002
Chandrayan2
India
5
Defence
150
1003
Chandrayan3
India
4
Education
120
1004
GSat
India
2
Education
140
Education
4
India

Output:
1004
GSat
India
1002
*/

/*


Testcase 2: 1001
Chandrayan1
India
4
Education
100
1002
Chandrayan2
India
5
Defence
150
1003
Chandrayan3
India
4
Education
120
1004
GSat
India
2
Education
140
Moon
7
India
output:
No such Satellite
No such type
*/
