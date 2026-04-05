class StockSpanner {
List<int []> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int n = list.size();
        int j = n-1;
        int newSpan = 1;
        while(j >= 0 && list.get(j)[0] <= price) {
            newSpan += list.get(j)[1];
            j -= list.get(j)[1];
        }

        list.add(new int[]{price, newSpan});

        return newSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */