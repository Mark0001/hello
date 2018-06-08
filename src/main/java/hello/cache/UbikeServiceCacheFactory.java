package hello.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.cache.EhcacheUtil.CacheGroup;
import hello.dto.UbikeInfoDTO;

@Component
public class UbikeServiceCacheFactory {

    @Autowired
    EhcacheUtil cacheUtil;

    public UbikeInfoDTO getFromCache(String city, String stationId) {
        Map<String, UbikeInfoDTO> data =  cacheUtil.getElement(CacheGroup.cache120Sec, city);
        if(data == null) {
            data = this.getUbikeAreaService(city);
            cacheUtil.addElement(CacheGroup.cache120Sec, city, data);
        }
        return data.get(stationId);
    }

    private Map<String, UbikeInfoDTO> getUbikeAreaService(String city) {
        JSONArray jsonArray = null;
        try {
            jsonArray = readJsonFromUrl("http://ptx.transportdata.tw/MOTC/v2/Bike/Availability/" + city + "?$format=JSON");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, UbikeInfoDTO> data = new HashMap<String, UbikeInfoDTO>();
        for (int i = 0; i < jsonArray.length(); i++) {
            UbikeInfoDTO e = new UbikeInfoDTO();
            JSONObject o = jsonArray.optJSONObject(i);
            e.setStationUID(o.has("StationUID") ? o.getString("StationUID") : "");
            e.setStationID(o.has("StationID") ? o.getString("StationID") : "");
            e.setServieAvailable(o.has("ServieAvailable") ? o.getInt("ServieAvailable") : 0);
            e.setAvailableRentBikes(o.has("AvailableRentBikes") ? o.getInt("AvailableRentBikes") : 0);
            e.setAvailableReturnBikes(o.has("AvailableReturnBikes") ? o.getInt("AvailableReturnBikes") : 0);
            e.setSrcUpdateTime(o.has("SrcUpdateTime") ? o.getString("SrcUpdateTime") : "");
            e.setUpdateTime(o.has("UpdateTime") ? o.getString("UpdateTime") : "");
            data.put(e.getStationUID(), e);
        }
        return data;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            //          System.out.println(jsonText);
            JSONArray jsonArray = new JSONArray(jsonText);
            return jsonArray;
        } finally {
            is.close();
        }
    }
}
