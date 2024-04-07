package GarLoadRest;

import java.time.Duration;

import io.gatling.javaapi.core.*;

import static io.gatling.javaapi.core.CoreDsl.*;

public class GarLoadSimulation extends Simulation{

    public static final int USER_PER_SEC = 2;
    public static final  int DURING_OF_SEC = 60;

    {
        setUp(
//                GarScenarios.scnRegions.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnRegionCode.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnStreet.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnPlace.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnFullTextSearch.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnRow.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnFull.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
//                GarScenarios.scnChildCount.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol),
                GarScenarios.scnAoidAoguid.injectOpen(constantUsersPerSec(USER_PER_SEC).during(Duration.ofSeconds(DURING_OF_SEC))).protocols(HttpProtocols.httpProtocol)

        );
    }
}
