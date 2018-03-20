package AddressBook;

public class PersonInfo {
	String name, hp, cp;
	
	public PersonInfo() {}
	public PersonInfo(String name, String hp, String cp) {
		this.name = name;
		this.hp = hp;
		this.cp = cp;
	}  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public void getInfo() {
		System.out.println("이름 : "+name);
		System.out.println("핸드폰 : "+hp);
		System.out.println("회사 : "+cp);
		System.out.println();
	}
	
}
