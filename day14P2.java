import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class day14P2{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("polymer.txt"));
      String s = "OHFNNCKCVOBHSSHONBNF";
      String p = "";
      String sub = "";
     
      while(f.hasNext()){
         p+= f.nextLine() + " ";
      }
      f = new Scanner(new File("polymer.txt"));
      Polymer[] arr = new Polymer[100];
     
      for(int i = 0; i < 100; i++){
         arr[i] = new Polymer(f.nextLine());
      }
      int n = 0;
      int index = 0;
      char[] c = {'O','H','B','V','S','K','F','C','N','P'};//OHBVSKFCNP
      long[] a = new long[10];
      for(int i = 0; i < s.length(); i++){
         for(int j = 0; j < 10; j++){
            if(s.charAt(i)==c[j]){
               a[j]++;
            }
         }
      }
      String first = "";
      String second = "";
      for(int i = 0; i < s.length()-1; i++){
         sub = s.substring(i,i+2);
         index = find(arr,sub);
         for(int j = 0; j < 10; j++){
            if(arr[index].c()==c[j]){
               a[j]++;
            }
         }
         first = arr[index].first();
         arr[find(arr, first)].add();
         second = arr[index].second();
         arr[find(arr, second)].add(); 
      }

      long[] values = new long[100];
      for(int j = 1; j < 40; j++){
         for(int i = 0; i < 100; i++){
            first = arr[i].first();
            for(int k = 0; k < 10; k++){
               if(arr[i].c()==c[k]){
                  a[k]+= arr[i].count();
               }
            }
            values[find(arr, first)]+=arr[i].count();
            
            second = arr[i].second();
           
            
            values[find(arr, second)]+=arr[i].count();
            arr[i].reset();
         }
         for(int i = 0; i < 100; i++){
            arr[i].add(values[i]);
           
         }
         values = new long[100];
      }


      for(int i = 0; i < 10; i++){
         System.out.println(a[i]);
      }
     
     
     
   }
   public static int find(Polymer[] arr, String s){
      for(int i = 0; i < 100; i++){
         if(arr[i].value().equals(s)){
            return i;
         }
      }
      return -1;
   }
}

class Polymer{
   private String s;
   private long count = 0;
   private char c;
   private char c1;
   private char c2;
  
   public Polymer(String p){
      s = p.substring(0,2);
      c = p.charAt(3);
      c1 = p.charAt(0);
      c2 = p.charAt(1);
   }
  
   public void add(){
      count++;
   }
   public void add(long n){
      count+= n;
   }
   public void reset(){
      count = 0;
   }
   public String value(){
      return s;
   }
   public String first(){
      return c1+""+c;
   }
   public String second(){
      return c+""+c2;
   }
   public char c(){
      return c;
   }
   public char c1(){
      return c1;
   }
   public char c2(){
      return c2;
   }
   public long count(){
      return count;
   }
   
}
