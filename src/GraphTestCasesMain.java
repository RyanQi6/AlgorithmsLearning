import java.lang.reflect.Array;
import java.util.*;
public class GraphTestCasesMain {
    public void print2DMatrix(int[][] m){
        new ArrayTestCasesMain().print2DMatrix(m);
    }
    public void print2DMatrix(boolean[][] m){
        new ArrayTestCasesMain().print2DMatrix(m);
    }
    public void print2DMatrix(char[][] m){
        new ArrayTestCasesMain().print2DMatrix(m);
    }

    public void print1DArray(int[] array)
    {
        new ArrayTestCasesMain().print1DArray(array);
    }

    public void printList(List<Integer> li){
        for(Integer i: li){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        GraphTestCasesMain graphTest = new GraphTestCasesMain();
        // Test case for Place to Put Chairs I
        char[][] gym = {{'C','C','E','O','C'}, {'C','C','O','C','E'}, 
                {'C','C','E','E','C'},{'C','O','C','E','E'},{'C','C','O','C','C'}};
        List<Integer> r = new PlaceToPutTheChairI().putChair(gym);
        graphTest.print2DMatrix(gym);
        graphTest.printList(r);
    }
}
