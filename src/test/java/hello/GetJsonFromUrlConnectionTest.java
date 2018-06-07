package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJsonFromUrlConnectionTest {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //          System.out.println(jsonText);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException {
        //        JSONObject json = readJsonFromUrl("http://data.ntpc.gov.tw/api/v1/rest/datastore/382000000A-000352-001");
        JSONObject json = readJsonFromUrl(
                "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=ddb80380-f1b3-4f8e-8016-7ed9cba571d5");
        //        System.out.println(json.toString());
        JSONArray jsonArray = json.getJSONObject("result").getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.optJSONObject(i);
            System.out.println(obj.toString());
            System.out.println(obj.get("sna"));
        }
    }
}
