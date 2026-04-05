class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder("");

        for(String s: strs) {
            str.append(s.length());
            str.append("#");
            str.append(s);
            str.append("#");
        }

        // System.out.println("Encoded String : "+str.toString());

        return str.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        int index = 0;

        // System.out.println("given encded string to decode : "+str);

        while(index < str.length()) {

            // find the length of current string
            StringBuilder lenSub = new StringBuilder("");
            while(index < str.length() && str.charAt(index) != '#') {
                lenSub.append(str.charAt(index++));
            }

            int currLength = Integer.parseInt(lenSub.toString());


            // resolve the current string from length now, index is at# now
            
            String currString = str.substring(index+1, index+1+currLength);
            res.add(currString);

            index = index+1+currLength+1;   
        }
        return res;
    }
}

/*
2 # w e # 3 # s a y # 1 : # 3 y e s # 1 0 # ! @ # $ % ^ & * ( ) #
0 1 2 3 4 5                                5 6 7 8 9
        i


245#reagwoinaerogbineab#54#adsfgsodvnsdv 
sub = we

res = {}

*/