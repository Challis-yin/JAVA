package ��������;
public  class ���� {//������ָ�������������ӵ���������������
	public  static void mai(int t) {
		int y = t;
		int under = 2;
		int all = 1;
		if(t%under==0) {
			all+=under;
			t = t/under;
			mai(t);
			if(t==1)
			if(all==y)
				System.out.print(all);
		}
		else {
			under++;
			mai(t);
		}
	}public static void main(String [] arg) {
		for(int i = 3;i<1000;i++) {
		int t = i;	
		mai(t);
	}

}}
