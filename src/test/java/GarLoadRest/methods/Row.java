package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;


public class Row {

    static FeederBuilder<String> rowAoidFeeder = csv("rowAoid.csv").random();
    static FeederBuilder<String> rowGuidFeeder = csv("rowGuid.csv").random();


    public static ChainBuilder rowAoidAdm =
            exec(
                    feed(rowAoidFeeder),
                    http("Получение списка действующих адресных объектов до текущего по aoid в адм. делении (/api/addrobject/row)")
                            .get("/api/addrobject/row?aoid=#{rowAoid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder rowAoidMun =
            exec(
                    feed(rowAoidFeeder),
                    http("Получение списка действующих адресных объектов до текущего по aoid в мун. делении (/api/addrobject/row)")
                            .get("/api/addrobject/row?aoid=#{rowAoid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));


    public static ChainBuilder rowGuidAdm =
            exec(
                    feed(rowGuidFeeder),
                    http("Получение списка действующих адресных объектов до текущего по aoguid в адм. делении (/api/addrobject/row)")
                            .get("/api/addrobject/row?aoguid=#{rowGuid}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder rowGuidMun =
            exec(
                    feed(rowGuidFeeder),
                    http("Получение списка действующих адресных объектов до текущего по aoguid в мун. делении (/api/addrobject/row)")
                            .get("/api/addrobject/row?aoguid=#{rowGuid}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));


}
