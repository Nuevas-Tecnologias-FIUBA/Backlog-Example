package backlogend

class StoryType {

	String description

	static constraints = {
		description blank: false, unique: true
	}

	public String toString() {
		this.description
	}
}
