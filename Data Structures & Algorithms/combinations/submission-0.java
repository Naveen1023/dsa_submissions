class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        solve(1, n , k, new ArrayList<>());

        return res;
    }

    private void solve(int index, int n, int k, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        if(index > n) return;
        
        for(int i=index;i<=n;i++) {
            list.add(i);
            solve(i+1, n, k, list);
            list.remove(list.size()-1);
        }
    }
}

/*
nCk

[1,2,3]
1,2
1,3
2,3

    f(1)
 -> f(2) f(3)

f(2)
-> f(3)


choose : only if current size is less than k
not choose 

*/