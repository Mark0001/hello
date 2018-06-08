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

import hello.dto.UbikeInfoDTO;

@Component
public class UbikeStationCacheFactory {

    @Autowired
    EhcacheUtil cacheUtil;

    public <T> T getFromCache() {
        T t = cacheUtil.getElement(EhcacheUtil.CacheGroup.cache120Sec, "stationData");
        if (t != null) {
            System.out.println("get From cache");
            return t;
        } else {
            System.out.println("not get From cache");
            List<UbikeInfoDTO> value = this.getAllStationInfo();
            cacheUtil.addElement(EhcacheUtil.CacheGroup.cache120Sec, "stationData", value);
            return (T) value;
        }
    }

    private List<UbikeInfoDTO> getAllStationInfo() {

        List<UbikeInfoDTO> dataAll = new ArrayList<UbikeInfoDTO>();
        // Taipei
        List<UbikeInfoDTO> dataTaipei = cityStationData("Taipei");
        dataAll.addAll(dataTaipei);
        // NewTaipei
        List<UbikeInfoDTO> dataNewTaipei = cityStationData("NewTaipei");
        dataAll.addAll(dataNewTaipei);

        // Taoyuan
        List<UbikeInfoDTO> dataTaoyuan = cityStationData("Taoyuan");
        dataAll.addAll(dataTaoyuan);
        // Taichung
        List<UbikeInfoDTO> dataTaichung = cityStationData("Taichung");
        dataAll.addAll(dataTaichung);
        // Tainan
        List<UbikeInfoDTO> dataTainan = cityStationData("Tainan");
        dataAll.addAll(dataTainan);
        // Kaohsiung
        List<UbikeInfoDTO> dataKaohsiung = cityStationData("Kaohsiung");
        dataAll.addAll(dataKaohsiung);
        // ChanghuaCounty
        List<UbikeInfoDTO> dataChanghuaCounty = cityStationData("ChanghuaCounty");
        dataAll.addAll(dataChanghuaCounty);
        // PingtungCounty
        List<UbikeInfoDTO> dataPingtungCounty = cityStationData("PingtungCounty");
        dataAll.addAll(dataPingtungCounty);

        return dataAll;
    }

    private List<UbikeInfoDTO> cityStationData(String city) {
        JSONArray jsonArray = null;
        try {
            jsonArray = readJsonFromUrl("http://ptx.transportdata.tw/MOTC/v2/Bike/Station/" + city + "?$format=JSON");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<UbikeInfoDTO> data = new ArrayList<UbikeInfoDTO>();

        for (int i = 0; i < jsonArray.length(); i++) {
            UbikeInfoDTO e = new UbikeInfoDTO();
            JSONObject o = jsonArray.optJSONObject(i);
            e.setStationUID(o.getString("StationUID"));
            e.setStationID(o.getString("StationID"));
            e.setAuthorityID(o.getString("AuthorityID"));
            e.setStationName_Zh_tw(o.getJSONObject("StationName").getString("Zh_tw"));
//            e.setStationName_En(o.getJSONObject("StationName").getString("En"));
            e.setPositionLat(o.getJSONObject("StationPosition").getDouble("PositionLat"));
            e.setPositionLon(o.getJSONObject("StationPosition").getDouble("PositionLon"));
            e.setStationAddress_Zh_tw(o.getJSONObject("StationAddress").getString("Zh_tw"));
//            e.setStationAddress_En(o.getJSONObject("StationAddress").getString("En"));
            e.setBikesCapacity(o.getInt("BikesCapacity"));
//            e.setSrcUpdateTime(o.getString("SrcUpdateTime"));
            e.setUpdateTime(o.getString("UpdateTime"));
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
