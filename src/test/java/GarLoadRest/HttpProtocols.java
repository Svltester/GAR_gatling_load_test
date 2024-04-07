package GarLoadRest;

import io.gatling.javaapi.http.HttpProtocolBuilder;
import static io.gatling.javaapi.http.HttpDsl.http;

public class HttpProtocols {
    public static HttpProtocolBuilder httpProtocol = http
            .baseUrl(BaseUrls.CURRENT_BASE_URL)
            .acceptHeader("application/json")
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:124.0) Gecko/20100101 Firefox/124.0");
}
