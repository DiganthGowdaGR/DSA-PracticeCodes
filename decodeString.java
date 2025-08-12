class decodeString {
    public String decodeString(String s) {
        int count = 0;

        Stack<Integer> numberStack = new Stack<>();
        Stack<String>  stringStack = new Stack<>();

        for (int i=0 ; i < s.length() ; i++){
                char ch = s.charAt(i);

                if(ch >= '0' && ch <= '9'){
                    int num = 0;

                    while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                        num = num * 10 + (int)(s.charAt(i) - '0');
                        i++;
                    }
                    i--;
                    numberStack.push(num);
                }

                else if(ch != ']'){
                    stringStack.push(ch + "");
                }
                else{
                    //what its equls to '['

                    String str = "";
                    while(!stringStack.peek().equals("[")){
                        str = stringStack.pop() + str;
                    }

                    stringStack.pop();

                    int repetationNumber = numberStack.pop();

                    StringBuilder sb = new StringBuilder("");

                    while(repetationNumber > 0){
                        sb.append(str);
                        repetationNumber -- ;
                    }

                    stringStack.push(sb.toString());

                }
        
        }

        StringBuilder ans = new StringBuilder("");

        while(stringStack.size() > 0  ){
            ans.insert(0,stringStack.pop());

        }

        return ans.toString();
    }
}
