package backlogend

class HomeController {
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
}
