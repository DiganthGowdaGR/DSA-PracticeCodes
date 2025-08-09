class duplInStack {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] intStack = new  boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length() ; i++){
         char c = s.charAt(i);
         count[c - 'a'] ++;
        }

        for(int i =0 ; i<s.length(); i++){
            char c = s.charAt(i);
            count [c-'a']--;

            if(intStack[c - 'a']) continue;

            while(!stack.isEmpty() && stack.peek() >c && count[stack.peek() - 'a'] > 0) {
                intStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            intStack[c- 'a'] = true;


        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack){
            result.append(ch);
        }
        return result.toString();
    }
}
