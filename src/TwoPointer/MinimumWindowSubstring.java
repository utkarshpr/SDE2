package TwoPointer;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "adfechcinbvcochghufxfhachgcechgfiojcgufdccjwaeiocghu";
        int i=0,j=0;
        int start=0;
        int len=Integer.MAX_VALUE;
        HashMap<Character,Integer> hm=new HashMap<>();
        String t="aeiou*";
        for(Character ch:t.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count=hm.size();

        while (j<s.length()){
            char ch=s.charAt(j);
            ch=(isVowel(ch))?ch:'*';
            if(hm.containsKey(ch)){
                if(isVowel(ch)) {
                    hm.put(ch, hm.getOrDefault(ch, 0) - 1);
                }
                else {
                    hm.put('*', hm.getOrDefault('*', 0) - 1);
                }
                if(hm.get(ch)==0){
                    count--;
                }
            }
            while (count ==0){
                if(j-i+1<len){
                    len=j-i+1;
                    start=i;
                }

                char tem=s.charAt(i);
                tem=(isVowel(tem))?tem:'*';
                if(hm.containsKey(tem)){
                    if(isVowel(tem))
                        hm.put(tem,hm.getOrDefault(tem,0)+1);
                    else
                        hm.put('*',hm.getOrDefault('*',0)+1);
                    if(hm.get(tem)>0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        String ans=len==Integer.MAX_VALUE?"":s.substring(start,start+len);
        System.out.println(ans);

    }
    public static boolean isVowel(char ch){
        return  (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }
}
