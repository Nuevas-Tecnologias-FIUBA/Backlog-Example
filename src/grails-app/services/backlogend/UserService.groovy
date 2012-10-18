package backlogend

class UserService {
	static transactional = true // por default es true, esta linea es opcional
	
    def createNewUser(String username) {
		new User(name:username).save()
    }
}
