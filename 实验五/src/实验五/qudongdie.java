package ʵ����;
import java.util.*;
public class qudongdie {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("how many dies do you want?");
		int num = in.nextInt();
		System.out.println("��ϣ���ж����˲μ�");
		int people = in.nextInt();
		int [][] peopleboxes = new int[people][num];
		int[] diebox = new int[num];
		
		for (int i = 0;i<num;i++)
		{   
			die k = new die();
			diebox[i]=k.roll();
			for (int x = 0;x<people;x++)
			{peopleboxes[x][i]=k.roll();
		}}
		System.out.print("�н����Ϊ�� ");
		for (int i = 0;i<num;i++)
		{
			System.out.print(diebox[i]+" ");
		}
		System.out.println("");
		for (int x = 0;x<people;x++)
		{
			System.out.print("��"+(x+1)+"�����������Ϊ�� ");
			for(int i = 0;i<num;i++)
			{
				System.out.print(peopleboxes[x][i]+" ");
						}
			System.out.println("");
		}
		int count1 = 0,count2 = 0,count3 = 0,count4 = 0;
		for (int x = 0;x<people;x++)
		{
			for (int i = 0;i<num;i++)
			{
				if(peopleboxes[x][i] == diebox[i] )
					count1++;
			}
			if (count1==num)
				count2++;
			if (count1==(num-1))
				count3++;
			if (count1==(num-2))
				count4++;
		}
		System.out.println("һ�Ƚ�����Ϊ"+count2);
		System.out.println("���Ƚ�����Ϊ"+count3);
		System.out.println("���Ƚ�����Ϊ"+count4);
	}
}