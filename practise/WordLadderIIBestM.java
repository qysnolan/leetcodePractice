package yunsheng.leetcode.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderIIBestM {

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        if(start.equals(end)) return results;
 
        Queue<Path> q = new LinkedList<Path>();
        int maxLevel = dict.size() + 2;
        int nowLevel = 1;
        HashMap<String, ArrayList<String>> backTraceTable = new HashMap<String, ArrayList<String>>();
        for(String word: dict) backTraceTable.put(word, new ArrayList<String>());
        backTraceTable.put(start, new ArrayList<String>());
        backTraceTable.put(end, new ArrayList<String>());
        HashSet<String> toBeRemove = new HashSet<String>();
        
        Path begin = new Path(start, 1);
        q.offer(begin);
        while(!q.isEmpty()){
        	Path path = q.poll();
        	if(path.level > nowLevel){
        		dict.removeAll(toBeRemove);
        		toBeRemove.clear();
        		nowLevel = path.level;
        	}
        	if(path.level > maxLevel) break;
        	char[] chars = path.word.toCharArray();
    		for(int i = 0; i < chars.length; i++){
    			for(int j = 97; j <= 122; j++){
    				char odd = chars[i];
    				if(chars[i] != (char) j){
    					chars[i] = (char) j;
    					String newWord = String.valueOf(chars);
    					if(newWord.equals(end)) maxLevel = path.level;
    					if(!newWord.equals(start) && (dict.contains(newWord) || newWord.equals(end))){
    						backTraceTable.get(newWord).add(path.word);
    						if(!toBeRemove.contains(newWord)) q.offer(new Path(newWord, path.level + 1));
    						toBeRemove.add(newWord);
    					}
    				}
    				chars[i] = odd;
    			}
    		}
        }
        
        ArrayList<String> result = new ArrayList<String>();
        getResults(end, backTraceTable, result, results, start);
 
        for(int i = 0; i < results.size(); i++){
        	results.get(i).add(start);
        	revert(results.get(i));
        }
        return results;
    }
    
    public static void revert(ArrayList<String> result){
    	int begin = 0;
    	int end = result.size() - 1;
    	while(begin < end){
    		String swap = result.get(begin);
    		result.set(begin, result.get(end));
    		result.set(end, swap);
    		begin++;
    		end--;
    	}
    }
 
    public static void getResults(String word, HashMap<String, ArrayList<String>> backTraceTable,
    		ArrayList<String> result, ArrayList<ArrayList<String>> results, String start){
    	if(backTraceTable.get(word).isEmpty() && word.equals(start)){
    		results.add(new ArrayList<String>(result));
    		return;
    	}
    	result.add(word);
    	for(String nextWord: backTraceTable.get(word))
    		getResults(nextWord, backTraceTable, result, results, start);
    	result.remove(result.size() - 1);
 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(findLadders(start, end, dict));
	}

}

class Path{
	String word;
	int level;
	Path(String word, int level){
		this.word = word;
		this.level = level;
	}
}
