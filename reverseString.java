class reverseString {

    public String reverseWords(String s) {

        //we are spliting each word it will detect multiple split also.
        String[] words = s.trim().split("\\s+");

        //now trying to list those words in revesing way
        List<String> listWords = Arrays.asList(words);

        //Now Reverse The words
        Collections.reverse(listWords);

        //now join into single string
        String reversed = String.join(" ",listWords);

        //now i will return full string after reversing
        return reversed;
    }
}
