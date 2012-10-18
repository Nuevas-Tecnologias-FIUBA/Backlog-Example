package backlogend

class UserService {
	static transactional = true // por default es true, esta linea es opcional
	
    def createNewUser(String username, String password) {
		log.error("createNewUser() invoked")

		log.error("creando usuario")
		// creamos un usuario y lo grabamos
		def user = new User(name: username, password: password)
		user.save(insert: true)
		log.error("usuario insertado")

		// descomentar para probar la transaccionalidad
		// throw new IllegalArgumentException();
    }
}
