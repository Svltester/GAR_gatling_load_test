package GarLoadRest.methods;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Search {
    static FeederBuilder<String> feeder = csv("fullTextSearchAdrObj.csv").random();
    static FeederBuilder<String> feederHouses = csv("fullTextSearchHouses.csv").random();
    static FeederBuilder<String> feederAprtmns = csv("fullTextSearchApartmens.csv").random();
    static FeederBuilder<String> feederSteads = csv("fullTextSearchSteads.csv").circular();

    public static ChainBuilder fullTextSearchAdrObjAdm =
            exec(
                    feed(feeder),
                    http("Полнотекстовый поиск адр. объекта в адм. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullTextSearchAdrObjMun =
            exec(
                    feed(feeder),
                    http("Полнотекстовый поиск адр. объекта в мун. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));


    public static ChainBuilder fullTextSearchHouseAdm =
            exec(
                    feed(feederHouses),
                    http("Полнотекстовый поиск дома в адм. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=3")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullTextSearchHouseMun =
            exec(
                    feed(feederHouses),
                    http("Полнотекстовый поиск дома в мун. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=3" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));


    public static ChainBuilder fullTextSearchApartmensAdm =
            exec(
                    feed(feederAprtmns),
                    http("Полнотекстовый поиск квартиры в адм. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=4")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullTextSearchApartmensMun =
            exec(
                    feed(feederAprtmns),
                    http("Полнотекстовый поиск квартиры в мун. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=4" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullTextSearchSteadsAdm =
            exec(
                    feed(feederSteads),
                    http("Полнотекстовый поиск участка в адм. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=5")
                            .check(status().is(200))
                            .check(bodyString().notNull()));

    public static ChainBuilder fullTextSearchSteadsMun =
            exec(
                    feed(feederSteads),
                    http("Полнотекстовый поиск участка в мун. делении (/api/addrobject/search)")
                            .get("/api/addrobject/search?query=#{searchString}&minLevel=5" + Regions.MUN_HIERARCHY_POSTFIX)
                            .check(status().is(200))
                            .check(bodyString().notNull()));

}
