package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Street {
    static FeederBuilder<String> feeder = csv("street.csv").random();

    public static ChainBuilder streetAdm =
            exec(
                feed(feeder),
                http("Поиск улицы в Адм.делении (/api/street)")
                    .get("/api/street?place_aoguid=#{streetId}&prefix=#{streetName}")
                    .check(status().is(200))
                    .check(bodyString().notNull()));

    public static ChainBuilder streetMun =
            exec(
                    feed(feeder),
                    http("Поиск улицы в Мун.делении (/api/street)")
                            .get("/api/street?place_aoguid=#{streetId}&prefix=#{streetName}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

}
