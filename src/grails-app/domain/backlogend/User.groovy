package backlogend

class User {

	String name
	String password

	static constraints = {
		name blank:false, unique:true
		password blank: false
	}

	public String toString() {
		return this.getName();
	}
}
