package 实验五;
import java.util.*;
public class die {
	private final int MAX;
	private int face;
	public die()
	{face = 1;
	Scanner in = new Scanner(System.in);
	System.out.println("设置最大值");
	int max = in.nextInt();
	while (max<6||max>30)
		{System.out.println("请输入6-30之内的数字");
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




