package backlogend

class NewUserCommand {
	String name

	static constraints = {
		name(blank: false, minSize: 6)
	}
}

class HomeController {
	static allowedMethods = [save: "POST"]

	def index() {
		render view:"index"
	}

	def show(int id) {
		def user = User.findById(id)
		if (!user) {
			redirect uri:'/404'
			return
		}

		render view: "show", model: [user: user, id:id]
	}

	def create() {
		render view: 'create', model: [user: new NewUserCommand()]
	}

	def save(NewUserCommand cmd) {
		if (cmd.hasErrors()) {
			render view:'create', model: [user: cmd]
			return
		}

		new User(name:cmd.name).save()

		redirect controller:'home'
	}
}
