package 链表;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list kkk = new list();
		kkk.add(1);
		kkk.add(2);
		kkk.add(3);
		System.out.println(kkk);
	
	}}
class list{
	public node head;
	public list() {
		head = null;
	}
	public void add(int a) {
		node n = new node(a);//dao ru xin de 
		node position;//dai biao wei zhi
		if(head==null)//first
			head = n;
		else {position = head;
			while (position.next != null) 
				position = position.next;//qian jin le yi ceng
			position.next = n;
		}
	}
	public node find(int a) {
		node position = head;
		while(position !=null) {
			if(position.num==a)
				return position;
			else
				position = position.next;
				}
		System.out.println("并没有找到！！！");
		return null;
	}
	public void insert(int a,int b) {
		node kkk = new node(b);
		node position = head;
		while (position!=null) {
			if(position.num==a) {
				kkk.next = position.next;
				position.next = kkk;
				break;
			}
			else 
				position = position.next;
		}
		if(position==null)
			System.out.println("并没有发现您要找的数据");
	}
	public void delete(int a) {
		node position = head;
		node current = position.next;
		if(head.num ==a )
			head = current;
		else{while (current!=null) {
			if(current.num==a) {
				position.next = current.next;
				break;}
			else {
				position = current;
				current = current.next;
		}
		}
		}
	}
	public void addhead(int a) {
		 node position  = new node(a);
		 position.next = head;
		 head = position;
	}
	public String toString() {
		String result = "";
		node position = head;
		while (position!=null) {
			result+=position+"\n";
			position = position.next;
		}
		return result;
		}
}
class node{
	int num;node next;
	public node(int a) {
		num = a;
		next= null;
	}
	/*public node next() {
		return next;
	}*/
	public String toString () {
		return "数据为   "+num;
	}
}

