package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import java.util.Map;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ChildCount {
    private static final Map<CharSequence, String> headers_childCount = Map.of("Accept", "text/html");

    static FeederBuilder<String> childCountAoidFeeder = csv("childCountAoid.csv").random();
    static FeederBuilder<String> childCountAoguidFeeder = csv("childCountAoguid.csv").random();

    public static ChainBuilder childCountAoidAdm =
            exec(
                    feed(childCountAoidFeeder),
                    http("Получение количества дочерних объектов по aoid в адм. делении (/api/addrobject/childCount)")
                            .get("/api/addrobject/childCount?aoid=#{childCountAoid}")
                            .headers(headers_childCount)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder childCountAoidMun =
            exec(
                    feed(childCountAoidFeeder),
                    http("Получение количества дочерних объектов по aoid в мун. делении (/api/addrobject/childCount)")
                            .get("/api/addrobject/childCount?aoid=#{childCountAoid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .headers(headers_childCount)
                            .check(status().is(200))
                            .check(bodyString().notNull()));
    public static ChainBuilder childCountAoguidAdm =
            exec(
                    feed(childCountAoguidFeeder),
                    http("Получение количества дочерних объектов по aoguid в адм. делении (/api/addrobject/childCount)")
                            .get("/api/addrobject/childCount?aoguid=#{childCountAoguid}")
                            .headers(headers_childCount)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder childCountAoguidMun =
            exec(
                    feed(childCountAoguidFeeder),
                    http("Получение количества дочерних объектов по aoguid в мун. делении (/api/addrobject/childCount)")
                            .get("/api/addrobject/childCount?aoguid=#{childCountAoguid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .headers(headers_childCount)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

}
