package previousTeams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;




public class Scrabble {


	 
     private static void permutations(String prefix, String str, ArrayList<String> perms)

     {
         int n = str.length();
         perms.add(prefix);
         if(n!=0)
         {
             for (int i = 0; i < n; i++)

                 permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),perms);  
         }
     }


     private static ArrayList<String> permutations(String string)
     {
         ArrayList<String> perms = new ArrayList<String>();
         permutations("",string,perms);
         /*
         for(String word: perms)
                 System.out.println(word);
         */
         return perms;
     }

     public static HashMap<String,Integer> scoreEvaluation(String str)
     {
             int a[]=new int[27];
             for(int i=0;i<str.length();i++)
                     a[(str.charAt(i)-'a')]++;
             int b[]=new int[27];
             HashMap<String,Integer> hm=new HashMap();
             BufferedReader bReader = null;
             String line = "",s;
             try {
                     bReader = new BufferedReader(new FileReader("C:\\Users\\arprasanna\\Desktop\\sowpods.txt"));
                     while((line = bReader.readLine())!=null)
                     {
                             s = line;
                             b=a;int i;
                             for(i=0;i<str.length();i++)
                             {       
                                             if(b[(str.charAt(i)-'A')]==0)
                                                             break;
                                     b[(str.charAt(i)-'A')]--;
                             }
                             if(i==str.length())
                             {
                                     hm.put(line, getScore(line));
                             }
                     }
             }
             catch(Exception e){
            	 
             }
             return hm;
     }

	
	private static String maxScoreWord(String word) {

			//Receiving all possible permutations of tiles
			
			HashMap<String,Integer> map = scoreEvaluation(word);
			ArrayList<String> perms = permutations(word);
			int max = 0;
			String maxScoreString = "";
			for(int i=0;i<perms.size();i++){
				int score = map.get(word);
				if(score>max){
					score = max;
					maxScoreString = perms.get(i);
				}
			}
            return maxScoreString;
            

    }

    public static void main(String[] args) {

            // TODO Auto-generated method stub

            

            String word = "bcdefab";
            System.out.println(maxScoreWord(word));

    }

    

}


