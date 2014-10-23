package backlogend

class StoryPriority {

	String description

	static constraints = {
		description blank: false, unique: true
	}

	public String toString() {
		this.description
	}
}
