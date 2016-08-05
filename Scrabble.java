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

     public static String scoreEvaluation(String str)
     {
             int a[]=new int[27];
             for(int i=0;i<27;i++)
            	 a[i]=0;
             int max=0;
             String s="";
             for(int i=0;i<str.length();i++)
                     a[(str.charAt(i)-'A')]++;
             int b[]=new int[27];
             //HashMap<String,Integer> hm=new HashMap();
             BufferedReader bReader = null;
             String line = "";
             try {
                     bReader = new BufferedReader(new FileReader("C:\\Users\\echinnasamy\\Downloads\\sowpods.txt"));
                     while((line = bReader.readLine())!=null)
                     {
                             //s = line;
                    	 System.out.println(line);
                             b=a;int i;
                             for(i=0;i<line.length();i++)
                             {       
                                             if(b[(line.charAt(i)-'A')]==0)
                                                             break;
                                     b[(line.charAt(i)-'A')]--;
                             }
                             if(i==line.length())
                             {
                            	 if(getScore(line)>max)
                            	 {
                            		 
                                     max= getScore(line);
                                     System.out.println(line+" "+max);
                                     s=line;	
                            	 }
                             }
                     }
             	}
             catch(Exception e){
            	 
             }
             return s;
     }
     
     private static final String ONE_POINTERS = "EAIONRTLSU";
     private static final String TWO_POINTERS = "DG";
     private static final String THREE_POINTERS = "BCMP";
     private static final String FOUR_POINTERS = "FHVWY";
     private static final String FIVE_POINTERS = "K";
     private static final String EIGHT_POINTERS = "JX";
     private static final String TEN_POINTERS = "QZ";
     
     public static int getScore(String word) {
         int points = 0;
         char []characters = word.toCharArray();
         for (char c : characters) {
             if (ONE_POINTERS.indexOf(c) != -1) {
                 points += 1;
             }
             else if (TWO_POINTERS.indexOf(c) != -1) {
                 points += 2;
             }
             else if (THREE_POINTERS.indexOf(c) != -1) {
                 points += 3;
             }
             else if (FOUR_POINTERS.indexOf(c) != -1) {
                 points += 4;
             }
             else if (FIVE_POINTERS.indexOf(c) != -1) {
                 points += 5;
             }
             else if (EIGHT_POINTERS.indexOf(c) != -1) {
                 points += 8;
             }
             else {
                 points += 10;
             }
         }
         return points;
     }
	
	private static String maxScoreWord(String word) {

			//Receiving all possible permutations of tiles
			
//			HashMap<String,Integer> map = scoreEvaluation(word);
//			ArrayList<String> perms = permutations(word);
//			int max = 0;
//			String maxScoreString = "";
//			for(int i=0;i<perms.size();i++){
//				int score = map.get(word);
//				if(score>max){
//					score = max;
//					maxScoreString = perms.get(i);
//				}
//			}
            return scoreEvaluation(word);
            

    }

    public static void main(String[] args) {

            // TODO Auto-generated method stub

            

            String word = "ABATORS";
            System.out.println(maxScoreWord(word));

    }

    

}


