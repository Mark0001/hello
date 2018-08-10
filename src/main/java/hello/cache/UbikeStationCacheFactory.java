package hello.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dto.UbikeStationInfoDTO;

@Component
public class UbikeStationCacheFactory {

    @Autowired
    EhcacheUtil cacheUtil;

    public <T> List<UbikeStationInfoDTO> getFromCache() {
        List<UbikeStationInfoDTO> t = cacheUtil.getElement(EhcacheUtil.CacheGroup.cache120Sec, "stationData");
        if (t != null) {
            System.out.println("get From cache");
            return t;
        } else {
            System.out.println("not get From cache");
            List<UbikeStationInfoDTO> value = this.getAllStationInfo();
            cacheUtil.addElement(EhcacheUtil.CacheGroup.cache120Sec, "stationData", value);
            return value;
        }
    }

    private List<UbikeStationInfoDTO> getAllStationInfo() {

        List<UbikeStationInfoDTO> dataAll = new ArrayList<UbikeStationInfoDTO>();

        String[] citys = { "Taipei", "NewTaipei", "Taoyuan", "Taichung", "Tainan", "Kaohsiung", "ChanghuaCounty",
                "PingtungCounty" };
        for (String city : citys) {
            this.addIntoDataAll(city, dataAll);
        }

        return dataAll;
    }

    private void addIntoDataAll(String city, List<UbikeStationInfoDTO> dataAll) {
        List<UbikeStationInfoDTO> data = cityStationData(city);
        if (data != null) {
            dataAll.addAll(data);
        }
    }

    private List<UbikeStationInfoDTO> cityStationData(String city) {
        JSONArray jsonArray = null;
        try {
            jsonArray = readJsonFromUrl("http://ptx.transportdata.tw/MOTC/v2/Bike/Station/" + city + "?$format=JSON");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        List<UbikeStationInfoDTO> data = new ArrayList<UbikeStationInfoDTO>();

        for (int i = 0; i < jsonArray.length(); i++) {
            UbikeStationInfoDTO e = new UbikeStationInfoDTO();
            JSONObject o = jsonArray.optJSONObject(i);
            e.setCity(city);
            e.setStationUID(o.has("StationUID") ? o.getString("StationUID") : "");
            e.setStationID(o.has("StationID") ? o.getString("StationID") : "");
            e.setAuthorityID(o.has("AuthorityID") ? o.getString("AuthorityID") : "");
            e.setStationName_Zh_tw(
                    o.getJSONObject("StationName").has("Zh_tw") ? o.getJSONObject("StationName").getString("Zh_tw") : "");
            e.setStationName_En(o.getJSONObject("StationName").has("En") ? o.getJSONObject("StationName").getString("En") : "");
            e.setPositionLat(o.getJSONObject("StationPosition").has("PositionLat")
                    ? o.getJSONObject("StationPosition").getDouble("PositionLat")
                    : 0);
            e.setPositionLon(o.getJSONObject("StationPosition").has("PositionLon")
                    ? o.getJSONObject("StationPosition").getDouble("PositionLon")
                    : 0);
            e.setStationAddress_Zh_tw(
                    o.getJSONObject("StationAddress").has("Zh_tw") ? o.getJSONObject("StationAddress").getString("Zh_tw") : "");
            e.setStationAddress_En(
                    o.getJSONObject("StationAddress").has("En") ? o.getJSONObject("StationAddress").getString("En") : "");
            e.setBikesCapacity(o.has("BikesCapacity") ? o.getInt("BikesCapacity") : 0);
            e.setSrcUpdateTime(o.has("SrcUpdateTime") ? o.getString("SrcUpdateTime") : "");
            e.setUpdateTime(o.has("UpdateTime") ? o.getString("UpdateTime") : "");
            data.add(e);
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
