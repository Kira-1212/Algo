import java.util.HashSet;
import java.util.Set;

public class Homework_5 {
	public static boolean solve(String input, int m, Set<String> inputSet){
        if(m == 0 || inputSet.size()==0)
            return false;
        boolean[][] t = new boolean[m][m];
        for(int q = 0; q < m-2; q++){
            if(inputSet.contains(input.substring(q,q+2)))
                t[q][q+1] = true;
        }
        int i,j,k;
        for(i = 4; i <= m ;  i = i +2 ){
            for(j = i-1; j < m ; j++){
//                System.out.println("i : " + i  + "j : "+j);
                if(inputSet.contains(input.substring(j-1,j+1)) && t[j-i+1][j-2]){
                    t[j-i+1][j] = true;
                    continue;
                }
                for(k = j-2; k > 0 ; k = k-2){
//                    System.out.println("k : " + k  + "j : "+j);

                        char temp1 = input.charAt(k-1);
                        char temp2 = input.charAt(j);
                        String temp = String.valueOf(temp1) + String.valueOf(temp2);
                    if(inputSet.contains(temp) && t[k][j-1] ){
                        if((k-1 == 0) || t[j-i+1][k-2])
                            t[j-i+1][j] = true;
                    }
                }
            }
        }

         return t[0][m-1];
    }
	
	public static void main(String[] args){
        String input = "baca";
        
        int m = input.length();

        Set<String> inputSet = new HashSet<String>();

        inputSet.add("ab");
        inputSet.add("aa");
        inputSet.add("bc");
//        inputSet.add("aa");
//        inputSet.add("cc");
//        inputSet.add("ac");
//        inputSet.add("ad");
        System.out.println(solve(input,m,inputSet));

    }
}
