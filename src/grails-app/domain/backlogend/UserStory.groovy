package backlogend

class UserStory {

	String description
	boolean epic
	StoryTheme theme
	StoryStatus status
	StoryType type
	int points
	User assigner
	User owner
	StoryPriority priority

	static hasMany = [
		comments: Comment,
	]

	static constraints = {
		description blank: false
		theme nullable: true
		points min: 0
	}

	def changeStatus(StoryStatus newStatus) {
		Map allowedTransitions = [
			"To do": ["In process", "Blocked"],
			"In process": ["To verify", "Blocked"],
			"To verify": ["Done", "Blocked"],
			"Blocked": ["To do"]
		]

		if (allowedTransitions[this.status.description]?.contains(newStatus.description)) {
			this.status = newStatus
		} else {
			throw new IllegalArgumentException("invalid transition")
		}
	}

	public String toString() {
		this.description
	}
}
