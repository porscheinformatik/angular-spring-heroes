package heroes;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;

import heroes.backend.HeroService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeroesIntegrationTest {

  @LocalServerPort
  private int port;

  @MockBean
  private DevToolsProperties devToolsProperties;

  @BeforeEach
  public void setup() {
    RestAssured.port = port;
  }

  @Test
  public void heroesApiWorks() {
    get("/api/heroes").then().statusCode(200).body("size()", is(HeroService.HEROES.length));
  }
}
