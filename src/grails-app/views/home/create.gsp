<!DOCTYPE html>
<html>
<head>
<!-- the following line chooses the layout for this page -->
<meta name="layout" content="main_bootstrap" />
</head>
<body>
	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Crear un nuevo usuario</h1>
			<p>
				<a class="btn btn-primary btn-large">Learn more &raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span12">
				<h2>Ingresá la información del usuario</h2>

				<g:form class="form-horizontal" action="save">
					<!--
					<g:renderErrors bean="${user}" />
					-->

					<g:hasErrors bean="${user}">
						<div class="alert alert-error">
			              <button type="button" class="close" data-dismiss="alert">×</button>
			              <strong>Oh snap!</strong> Change a few things up and try submitting again.
							  <ul>
								<g:eachError bean="${user}">
								    <li><g:message error="${it}"/></li>
								</g:eachError>
							  </ul>
			            </div>
					</g:hasErrors>
					
					<fieldset>
						<legend>Información personal</legend>
						<div class="control-group">
							<label class="control-label">Nombre</label>
							<div class="controls">
								<input type="text" name="name" value="${user.name}">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Contraseña</label>
							<div class="controls">
								<input type="password" name="password">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Repetir contraseña</label>
							<div class="controls">
								<input type="password" name="confirmation">
							</div>
						</div>
						<div class="form-actions">
						  <button type="submit" class="btn btn-primary">Crear</button>
						  <button type="button" class="btn">Cancel</button>
						</div>
					</fieldset>
				</g:form>

				<p>
					<a class="btn" href="#">View details &raquo;</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; Company 2012</p>
		</footer>

	</div>
	<!-- /container -->
</body>
</html>
