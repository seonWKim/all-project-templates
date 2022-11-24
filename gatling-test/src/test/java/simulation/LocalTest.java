package simulation;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.incrementUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class LocalTest extends Simulation {

    HttpProtocolBuilder httpConf = http.baseUrl("http://localhost:8080/account")
                                       .header("Accept", "application/json")
                                       .header("content-type", "application/json");
    Iterator idNumbers = IntStream.iterate(0, x -> x + 1).iterator();

    Iterator<Map<String, Object>> feeder = Stream.generate((Supplier<Map<String, Object>>) () -> {
        String username = "username" + idNumbers.next();
        System.out.println(username);
        return Collections.singletonMap("username", username);
    }).iterator();

    ScenarioBuilder scn = scenario("blocking application with incrementUsersPerSec of 200")
            .feed(feeder)
            .exec(http("test")
                          .post("")
                          .body(StringBody(
                                  "{\"username\":\"#{username}\",\"password\":\"password\",\"authProvider\":\"GOOGLE\",\"accountExpired\":false,\"accountLocked\":false,\"accountLockedAt\":null,\"credentialExpired\":false,\"enabled\":true,\"name\":null,\"description\":\"seonwoodescriptionupdate\",\"telEnc\":\"asgsdfsf\",\"pictureUrl\":\"http://loclahoupdate\",\"email\":\"seonwoo@naver.com\",\"authority\":\"authority\"}"
                          ))
                          .header("content-type", "application/json")
                          .check(status().is(200)));

    {
        setUp(scn.injectOpen(
                incrementUsersPerSec(200)
                        .times(50)
                        .eachLevelLasting(10)
                        .separatedByRampsLasting(10)
                        .startingFrom(10)
        )).maxDuration(Duration.ofMinutes(2)).protocols(httpConf);
    }
}
