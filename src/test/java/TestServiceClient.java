import com.fasterxml.jackson.databind.ObjectMapper;
import com.swapi.Planet;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
//        assertTrue(response.contains("\"name\":\"Tatooine\""));

        ObjectMapper mapper = new ObjectMapper();
        Planet planet = mapper.readValue(response, Planet.class);
        String expectedPlanetName = "Tatooine";
        assertEquals(expectedPlanetName, planet.getName());
    }
}