package heroes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import heroes.backend.HeroService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HeroesIntegrationTest {

  @LocalServerPort
  private int port;

  @MockitoBean
  private DevToolsProperties devToolsProperties;

  private RestTestClient client;

  @BeforeEach
  void setup() {
    client = RestTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
  }

  @Test
  void heroesApiWorks() {
    client
      .get()
      .uri("/api/heroes")
      .exchange()
      .expectStatus()
      .isOk()
      .expectBody(List.class)
      .consumeWith(result -> {
        List<?> body = result.getResponseBody();
        assertNotNull(body);
        assertEquals(HeroService.HEROES.size(), body.size());
      });
  }
}
