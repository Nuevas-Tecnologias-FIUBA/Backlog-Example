package backlogend

class MailSender {

	String smtpHost
	String smtpUser
	String smtpPassword
	
	int mailsSent
	
	def notifyStatusChanged(UserStory userStory) {
		log.error("starting to send an email using smtp ${smtpHost} with username ${smtpUser} and pasword ${smtpPassword}")
		mailsSent = mailsSent + 1
		
		log.error("total emails sent ${mailsSent}")
	}
}
