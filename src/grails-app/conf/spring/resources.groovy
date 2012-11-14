// Place your Spring DSL code here

import backlogend.MailSender

beans = {
	mailSender(MailSender) {
		smtpHost = "smtp.google.com"
		smtpUser = "username"
		smtpPassword = "password"
	}
}
