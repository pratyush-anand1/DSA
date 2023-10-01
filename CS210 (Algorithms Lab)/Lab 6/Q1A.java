import java.util.Scanner;

class subProblems{
    public int count;
    static int numberOfSubProblmes=0;

    subProblems(){
        this.count=0;
    }

    public void incrementCount(){
        this.count++;
    }

    public static void incrementSubproblemCount(){
        numberOfSubProblmes+=2;
    }
}

public class Q1A{

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

        subProblems [][] table =new subProblems[totalMatrices+1][totalMatrices+1];
        for(int i=1;i<=totalMatrices;i++){
            for(int j=1;j<=totalMatrices;j++){
                table[i][j]=new subProblems();
            }
        }
        
        sc.close();
        int mul=MCM(sizeMatrix,1,totalMatrices,table);
        System.out.println("Minimum number of multiplications: " + mul);
        System.out.println("Number of times we are sloving each subproblem is:");
        System.out.println("Total number of subproblmes:" + subProblems.numberOfSubProblmes);
        for(int i=1;i<=totalMatrices;i++){
            for(int j=1;j<=totalMatrices;j++){
                if(j < i){
                    System.out.printf("m[%d][%d]:Invalid Operation\n",i,j);
                }
                else{
                    System.out.printf("m[%d][%d]:%d\n",i,j,table[i][j].count+1); //+1 beacuse of its own computation for first time
                }
            }
        }
        System.out.println(",where m[i][j] denotes multiplication of matrix i with matrix j as a subproblem.");
    }

    public static int MCM(int[] sizeMatrix,int i,int j,subProblems[][] table){
        if(i==j){
            return 0;
        }
    
        int min=100000000;
    
        for(int k=i;k<j;k++){
            table[i][k].incrementCount();
            table[k+1][j].incrementCount();
            subProblems.incrementSubproblemCount();
            int q=MCM(sizeMatrix, i, k,table)+ MCM(sizeMatrix, k+1, j,table)+ (sizeMatrix[i-1]*sizeMatrix[k]*sizeMatrix[j]);
            if(q < min){
                min=q;
            }
        }
        return min;
    }
}