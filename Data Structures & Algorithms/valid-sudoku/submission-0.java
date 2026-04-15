class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //Row check
        for(int i=0; i<m; i++){
            int[] horizontalCount = new int[m+1];
            int[] verticalCount = new int[m+1];
            for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    int num = (int)board[i][j] - '0';
                    horizontalCount[num]++;
                    if(horizontalCount[num] > 1){
                        return false;
                    }
                }

                if(board[j][i] != '.'){
                    int num = (int)board[j][i] - '0';
                    verticalCount[num]++;
                    if(verticalCount[num] > 1){
                        return false;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            int p = i / 3;
            int q = i % 3;
            System.out.println(p + ", " + q);
            int[] subBlock = new int[m+1];
            for(int x = 0; x<3; x++){
                for(int y=0; y<3; y++){
                    if(board[(p * 3)+x][(q * 3)+y] != '.'){
                        int num = (int)board[(p * 3)+x][(q * 3)+y] - '0';
                        subBlock[num]++;
                        if(subBlock[num] > 1){
                            return false;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(subBlock));
        }

        return true;
    }
}
