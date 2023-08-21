import java.util.Scanner;

class IncomeTaxFiling {
    private int panNo;
    private String name;
    private int taxToBePaid;
    private int taxPaid;
    private String location;

    public IncomeTaxFiling(int panNo, String name, int taxToBePaid, int taxPaid, String location) {
        this.panNo = panNo;
        this.name = name;
        this.taxToBePaid = taxToBePaid;
        this.taxPaid = taxPaid;
        this.location = location;
    }

    public int getPanNo() {
        return panNo;
    }

    public String getLocation() {
        return location;
    }

    public int getTaxToBePaid() {
        return taxToBePaid;
    }

    public int getTaxPaid() {
        return taxPaid;
    }
}

class Solution {
    public static int findBalanceTaxToBePaid(IncomeTaxFiling[] taxFilings, int panNo) {
        for (IncomeTaxFiling filing : taxFilings) {
            if (filing.getPanNo() == panNo) {
                return filing.getTaxToBePaid() - filing.getTaxPaid();
            }
        }
        return 0;
    }

    public static int findMaxTaxPaid(IncomeTaxFiling[] taxFilings, String location) {
        int maxTaxPaid = 0;
        for (IncomeTaxFiling filing : taxFilings) {
            if (filing.getLocation().equals(location)) {
                maxTaxPaid = Math.max(maxTaxPaid, filing.getTaxPaid());
            }
        }
        return maxTaxPaid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        IncomeTaxFiling[] taxFilings = new IncomeTaxFiling[4];

        for (int i = 0; i < 4; i++) {
            int panNo = scanner.nextInt();
            String name = scanner.next();
            int taxToBePaid = scanner.nextInt();
            int taxPaid = scanner.nextInt();
            String location = scanner.next();
            taxFilings[i] = new IncomeTaxFiling(panNo, name, taxToBePaid, taxPaid, location);
        }

        int panToFind = scanner.nextInt();
        String locationToFind = scanner.next();

        int balanceTax = findBalanceTaxToBePaid(taxFilings, panToFind);
        int maxTaxPaid = findMaxTaxPaid(taxFilings, locationToFind);

        if (balanceTax > 0) {
            System.out.println(balanceTax);
        } else {
            System.out.println("No such PAN No");
        }

        if (maxTaxPaid > 0) {
            System.out.println(maxTaxPaid);
        } else {
            System.out.println("No such incometax filing");
        }
    }
}




/*
Testcase1:
Input:
1001
John
75000
50000
Chennai
1002
Jack
100000
40000
Bangalore
1003
Wick
20000
10000
Chennai
1004
Sparrow
35000
34000
Chennai
1003
Chennai
Output:
10000
50000
*/




/*
Testcase2: 
Input: 
1001
John 
75000
50000
Chennai
1002
Jack
100000
40000
Bangalore
1003
Wick
20000
10000
Chennai
1004
Sparrow
35000
34000
Chennai
1007
Mumbai
Output:
"No such PAN No"
"No such incometax filing"
*/





