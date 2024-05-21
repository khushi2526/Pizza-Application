package Model;

public class Customer {
	private String name;
	private int phnNum;
	
	public Customer(String name, int phnNum) {
		this.name = name;
		this.phnNum	= phnNum;
	}
	
	public String getName() {
		return name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhnNum() {
		return phnNum;
	}

	
	public void setPhnNum(int phnNum) {
		this.phnNum = phnNum;
	}
	
}
