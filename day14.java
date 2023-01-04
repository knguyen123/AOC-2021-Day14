import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class day14{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("polymer.txt"));
      String s = "OHFNNCKCVOBHSSHONBNF";
      String p = "";
      String sub = "";
      while(f.hasNext()){
         p+= f.nextLine() + " ";
      }
      
      for(int j = 0; j < 10; j++){
         for(int i = 0; i < s.length()-1; i++){
            sub = s.substring(i,i+2);
            s = s.substring(0,i+1) + p.charAt(p.indexOf(sub)+3) + s.substring(i+1);
            i++;
         }
      }
      
      char[] c = {'O','H','B','V','S','K','F','C','N','P'};//OHBVSKFCNP
      int[] arr = new int[10];
      for(int i = 0; i < s.length(); i++){
         for(int j = 0; j < 10; j++){
            if(s.charAt(i)==c[j]){
               arr[j]++;
            }
         }
      }
      for(int i = 0; i < 10; i++){
         System.out.println(arr[i]);
      }
   }
}