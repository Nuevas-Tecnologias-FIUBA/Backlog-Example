package backlogend

class UserService {
	static transactional = true // por default es true, esta linea es opcional
	
    def createNewUser(String username, String password) {
		// creamos un usuario y lo grabamos
		def user = new User(name: username, password: password)
		user.save()

		// creamos un story theme
		def userTheme = new StoryTheme(description: "El usuario ${username} creó este story theme.")
		userTheme.save(failOnError: true)
    }
}
