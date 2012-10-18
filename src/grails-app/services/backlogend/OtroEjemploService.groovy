package backlogend

import org.springframework.transaction.annotation.Transactional

class OtroEjemploService {

	// este método es transactional
	@Transactional
    def metodoTransaccional() {
    }
	
	// no es transaccional, por que no use la anotación
	def noEsTransaccional() {
	}
	
	// es una transaccion read only, no modificará datos en la base de datos
	@Transactional(readOnly = true)
	def transaccionReadOnly() {
	}
	
	def alcanceTransaccionDefinidoPorElUsuario() {
		User.withTransaction { status ->
			// código transaccional aquí
		}
	}
}
