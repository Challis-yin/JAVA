package ʵ����;
import java.util.*;
public class die {
	private final int MAX;
	private int face;
	public die()
	{face = 1;
	Scanner in = new Scanner(System.in);
	System.out.println("�������ֵ");
	int max = in.nextInt();
	while (max<6||max>30)
		{System.out.println("������6-30֮�ڵ�����");
		  max = in.nextInt();}
	MAX = max;
	}public int roll()
	{face = (int)(Math.random()*MAX)+1;
	return face;
	}
	public void setface (int value)
	{face = value;
	}public int get ()
	{return face;

	}public String toString()
	{String result = Integer.toString(face);
	return result;
	}


	}




