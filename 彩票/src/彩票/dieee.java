package ��Ʊ;
import java.util.*;
public class dieee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("��Ҫ��ע��");
		int n = in.nextInt();
		for(int i = 0;i<n;i++) {
			System.out.print("���ĵ�"+(i+1)+"ע�� ");
			for(int i1 = 0;i1<7;i1++) {
				die a = new die();
				a.roll();
				System.out.print(a.roll()+"\t");
			}
			System.out.println("");
		}
	}}
class die{
	private final int MAX = 30;
	private int face;
	public die()
	{
		face = 1;
	}
	public int roll()
	{
		face = (int)(Math.random()*MAX)+1;
		return face;
	}
	public void setface (int value)
	{
		face = value;
	}
	public int get ()
	{
		return face;

	}
	public String toString()
	{
		String result = Integer.toString(face);
	return result;
	}
											

}
