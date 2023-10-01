import java.util.Scanner;

public class Q2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int days;
        System.out.println("Enter the number of days:");
        days=sc.nextInt();
        int[] p = new int[days];
        for(int i=0;i<days;i++){
            System.out.printf("Price for day %d:",i+1);
            p[i]=sc.nextInt();
        }
        bestSolution(days,p);
        sc.close();
    }

    public static void bestSolution(int days,int[] p){
        int curSmall=p[0];int bestProfit=0;int bestEnd=0;int curProfit=0;int curSmallIndex=0;int bestStart=0;
        for(int i=0;i<days;i++){
            if(p[i] < curSmall){
                curSmall=p[i];
                curSmallIndex=i;
            }
            curProfit=p[i]-curSmall;
            if(bestProfit < curProfit){
                bestProfit=curProfit;
                bestStart=curSmallIndex;
                bestEnd=i;
            }
        }

        if(bestProfit <= 0){
            System.out.println("No optimal solution");
        }
        else{
            System.out.printf("Buy on day %d and sell on day %d to get a profit of %d",bestStart+1,bestEnd+1,bestProfit);
        }
    }
}