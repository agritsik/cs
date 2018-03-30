public class WordBreak {}

class Solution1 {
	public int wordBreak(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
        Set<String> dict = new HashSet<>(B);
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()]?1:0;
    }
}

class Solution2 {
	

	  public int wordBreak(String a, ArrayList<String> b) {
	    int[] dp = new int[a.length()];
	    int ans = solve(0, dp, a, b);
	    return ans == 1 ? 1 : 0;
	    
	}
	
	static boolean startsWith(int index, String word, String a){
	    if((index + word.length()) > a.length()) return false;
	    for(int i = 0; i < word.length(); i++)
	        if(a.charAt(i + index) != word.charAt(i)) return false;
        return true;
	}
	
	static int solve(int l, int[] dp, String a, ArrayList<String> b){
	    if(l == a.length())  return 1;
	    if(dp[l] != 0) return dp[l];
	    int ans = -1;
	    for(int i = 0; i < b.size(); i++)
	        if(startsWith(l, b.get(i), a) && solve(l + b.get(i).length(), dp, a, b) == 1){
                ans = 1;
                break;
            }
            dp[l] = ans;
	    return ans;
	} 

}

class Solution3 {
    
	public int wordBreak(String a, ArrayList<String> b) {
	    int[] dp = new int[a.length()];
	    int ans = solve(0, dp, a, b);
	    return ans == 1 ? 1 : 0;
	    
	}
	
	static boolean startsWith(int index, String word, String a){
	    if((index + word.length()) > a.length()) return false;
	    for(int i = 0; i < word.length(); i++)
	        if(a.charAt(i + index) != word.charAt(i)) return false;
        return true;
	}
	
	static int solve(int l, int[] dp, String a, ArrayList<String> b){
	    if(l == a.length())  return 1;
	    if(dp[l] != 0) return dp[l];
	    int ans = -1;
	    for(int i = 0; i < b.size(); i++)
	        if(startsWith(l, b.get(i), a) && solve(l + b.get(i).length(), dp, a, b) == 1){
                ans = 1;
                break;
            }
	    return dp[l] = ans;
	}
}
