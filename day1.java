class day1 {
    public boolean isPalindrome(int x) {
     if(x<0){
        return false;
     }   
     int k =  x;
     int revNum = 0;
     
    while(k>0){
        int d =  k%10;

        revNum = revNum*10 + d;

        k = k/10;
    }
    if(revNum == x){
        return true;
    }
    else{
        return false;
    }
    }
}
