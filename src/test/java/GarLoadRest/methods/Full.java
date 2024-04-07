package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Full {
    static FeederBuilder<String> fullAoidFeeder = csv("fullAoid.csv").random();
    static FeederBuilder<String> fullGuidFeeder = csv("fullGuid.csv").random();

    public static ChainBuilder fullAoidAdm =
            exec(
                    feed(fullAoidFeeder),
                    http("Получение строкового адреса по aoid в адм. делении (/api/addrobject/full)")
                            .get("/api/addrobject/full?aoid=#{fullAoid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullAoidMun =
            exec(
                    feed(fullAoidFeeder),
                    http("Получение строкового адреса по aoid в мун. делении (/api/addrobject/full)")
                            .get("/api/addrobject/full?aoid=#{fullAoid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullGuidAdm =
            exec(
                    feed(fullGuidFeeder),
                    http("Получение строкового адреса по aoguid в адм. делении (/api/addrobject/full)")
                            .get("/api/addrobject/full?aoguid=#{fullGuid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullGuidMun =
            exec(
                    feed(fullGuidFeeder),
                    http("Получение строкового адреса по aoguid в мун. делении (/api/addrobject/full)")
                            .get("/api/addrobject/full?aoguid=#{fullGuid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

}
