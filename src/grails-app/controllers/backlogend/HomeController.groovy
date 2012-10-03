package backlogend

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

class HomeController {
	def index() {
		render view:"index"
	}
}
