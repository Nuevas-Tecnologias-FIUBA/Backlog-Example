package backlogend

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

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
