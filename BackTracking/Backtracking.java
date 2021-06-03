public class Backtracking{

	static int[] rowAdj = {-1, -1, -1, 0, 1, 1,  1, 0};
	static int[] colAdj = {-1,  0,  1, 1, 1, 0, -1, -1};

    static int[][] mat =
	{
		{1,1,0,0,0},
		{0,1,0,0,1},
		{1,0,0,1,1},
		{0,0,0,0,0},
		{1,0,1,0,1},
	} ;

	//new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    static int islands=0;

	public static void main(String[] args){

        for(int i=0; i< mat.length; i++){
            for(int j=0; j< mat.length; j++){

                if(mat[i][j] == 1 && !visited[i][j]){
                    getIslands(i,j, mat, visited);
					islands++;
                }
            }
        }
        System.out.println("No of islands are : "+islands);
	}


	public static void getIslands(int i, int j,int[][] mat, boolean[][] visited){
        // Marking the current cell visited
        visited[i][j] = true;
        // Base check , if this is already visited or out of the matrix , then return
         for(int k = 0; k<8; k++){
             if(isSafe(mat, i+rowAdj[k] , j+colAdj[k], visited)){
                 getIslands(i+rowAdj[k], j+colAdj[k], mat, visited); // Recure through each of the adjacent cells

			 }

         }

	}

	public static boolean isSafe(int[][] mat, int row, int col, boolean[][] visited){
		return ((row>=0 && row<mat.length) && (col>=0 && col<mat.length) && (visited[row][col]==false && mat[row][col] == 1)) ;
	}


}



install hibernet plugin for intellij
