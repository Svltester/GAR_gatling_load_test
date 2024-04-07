package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Place {

    static FeederBuilder<String> feeder = csv("place.csv").random();

    public static ChainBuilder placeAdm =
            exec(
                    feed(feeder),
                    http("Поиск нас. пункта в адм. делении (/api/place)")
                        .get("/api/place?region_code=#{regionCode}&prefix=#{placeName}")
                        .check(status().is(200))
                        .check(bodyString().notNull()));

    public static ChainBuilder placeMun =
            exec(
                    feed(feeder),
                    http("Поиск нас. пункта в мун. делении (/api/place)")
                            .get("/api/place?region_code=#{regionCode}&prefix=#{placeName}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));
}
