package GarLoadRest;

import GarLoadRest.methods.*;
import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;

public class GarScenarios {

    static final ScenarioBuilder scnRegions = scenario("Получение списка всех регионов")
            .group("Regions").on(
                randomSwitch().on(
                        new Choice.WithWeight(50.0, exec(Regions.regionsAdm)),
                        new Choice.WithWeight(50.0, exec(Regions.regionsMun))
            ));

    static final ScenarioBuilder scnRegionCode = scenario("Получение данных региона по его коду")
            .group("RegionCode").on(
                randomSwitch().on(
                        new Choice.WithWeight(50.0, exec(Regions.regionCodeAdm)),
                        new Choice.WithWeight(50.0, exec(Regions.regionCodeMun))
            ));

    static final ScenarioBuilder scnStreet = scenario("Получение данных улицы")
            .group("Street").on(
                randomSwitch().on(
                        new Choice.WithWeight(50.0, exec(Street.streetAdm)),
                        new Choice.WithWeight(50.0, exec(Street.streetMun))
            ));

    static final ScenarioBuilder scnPlace = scenario("Получение данных нас. пункта")
            .group("Place").on(
                randomSwitch().on(
                        new Choice.WithWeight(50.0, exec(Place.placeAdm)),
                        new Choice.WithWeight(50.0, exec(Place.placeMun))
            ));


    static final ScenarioBuilder scnFullTextSearch = scenario("Полнотекстовый поиск")
            .group("FullTextSearch").on(
                randomSwitch().on(
                        new Choice.WithWeight(20.0, exec(Search.fullTextSearchAdrObjAdm)),
                        new Choice.WithWeight(20.0, exec(Search.fullTextSearchAdrObjMun)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchHouseAdm)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchHouseMun)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchApartmensAdm)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchApartmensMun)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchSteadsAdm)),
                        new Choice.WithWeight(10.0, exec(Search.fullTextSearchSteadsMun))
    ));

    static final ScenarioBuilder scnRow = scenario("Получение списка объектов до текущего")
            .group("Row").on(
                randomSwitch().on(
                        new Choice.WithWeight(25.0, exec(Row.rowAoidAdm)),
                        new Choice.WithWeight(25.0, exec(Row.rowAoidMun)),
                        new Choice.WithWeight(25.0, exec(Row.rowGuidAdm)),
                        new Choice.WithWeight(25.0, exec(Row.rowGuidMun))
                )
            );

    static final ScenarioBuilder scnFull = scenario("Получение строкового адреса")
            .group("Full").on(
                randomSwitch().on(
                        new Choice.WithWeight(25.0,exec(Full.fullAoidAdm)),
                        new Choice.WithWeight(25.0,exec(Full.fullAoidMun)),
                        new Choice.WithWeight(25.0,exec(Full.fullGuidAdm)),
                        new Choice.WithWeight(25.0,exec(Full.fullGuidMun))
                )
            );

    static final ScenarioBuilder scnChildCount = scenario("Получение количества дочерних объектов")
            .group("ChildCount").on(
                randomSwitch().on(
                        new Choice.WithWeight(25.0, exec(ChildCount.childCountAoidAdm)),
                        new Choice.WithWeight(25.0, exec(ChildCount.childCountAoidMun)),
                        new Choice.WithWeight(25.0, exec(ChildCount.childCountAoguidAdm)),
                        new Choice.WithWeight(25.0, exec(ChildCount.childCountAoguidMun))
                )
            );


    static final ScenarioBuilder scnAoidAoguid = scenario("Получение объекта по aoid/aoguid")
            .group("aoid/aoguid").on(
                    randomSwitch().on(
                            new Choice.WithWeight(25.0, exec(AoidAoguid.aoidAdm)),
                            new Choice.WithWeight(25.0, exec(AoidAoguid.aoidMun)),
                            new Choice.WithWeight(25.0, exec(AoidAoguid.aoguidAdm)),
                            new Choice.WithWeight(25.0, exec(AoidAoguid.aoguidMun))
                    )
            );

}
