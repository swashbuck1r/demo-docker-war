import java.net.MalformedURLException;
import org.junit.*;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

public class MathIntegrationTest {

	private TestRestTemplate template;

	@Before
	public void setUp() {
		template = new TestRestTemplate();
	}

	@Test
	public void hello() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Hello CloudBees!!", response.getBody());
	}

	@Test
	public void add() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/add/3/2", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("5.0", response.getBody());
	}

	@Test
	public void sub() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/sub/3/2", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("1.0", response.getBody());
	}

	@Test
	public void MalformedURLException() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/mult/3/2", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("6.0", response.getBody());
	}

	@Test
	public void div() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/div/3/2", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("1.5", response.getBody());
	}

	@Test
	public void divZero() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/div/3/0", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("\"Infinity\"", response.getBody());
	}

	@Test
	public void sqrt() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/sqrt/4", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("2.0", response.getBody());
	}

	@Test
	public void cbrt() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/cbrt/27", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("3.0", response.getBody());
	}

	@Test
	public void abs() throws MalformedURLException {
		ResponseEntity<String> response = template.getForEntity("http://localhost:8080/abs/27.6", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("27.6", response.getBody());
	}
}
