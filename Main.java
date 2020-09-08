import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println(kmpSearch("abaacababcac","ac"));
    }
    public static ArrayList<Integer> GetJumpStep(String pattern) {
        ArrayList<Integer> steps = new ArrayList<>();
        steps.add(-1);
        int len = pattern.length();
        ArrayList<String> substrings = new ArrayList<String>(len - 1);
        int count = 1;
        for (count = 1; count < len; count++) {
            substrings.add(pattern.substring(0, count));
        }
        for (count=0; count<substrings.size();count++){
            String prefix;
            String suffix;
            int max = 0;
            String a = substrings.get(count);
            for (int countt = 1;countt<a.length();countt++){
                prefix=a.substring(0,countt);
                suffix=a.substring(a.length()-countt);
                if(prefix.equals(suffix)){
                    max = countt;
                }
            }
            steps.add(max);
        }

        return steps;
    }
    public static ArrayList<Integer> kmpSearch (String s,String p){
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int pLen = p.length();

        ArrayList<Integer> targetPositon = new ArrayList<Integer>();
        while(true){
            j = 0;
            System.out.println("found");
            while (j < pLen) {
                if (j == -1 || s.charAt(i) == p.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    j = GetJumpStep(p).get(j);
                    if(pLen-j-1>=sLen-i-1){
                        if(s.substring(sLen-pLen).equals(p)){
                            targetPositon.add(i - j);
                        }
                        return targetPositon;
                    }
                }
            }
            targetPositon.add(i - j);
            System.out.println("found"+i+" "+j);
            System.out.println("found"+(pLen-j-1)+" "+(sLen-i-1));
        }

    }
}
