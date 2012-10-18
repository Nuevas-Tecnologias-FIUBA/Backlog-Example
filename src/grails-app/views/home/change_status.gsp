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
			<h1>Cambiar estado de historia de usuario</h1>
			<p>
				<a class="btn btn-primary btn-large">Learn more &raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span12">
				<h2>Elegí la historia de usuario y su nuevo estado</h2>

				<g:form class="form-horizontal" action="doChangeStatus">
					<g:hasErrors bean="${changeStatus}">
						<div class="alert alert-error">
			              <button type="button" class="close" data-dismiss="alert">×</button>
			              <strong>Oh snap!</strong> Change a few things up and try submitting again.
							  <ul>
								<g:eachError bean="${changeStatus}">
								    <li><g:message error="${it}"/></li>
								</g:eachError>
							  </ul>
			            </div>
					</g:hasErrors>
					
					<fieldset>
						<legend>Información personal</legend>
						<div class="control-group">
							<label class="control-label">Historia de usuario</label>
							<div class="controls">
								<g:select name="userStoryId" from="${backlogend.UserStory.list()}"
										  value="${changeStatus.userStoryId}"
										  noSelection="['':'Elegí la historia de usuario']"
										  optionKey="id" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Nuevo estado</label>
							<div class="controls">
								<g:select name="newStatusId" from="${backlogend.StoryStatus.list()}"
										  value="${changeStatus.newStatusId}"
										  noSelection="['':'Elegí el nuevo estado']"
										  optionKey="id" />
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
