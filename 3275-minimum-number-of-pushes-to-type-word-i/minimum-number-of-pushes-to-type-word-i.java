class Solution {
    public int minimumPushes(String word) {
        //int count=0;
        if(word.length()<=8)return word.length();
        else if(word.length()<=16)return word.length()+(word.length()-8);
        else if(word.length()<=24)return word.length()+(word.length()-8)+(word.length()-16);
        else return word.length()+(word.length()-8)+(word.length()-16)+(word.length()-24);
        //return count;
    }
}