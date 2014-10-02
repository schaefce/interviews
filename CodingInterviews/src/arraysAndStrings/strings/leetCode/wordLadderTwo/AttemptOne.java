package arraysAndStrings.strings.leetCode.wordLadderTwo;

/*Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
 [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ] */
public class AttemptOne{

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        LinkedList<LinkedList<String>> listOfLadders = new LinkedList<LinkedList<String>>();

        LinkedList<LinkedList<String>> ret = new LinkedList<LinkedList<String>>();
        Set<String> used = new HashSet<String>();

        LinkedList<String> wordQueue = new LinkedList<String>();
        wordQueue.add(start);
        listOfLadders.add(wordQueue);
        while (!listOfLadders.isEmpty()) {
            boolean finished = false;
            int minSize = Integer.MAX_VALUE;
            for(int j = 0; j < listOfLadders.size(); j++){
                LinkedList<String> list = listOfLadders.pop();
                if(finished && list.size() >= minSize){
                    continue;
                }
                String currWord = list.getLast();
                if (currWord.equals(end)) {
                    ret.add(list);
                    finished = true;
                    minSize = list.size() < minSize ? list.size() : minSize;
                    continue;
                }
                used.add(currWord);
                for (int i = 0; i < currWord.length(); i++) {
                    char[] currCharArr = currWord.toCharArray();
                    char prev = currCharArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(prev == c)
                            continue;
                        currCharArr[i] = c;
                        String newWord = new String(currCharArr);
                        if (!used.contains(newWord) && dict.contains(newWord)) {
                            LinkedList<String> newList = new LinkedList<String>(list);
                            newList.add(newWord);
                            //listOfLadders.add(newList);
                            if(newWord.equals(end)){
                                if(finished){
                                    if(newList.size() <= minSize){
                                        ret.add(newList);
                                        minSize = newList.size();
                                    }
                                }
                                else{
                                    finished = true;
                                    ret.add(newList);
                                    minSize = newList.size();
                                }
                            }
                            else if(finished && newList.size() == minSize){
                                continue;
                            }
                            else{
                                listOfLadders.add(newList);
                            }
                        }
                    }
                    currCharArr[i] = prev;

                }
            }
            if(finished){
                return ret;
            }
        }

        return ret;
    }

}
