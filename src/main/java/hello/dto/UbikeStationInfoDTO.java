package hello.dto;

public class UbikeStationInfoDTO {

    private String city;
    private String stationUID;
    private String stationID;
    private String authorityID;
    private String stationName_Zh_tw;
    private String stationName_En;
    private Double positionLat;
    private Double positionLon;
    private String stationAddress_Zh_tw;
    private String stationAddress_En;
    private Integer bikesCapacity;
    private String srcUpdateTime;
    private String updateTime;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStationUID() {
        return stationUID;
    }

    public void setStationUID(String stationUID) {
        this.stationUID = stationUID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getAuthorityID() {
        return authorityID;
    }

    public void setAuthorityID(String authorityID) {
        this.authorityID = authorityID;
    }

    public String getStationName_Zh_tw() {
        return stationName_Zh_tw;
    }

    public void setStationName_Zh_tw(String stationName_Zh_tw) {
        this.stationName_Zh_tw = stationName_Zh_tw;
    }

    public String getStationName_En() {
        return stationName_En;
    }

    public void setStationName_En(String stationName_En) {
        this.stationName_En = stationName_En;
    }

    public Double getPositionLat() {
        return positionLat;
    }

    public void setPositionLat(Double positionLat) {
        this.positionLat = positionLat;
    }

    public Double getPositionLon() {
        return positionLon;
    }

    public void setPositionLon(Double positionLon) {
        this.positionLon = positionLon;
    }

    public String getStationAddress_Zh_tw() {
        return stationAddress_Zh_tw;
    }

    public void setStationAddress_Zh_tw(String stationAddress_Zh_tw) {
        this.stationAddress_Zh_tw = stationAddress_Zh_tw;
    }

    public String getStationAddress_En() {
        return stationAddress_En;
    }

    public void setStationAddress_En(String stationAddress_En) {
        this.stationAddress_En = stationAddress_En;
    }

    public Integer getBikesCapacity() {
        return bikesCapacity;
    }

    public void setBikesCapacity(Integer bikesCapacity) {
        this.bikesCapacity = bikesCapacity;
    }

    public String getSrcUpdateTime() {
        return srcUpdateTime;
    }

    public void setSrcUpdateTime(String srcUpdateTime) {
        this.srcUpdateTime = srcUpdateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UbikeInfoDTO [city=" + city + ", stationUID=" + stationUID + ", stationID=" + stationID + ", authorityID="
                + authorityID + ", stationName_Zh_tw=" + stationName_Zh_tw + ", stationName_En=" + stationName_En
                + ", positionLat=" + positionLat + ", positionLon=" + positionLon + ", stationAddress_Zh_tw="
                + stationAddress_Zh_tw + ", stationAddress_En=" + stationAddress_En + ", bikesCapacity=" + bikesCapacity
                + ", srcUpdateTime=" + srcUpdateTime + ", updateTime=" + updateTime + "]";
    }

}
