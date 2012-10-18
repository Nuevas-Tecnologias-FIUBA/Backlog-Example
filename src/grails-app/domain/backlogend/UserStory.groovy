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

	static hasMany = [comments : Comment]

	static constraints = {
		description blank: false
		theme nullable: true
		points min: 0
	}
	
	def changeStatus(StoryStatus status) {
		this.status = status
	}

	public String toString() {
		return this.getDescription();
	}
}
