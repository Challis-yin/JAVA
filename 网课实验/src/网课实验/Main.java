package อ๘ฟฮสตั้;
import java.util.Scanner;
//write code here
class Publication{
  String name;int price;String date;
public Publication(String a,int b,String c){
  name = a;
  price = b;
  date = c;
}
  public void display(){
    
      System.out.println(""+ name+" "+price+" "+date) ;
  }
}
class Tape extends Publication {
//write code here
String playtime;
public Tape(String a,int b,String c,String d){
          super(a,b,c);
          playtime = d;}
  public void display(){
      
        System.out.println(""+name+" "+price+" "+date+" "+playtime) ;
  }}
class Book extends Publication{
      int page;
      public Book(String a,int b,String c,int d){
          super(a,b,c);
          page = d;
      }
      public void display(){

        System.out.println(""+name+" "+price+" "+date+" "+page) ;
  }
  
}

public class Main {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String strp1 = sca.next();
		int ip = sca.nextInt();
		String strp2 = sca.next();
		
		String strb1 = sca.next();
		int ib1 = sca.nextInt();
		String strb2 = sca.next();
		int ib2 = sca.nextInt();
		
		String strt1 = sca.next();
		int it = sca.nextInt();
		String strt2 = sca.next();
		String strt3 = sca.next();
		
		Publication p = new Publication(strp1, ip, strp2);
		p.display();
		Book b = new Book(strb1, ib1, strb2, ib2);
		b.display();
		Tape t = new Tape(strt1, it, strt2, strt3);
	
		t.display();
	}
}
