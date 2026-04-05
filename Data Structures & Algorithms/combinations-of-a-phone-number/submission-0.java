class Solution {
    HashMap<Character, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        res = new ArrayList<>();

        // map.put(2, new ArrayList<>(Arrays.asList('a','b','c')));
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, digits, new StringBuilder(""));

        return res;
    }

    private void solve(int index, String digits, StringBuilder temp) {

        if(index == digits.length()) {
            if(digits.length() > 0) res.add(temp.toString());
            return;
        }

        String eligibleChars = map.get(digits.charAt(index));

        for(int i=0; i<eligibleChars.length();i++) {
            temp.append(eligibleChars.charAt(i));
            solve(index+1, digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}

/*
3 -> def
4 -> ghi


34

for every index : 
    get the list of eligible characters
    append one by one and call next


*/
