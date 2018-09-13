package people;

public class people2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People p1= new People("张三","123456",27);
		People p2 =new People("张三","123456",27);
        People p3 =new People("李四","123456",27);
		System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
	}

}
