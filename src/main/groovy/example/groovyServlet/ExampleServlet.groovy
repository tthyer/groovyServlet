package example.groovyServlet

import groovy.servlet.GroovyServlet

import javax.servlet.ServletConfig
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExampleServlet extends GroovyServlet {
	
	void init(ServletConfig config) {
		println "ExampleServlet initialized"
	}
	
//	void service(HttpServletRequest request, HttpServletResponse response) {
//		def message = "Hello, World!"
//		response.getWriter().write( message )
//	}

	void service(HttpServletRequest request, HttpServletResponse response) {
		def message = "Hello, World!"
		if( request.getMethod() == "POST" ) {
			def name = request.getParameter( "name" )
			message = "Hello, $name!"
		}
		
		response.getWriter().write( message )
	}
	
}
