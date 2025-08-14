class maxCharacter {
    public int maxPower(String s) {
        int currentCount = 1;
        int maxCount = 1;

        for(int i = 1; i < s.length()-1; i++ ){
            if(s.charAt(i+1) == s.charAt(i)){
                currentCount++;
            }
            else{
                currentCount = 1;
            }
             maxCount  = Math.max(currentCount, maxCount);
        }
        return maxCount;
    }
}
