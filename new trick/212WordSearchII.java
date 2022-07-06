class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    boolean[][] visited;
    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        ans = new ArrayList<>();
        //Trie
        TrieNode root = new TrieNode();
        BuildTrie(root, words);
        
        for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[i].length; j++) {
                 char c = board[i][j];
                 if (root.children[c - 'a'] != null) {
                     dfs(board, i, j ,root, visited);
                 }
             }
        }
        
        return ans;
    }
    
    private void BuildTrie(TrieNode root, String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int index = (int)(c - 'a');
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = s;
        }
    }

    private void dfs(char[][]board, int r, int c, TrieNode cur, boolean[][] visited) {
        
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return;
        if (visited[r][c]) return;
        
        char ca = board[r][c];
        if (cur.children[ca - 'a'] == null) return;
        cur = cur.children[ca - 'a'];
        if (cur.word != null) {
            ans.add(cur.word);
            cur.word = null;
        }
        visited[r][c] = true; 
        dfs(board, r + 1, c, cur, visited);
        dfs(board, r - 1, c, cur, visited);
        dfs(board, r, c + 1, cur, visited);
        dfs(board, r, c - 1, cur, visited);
            
        visited[r][c] = false;
        
    }

}
