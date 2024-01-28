package advanced.module7.graphs;

public class FloydWarshallAlgorithm {
    public int[][] solve(int[][] A) {
        //It is an NxN matrix
        int N = A.length;

        for(int k = 0; k < N; k++){
            //Iterate the path that goes through each individual node

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){

                    if(A[i][k] != -1 && A[k][j] != -1 && A[i][j] != -1){
                        //Min distance among given value and path going through kth node
                        A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                    } else if (A[i][k] != -1 && A [k][j] != -1 && A[i][j] == -1){
                        //If no direct path exists between index i and j, choose the value of the path that goes through k
                        A[i][j] = A[i][k] + A[k][j];
                    }
                }
            }
        }

        return A;
    }
}
