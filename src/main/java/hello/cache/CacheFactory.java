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
public class CacheFactory {

    @Autowired
    EhcacheUtil cacheUtil;

    public <T> T getFromCache() {
        T t = cacheUtil.getElement(EhcacheUtil.CacheGroup.cache30Sec, "key");
        if (t != null) {
            System.out.println("get From cache");
            return t;
        } else {
            System.out.println("not get From cache");
            List<UbikeInfoDTO> value =  this.getUbikeInfo();
            cacheUtil.addElement(EhcacheUtil.CacheGroup.cache30Sec, "key", value);
            return (T) value;
        }
    }

    private List<UbikeInfoDTO> getUbikeInfo() {
        JSONObject json = null;
        try {
            json = readJsonFromUrl(
                    "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=ddb80380-f1b3-4f8e-8016-7ed9cba571d5");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = json.getJSONObject("result").getJSONArray("results");

        List<UbikeInfoDTO> data = new ArrayList<UbikeInfoDTO>();

        for (int i = 0; i < jsonArray.length(); i++) {
            UbikeInfoDTO e = new UbikeInfoDTO();
            JSONObject o = jsonArray.optJSONObject(i);
            e.setId(o.getString("_id"));
            e.setIid(o.getString("iid"));
            e.setSv(o.getString("sv"));
            e.setSd(o.getString("sd"));
            e.setVtyp(o.getString("vtyp"));
            e.setSno(o.getString("sno"));
            e.setSna(o.getString("sna"));
            e.setSip(o.getString("sip"));
            e.setTot(o.getString("tot"));
            e.setSbi(o.getString("sbi"));
            e.setSarea(o.getString("sarea"));
            e.setMday(o.getString("mday"));
            e.setLat(o.getDouble("lat"));
            e.setLng(o.getDouble("lng"));
            e.setAr(o.getString("ar"));
            e.setSareaen(o.getString("sareaen"));
            e.setSnaen(o.getString("snaen"));
            e.setAren(o.getString("aren"));
            e.setNbcnt(o.getString("nbcnt"));
            e.setBemp(o.getString("bemp"));
            e.setAct(o.getString("act"));
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

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
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

}
