package backlogend

/**
 * Comando utilizado para crear un nuevo usuario
 */
class NewUserCommand {
	String name
	String password
	String confirmation

	static constraints = {
		name blank: false, minSize: 6
		password blank: false
		confirmation blank: false, validator: { val, obj ->
			if (obj.password != val) return "passwordDoNotMatch"
		}
	}
}

/**
 * Comando utilizado para cambiar el estado de una historia de usuario
 */
class ChangeStatusCommand {
	Integer userStoryId
	Integer newStatusId

	static constraints = {
		userStoryId blank: false
		newStatusId blank: false
	}
}

class HomeController {

	static allowedMethods = [
		save: "POST",
		doChangeStatus: "POST",
	]

	def index() {
		render view:"index"
	}

	/* mostrar información de usuario */
	def show(int id) {
		def user = User.findById(id)
		if (!user) {
			redirect uri:'/404'
			return
		}

		render view: "show", model: [user: user, id:id]
	}

	/* crear un nuevo usuario */
	def create() {
		render view: 'create', model: [user: new NewUserCommand()]
	}

	// Grails inyectará el servicio en esta propiedad
	// ¿Cómo sabe que servicio inyectar? Usa una convención para determinar que servicio debe
	// inyectar. En este caso puso en mayúscula la primera letra y busco UserService
	def userService
	def save(NewUserCommand cmd) {
		if (cmd.hasErrors()) {
			render view:'create', model: [user: cmd]
			return
		}

		userService.createNewUser(cmd.name, cmd.password)
		redirect controller:'home'
	}

	/* cambiar estado de historia de usuario */
	def changeStatus() {
		render view: 'change_status', model: [changeStatus: new ChangeStatusCommand()]
	}

	// user story service, grails lo inyectará automáticamente
	def userStoryService

	def doChangeStatus(ChangeStatusCommand cmd) {
		if (cmd.hasErrors()) {
			render view: 'change_status', model: [changeStatus: cmd]
			return
		}

		try {
			userStoryService.changeStatus(cmd.userStoryId, cmd.newStatusId)
		} catch (IllegalArgumentException e) {
		// NO HACER ESTO: ver http://stackoverflow.com/questions/24913920/groovy-catch-statement-weird-behavior
		// } catch (IllegalArgumentException) {
			cmd.errors.rejectValue("newStatusId", "Transición inválida")

			render view: 'change_status', model: [changeStatus: cmd]
			return
		}

		redirect controller:'home'
	}
}
