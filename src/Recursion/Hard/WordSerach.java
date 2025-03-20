package Recursion.Hard;

public class WordSerach {
    public static void main(String[] args) {
            runTests();
        }

        public static void runTests() {
            System.out.println("===== EASY TEST CASES =====");
            test(new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            }, "ABCCED", true);

            test(new char[][]{
                    {'A'}
            }, "A", true);

            test(new char[][]{
                    {'A', 'B'},
                    {'C', 'D'}
            }, "E", false);

            System.out.println("\n===== MEDIUM TEST CASES =====");
            test(new char[][]{
                    {'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A'}
            }, "AAAA", true);

            test(new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'E', 'S'},
                    {'A', 'D', 'E', 'E'}
            }, "SEE", true);

            System.out.println("\n===== HARD TEST CASES =====");
            test(new char[][]{
                    {'C', 'A', 'A'},
                    {'A', 'A', 'A'},
                    {'B', 'C', 'D'}
            }, "AAB", true);

            test(new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            }, "ABCB", false);
        }

        private static void test(char[][] board, String word, boolean expected) {
            boolean result = solexist(board, word);
            System.out.println("Word: \"" + word + "\" -> " + (result == expected ? "PASS" : "FAIL"));
        }


        private static boolean solexist(char[][] board, String word) {
       for(int i=0;i<board.length;i++)
       {
           for(int j=0;j<board[0].length;j++){
               if(board[i][j]==word.charAt(0))
                   if (helper(board,i,j,word,0))
                       return true;
           }
       }
       return false;

    }

    private static boolean helper(char[][] board, int i, int j, String word, int index) {
        if(index == word.length() ){
            return  true;
        }

        if( i<0 || j<0 || i>=board.length || j>=board[0].length|| board[i][j] != word.charAt(index)|| board[i][j]=='|')
            return false;

        //// this is to prevent reusing of the same character
        char temp=board[i][j];
        board[i][j]='|';
        boolean top =helper(board,i-1,j,word,index+1);
        boolean bottom =helper(board,i+1,j,word,index+1);
        boolean right =helper(board,i,j+1,word,index+1);
        boolean left =helper(board,i,j-1,word,index+1);
        board[i][j]=temp; // undo changes
        return top || bottom||right||left;

    }
}


