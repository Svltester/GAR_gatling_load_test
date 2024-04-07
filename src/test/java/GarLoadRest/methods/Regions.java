package GarLoadRest.methods;

import java.util.Random;
import io.gatling.javaapi.core.ChainBuilder;
import static io.gatling.javaapi.core.CoreDsl.bodyString;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Regions {

    public static final String[] ALL_REGION_CODES = {
            "1", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "2", "20", "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "3", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "4", "40", "41",
            "42", "43", "44", "45", "46", "47", "48", "49", "5", "50", "51", "52", "53", "54", "55", "56", "57", "58",
            "59", "6", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "7", "70", "71", "72", "73", "74",
            "75", "76", "77", "78", "79", "8", "83", "86", "87", "89", "9", "91", "92", "99"
    };

    public static String getRandomRegionCode(String[] codes) {
        int rnd = new Random().nextInt(codes.length);
        return codes[rnd];
    }

    public static final String MUN_HIERARCHY_POSTFIX = "&munHierarchy=true";

    public static ChainBuilder regionsAdm =
            exec(http("Список всех регионов в Адм. делении (/api/regions)")
                    .get("/api/regions")
                    .check(status().is(200))
                    .check(bodyString().notNull()));

    public static ChainBuilder regionsMun =
            exec(http("Список всех регионов в Мун. делении (/api/regions)")
                    .get("/api/regions?munHierarchy=true")
                    .check(status().is(200))
                    .check(bodyString().notNull()));

    public static ChainBuilder regionCodeAdm =
            exec(http("Поиск региона по коду в Адм. делении (/api/region/code?code=)")
                    .get("/api/region/code?code=" + getRandomRegionCode(ALL_REGION_CODES)));

    public static ChainBuilder regionCodeMun =
            exec(http("Поиск региона по коду в Мун. делении (/api/region/code?code=)")
                    .get("/api/region/code?code=" + getRandomRegionCode(ALL_REGION_CODES) + MUN_HIERARCHY_POSTFIX));
}
