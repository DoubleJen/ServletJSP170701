package tw.brad.bean;
/*
 * JavaBean rules
 * 1. implements Serializable
 * 2. public class
 * 3. field member can not a public
 * 4. getter & setter => getXxx, setXxx => field xxx
 * 5. none argument Constructor (default Constructor)
 */

//public class Member implements Serializable {
public class Member170709 {
	private String id, name;
	public Member170709() {
		System.out.println("MEMBER()");
	}
	public Member170709(String id, String name) {
		System.out.println("MEMBER(String, String)");
		this.id=id; this.name=name;
	}
	public void setId(String id) {this.id=id;}
	public void setName(String name) {this.name=name;}
	public String getId() {return id;}
	public String getName() {return name;}
	
	public void m1() {
		System.out.println("MEMBER.m1()");
	}
	
	@Override
	public String toString() {
		return id + ":" + name;
	}
}
