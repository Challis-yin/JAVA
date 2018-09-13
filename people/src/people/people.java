package people;
class People {
    String name;
    String id;
	int age;

	public People(String name,String id, int age)
	{
		this.name=name;
		this.id=id;
		this.age=age;
	}
    //write your own codes
    public String getname()
    {
        String k = name;
        return k;
    }
    public String getid()
        {
            String k = id;
            return k;
        }
    public int getage()
    {
        int k = age;
        return k;
    }
    public boolean  equals (People p2)
    {
        boolean y = (name.equals(p2.getname())&&id.equals(p2.getid())&&age==p2.getage());
        return y;
    }

public static void main(String[] args) {
		People p1= new People("张三","123456",27);
		People p2 =new People("张三","123456",27);
        People p3 =new People("李四","123456",27);
		System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
	}

}