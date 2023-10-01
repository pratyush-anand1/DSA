import java.util.Scanner;
import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalDistance;
        System.out.print("Enter the distance between starting point and destination:");
        totalDistance = sc.nextInt();

        int fuelCapacity;
        System.out.print("Enter the fuel capacity of the car:");
        fuelCapacity = sc.nextInt();

        int totalPetrolPumps;
        System.out.print("Enter total number of petrol pumps:");
        totalPetrolPumps = sc.nextInt();

        int[] distance = new int[totalPetrolPumps + 1]; // +1 to add an extra distance at end (added at line 31)
  
        int i;
        for (i = 0; i < totalPetrolPumps; i++) {

            System.out.printf("Enter the distance of petrol pump %d from starting point:", i + 1);
            distance[i] = sc.nextInt();

        }

        // Value of i has been incremented to numberofpumps while chekcing last condn
        // hence next elemnt would be distane[i];
        distance[i] = distance[i - 1]; // condition when fuel ends exactly at ending point

        ArrayList<Integer> numberofPumps = new ArrayList<Integer>();

        int distanceTravelled = 0;
        numberofPumps.add(distance[0]);

        int flag = 1;

        for (int j = 0; j < distance.length - 1; j++) {

            if (((distanceTravelled + fuelCapacity) >= distance[j])
                    && ((distanceTravelled + fuelCapacity) < distance[j + 1])) {

                numberofPumps.add(distance[j]);
                distanceTravelled = distance[j];

            }

            else if (((distanceTravelled + fuelCapacity) < distance[j])
                    && ((distanceTravelled + fuelCapacity) < distance[j + 1])) {

                System.out.println("No efficient solution");
                flag = 0;
                break;

            }
        }

        if (flag != 0) {
            System.out.printf("Number of stops : %d\n", numberofPumps.size());
        }
    }
}