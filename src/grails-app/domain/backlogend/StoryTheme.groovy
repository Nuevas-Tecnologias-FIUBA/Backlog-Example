package backlogend

class StoryTheme {

	String description

	static hasMany = [
		userStories: UserStory,
	]

	static constraints = {
		description blank: false, unique: true
	}

	public String toString() {
		this.description
	}
}
