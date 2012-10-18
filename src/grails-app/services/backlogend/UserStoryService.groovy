package backlogend

class UserStoryService {

    def changeStatus(int userStoryId, int newStatusId) {
		def userStory = UserStory.findById(userStoryId)
		def newStatus = StoryStatus.findById(newStatusId)

		if (!userStory) throw new IllegalArgumentException("user story id=${userStoryId} does not exist")
		if (!newStatus) throw new IllegalArgumentException("story status id=${newStatusId} does not exist")

		userStory.changeStatus(newStatus)
    }
}
