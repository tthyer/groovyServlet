package example.groovyServlet

import com.meterware.httpunit.*
import com.meterware.servletunit.*

import spock.lang.*

class ExampleServletSpec extends Specification {

	String baseUrl = 'http://someDomain/' //host to be ignored by the ServletRunner
	ServletRunner runner
	ServletUnitClient client
	
	def setup() {
		runner = new ServletRunner( "src/main/webapp/WEB-INF/web.xml" )
		client = runner.newClient()
	}
	
	def 'test get request'() {
		def somePath = "/some/path"
		WebRequest request = new GetMethodWebRequest( "$baseUrl$somePath" )
		WebResponse response = client.getResponse( request )
		
		expect:
		response != null
		200 == response.getResponseCode()
		"Hello, World!" == response.getText()
	}
	
	def 'test post request'() {
		def somePath = '/some/path'
		def name = 'Jane Doe'
		WebRequest request = new PostMethodWebRequest( "$baseUrl$somePath" )
		request.setParameter( 'name', name )
		WebResponse response = client.getResponse( request )
		
		expect:
		response != null
		200 == response.getResponseCode()
		"Hello, $name!" == response.getText()
	}

}