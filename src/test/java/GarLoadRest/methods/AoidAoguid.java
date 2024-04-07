package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class AoidAoguid {

    static FeederBuilder<String> AoidFeeder = csv("aoid.csv").random();
    static FeederBuilder<String> AoguidFeeder = csv("aoguid.csv").random();

    public static ChainBuilder aoidAdm =
            exec(
                    feed(AoidFeeder),
                    http("Получение объекта по aoid в адм. делении (/api/addrobject/aoid)")
                            .get("/api/addrobject/aoid?aoid=#{aoid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder aoidMun =
            exec(
                    feed(AoidFeeder),
                    http("Получение объекта по aoid в мун. делении (/api/addrobject/aoid)")
                            .get("/api/addrobject/aoid?aoid=#{aoid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder aoguidAdm =
            exec(
                    feed(AoguidFeeder),
                    http("Получение объекта по aoguid в адм. делении (/api/addrobject/aoguid)")
                            .get("/api/addrobject/aoguid?aoguid=#{aoguid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder aoguidMun =
            exec(
                    feed(AoguidFeeder),
                    http("Получение объекта по aoguid в мун. делении (/api/addrobject/aoguid)")
                            .get("/api/addrobject/aoguid?aoguid=#{aoguid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

}
