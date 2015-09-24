import java.util.LinkedList;
import java.util.List;

public class prefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> a = new LinkedList();
		a.add(new Integer(1));
		a.add(new Integer(2));
		a.add(new Integer(3));
		a.add(new Integer(4));
		a.add(new Integer(8));
		List<Integer> b = new LinkedList();
		b.add(new Integer(1));
		b.add(new Integer(2));
		b.add(new Integer(3));
		b.add(new Integer(4));
		b.add(new Integer(5));
		System.out.println(longestPrefix(a,b));
		

	}
	
	public static List<Integer> longestPrefix(List<Integer> a,List<Integer> b){
		List prefix = new LinkedList();
		if (!a.isEmpty()&&!b.isEmpty()&& a.get(0).intValue()==b.get(0).intValue()){
			prefix.add(a.get(0));
			a.remove(0);
			b.remove(0);
			prefix.addAll(longestPrefix(a,b));
			return prefix;
		}
		return prefix;
		
	}

}
