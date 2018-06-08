package hello.dto;

public class UbikeInfoDTO {
    private String stationUID;
    private String stationID;
    private Integer servieAvailable;
    private Integer availableRentBikes;
    private Integer availableReturnBikes;
    private String srcUpdateTime;
    private String updateTime;
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
    public Integer getServieAvailable() {
        return servieAvailable;
    }
    public void setServieAvailable(Integer servieAvailable) {
        this.servieAvailable = servieAvailable;
    }
    public Integer getAvailableRentBikes() {
        return availableRentBikes;
    }
    public void setAvailableRentBikes(Integer availableRentBikes) {
        this.availableRentBikes = availableRentBikes;
    }
    public Integer getAvailableReturnBikes() {
        return availableReturnBikes;
    }
    public void setAvailableReturnBikes(Integer availableReturnBikes) {
        this.availableReturnBikes = availableReturnBikes;
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
        return "UbikeInfoDTO [stationUID=" + stationUID + ", stationID=" + stationID + ", servieAvailable=" + servieAvailable
                + ", availableRentBikes=" + availableRentBikes + ", availableReturnBikes=" + availableReturnBikes
                + ", srcUpdateTime=" + srcUpdateTime + ", updateTime=" + updateTime + "]";
    }
    
    


}
