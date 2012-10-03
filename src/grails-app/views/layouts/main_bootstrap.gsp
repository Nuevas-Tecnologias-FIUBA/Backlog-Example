<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
	<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

	<r:require modules="bootstrap"/>
	<g:layoutHead/>
	<r:layoutResources />
  </head>

  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <g:link class="brand" controller="home">Backlog</g:link>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><g:link controller="home">Home</g:link></li>
              <sec:ifLoggedIn>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Backend <b class="caret"></b></a>
                <ul class="dropdown-menu">
                <li class="nav-header">CRUD</li>
                  <li><g:link controller="user">Users</g:link></li>
                  <li><g:link controller="userStory">User Stories</g:link></li>
                  <li><g:link controller="comment">Comments</g:link></li>
                  <li><g:link controller="storyTheme">Story Themes</g:link></li>
                  <li class="divider"></li>
                  <li class="nav-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                </ul>
              </li>
              </sec:ifLoggedIn>
            </ul>
            <sec:ifNotLoggedIn>
            <form class="navbar-form pull-right" action="${request.contextPath}/j_spring_security_check" method="post">
              <input name='j_username' class="span2" type="text" placeholder="Email">
              <input name='j_password' class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">Sign in</button>
            </form>
            </sec:ifNotLoggedIn>
            <sec:ifLoggedIn>
            <div class="nav-collapse pull-right">
                <ul class="nav">
                    <li><a href="#">¡Bienvenido <sec:loggedInUserInfo field="username" />!</a></li>
                    <li><g:link controller="logout">Logout</g:link></li>
                </ul>
            </div>
            </sec:ifLoggedIn>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

	<g:layoutBody/>
    
   	<g:javascript library="application"/>
	<r:layoutResources />
  </body>
</html>


