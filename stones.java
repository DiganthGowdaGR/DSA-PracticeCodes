class stones {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());

        for(int ele : stones){
            mh.add(ele);
        }
            while(mh.size() > 1){
                int max = mh.remove();
                int smax = mh.remove();

                int crplc = max - smax ;

                if(crplc != 0){
                    mh.add(crplc);
                }
            }
            if(mh.size() == 0){
                return 0;
            }
            else{
                return mh.remove();
            }
            
        }
}
