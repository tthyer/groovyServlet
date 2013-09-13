package example.groovyServlet

import groovy.servlet.GroovyServlet

import javax.servlet.ServletConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExampleServlet extends GroovyServlet {
	
	void init(ServletConfig config) {
		println "ExampleServlet initialized"
	}

	void service(HttpServletRequest request, HttpServletResponse response) {
		def greeting = "Hello"
		def name = request.getParameter( "name" ) ?: "World"
		response.getWriter().write( "${greeting}, ${name}!" )
	}
	
}
