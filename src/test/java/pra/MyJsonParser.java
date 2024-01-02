package pra;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Slf4j
public class MyJsonParser {

    /**
     * {
     * 	"name": "Luke Skywalker",
     * 	"height": "172",
     * 	"mass": "77",
     * 	"hair_color": "blond",
     * 	"skin_color": "fair",
     * 	"eye_color": "blue",
     * 	"birth_year": "19BBY",
     * 	"gender": "male",
     * 	"homeworld": "https://swapi.dev/api/planets/1/",
     * 	"films": [
     * 		"https://swapi.dev/api/films/2/",
     * 		"https://swapi.dev/api/films/6/",
     * 		"https://swapi.dev/api/films/3/",
     * 		"https://swapi.dev/api/films/1/",
     * 		"https://swapi.dev/api/films/7/"
     * 	],
     * 	"species": [
     * 		"https://swapi.dev/api/species/1/"
     * 	],
     * 	"vehicles": [
     * 		"https://swapi.dev/api/vehicles/14/",
     * 		"https://swapi.dev/api/vehicles/30/"
     * 	],
     * 	"starships": [
     * 		"https://swapi.dev/api/starships/12/",
     * 		"https://swapi.dev/api/starships/22/"
     * 	],
     * 	"created": "2014-12-09T13:50:51.644000Z",
     * 	"edited": "2014-12-20T21:17:56.891000Z",
     * 	"url": "https://swapi.dev/api/people/1/"
     * }
     * @throws Exception
     */
    @Test
    public void jsonParser() throws Exception {
        URL url = new URL("https://swapi.dev/api/people/1/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoInput(true);

        // 상태코드
        int responseCode = conn.getResponseCode();
        log.info("responseCode :: {} " , responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        // scriptengin을 이용하여 Json 파싱하기
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        log.info("response :: {} " ,response);
        String json = response.toString();

        String script = "Java.asJSONCompatible(" + json + ")";
        Object result = engine.eval(script);

        Map contents = (Map)result;

        contents.forEach((k, v) -> { System.out.println(k.toString()+":"+v.toString());});


        log.info("contents.values() {} " , contents.values());


    }
}
