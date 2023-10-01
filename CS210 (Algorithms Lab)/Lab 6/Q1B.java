import java.util.Scanner;

class Count{
    static int numberOfSubProblmes=0;

    public static void incrementSubproblemCount(){
        numberOfSubProblmes+=2;
    }
}

public class Q1B{

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int totalMatrices;
        System.out.print("Enter total matrices:");
        totalMatrices=sc.nextInt();
        int[] sizeMatrix=new int[totalMatrices+1];
        System.out.println("Enter size of matrix 1:");
        sizeMatrix[0]=sc.nextInt();
        sizeMatrix[1]=sc.nextInt();
        for(int i=2;i<=totalMatrices;i++){
            System.out.println("Enter size of matrix "+i+":");
            System.out.print(sizeMatrix[i-1] + "X");
            sizeMatrix[i]=sc.nextInt();
        }

        sc.close();
        int [][] dpTable=new int[totalMatrices+1][totalMatrices+1];
        int mul=MCM(sizeMatrix,1,totalMatrices,dpTable);
        System.out.println("Minimum number of multiplications: " + mul);
        System.out.println("Total number of subproblems:"+ Count.numberOfSubProblmes);
        System.out.println("Number of times we are sloving each subproblem is:");
        for(int i=1;i<=totalMatrices;i++){
            for(int j=1;j<=totalMatrices;j++){
                if(j < i){
                    System.out.printf("m[%d][%d]:Invalid Operation\n",i,j);
                }
                else{
                    System.out.printf("m[%d][%d]:1\n",i,j); //+1 beacuse of its own computation for first time
                }
            }
        }
        System.out.println(",where m[i][j] denotes multiplication of matrix i with matrix j as a subproblem.");
    }

    public static int MCM(int[] sizeMatrix,int i,int j,int [][] dpTable){
 
        if(dpTable[i][j]==100000){
            return dpTable[i][j];
        }
        if(i==j){
            dpTable[i][j]=0;
            return 0;
        }
        int min=100000000;
    
        for(int k=i;k<j;k++){
            Count.incrementSubproblemCount();
            int q=MCM(sizeMatrix, i, k,dpTable)+ MCM(sizeMatrix, k+1, j,dpTable)+ (sizeMatrix[i-1]*sizeMatrix[k]*sizeMatrix[j]);
            if(q < min){
                min=q;
            }
        }
        dpTable[i][j]=min;
        return min;
    }
}