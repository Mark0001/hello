package hello.dto;

public class UbikeInfoDTO {

    private String id;
    private String iid;
    private String sv;
    private String sd;
    private String vtyp;
    private String sno;
    private String sna;
    private String sip;
    private String tot;
    private String sbi;
    private String sarea;
    private String mday;
    private Double lat;
    private Double lng;
    private String ar;
    private String sareaen;
    private String snaen;
    private String aren;
    private String nbcnt;
    private String bemp;
    private String act;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getSv() {
        return sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getVtyp() {
        return vtyp;
    }

    public void setVtyp(String vtyp) {
        this.vtyp = vtyp;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSna() {
        return sna;
    }

    public void setSna(String sna) {
        this.sna = sna;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getTot() {
        return tot;
    }

    public void setTot(String tot) {
        this.tot = tot;
    }

    public String getSbi() {
        return sbi;
    }

    public void setSbi(String sbi) {
        this.sbi = sbi;
    }

    public String getSarea() {
        return sarea;
    }

    public void setSarea(String sarea) {
        this.sarea = sarea;
    }

    public String getMday() {
        return mday;
    }

    public void setMday(String mday) {
        this.mday = mday;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getSareaen() {
        return sareaen;
    }

    public void setSareaen(String sareaen) {
        this.sareaen = sareaen;
    }

    public String getSnaen() {
        return snaen;
    }

    public void setSnaen(String snaen) {
        this.snaen = snaen;
    }

    public String getAren() {
        return aren;
    }

    public void setAren(String aren) {
        this.aren = aren;
    }

    public String getNbcnt() {
        return nbcnt;
    }

    public void setNbcnt(String nbcnt) {
        this.nbcnt = nbcnt;
    }

    public String getBemp() {
        return bemp;
    }

    public void setBemp(String bemp) {
        this.bemp = bemp;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    @Override
    public String toString() {
        return "UbikeInfoDTO [id=" + id + ", iid=" + iid + ", sv=" + sv + ", sd=" + sd + ", vtyp=" + vtyp + ", sno=" + sno
                + ", sna=" + sna + ", sip=" + sip + ", tot=" + tot + ", sbi=" + sbi + ", sarea=" + sarea + ", mday=" + mday
                + ", lat=" + lat + ", lng=" + lng + ", ar=" + ar + ", sareaen=" + sareaen + ", snaen=" + snaen + ", aren=" + aren
                + ", nbcnt=" + nbcnt + ", bemp=" + bemp + ", act=" + act + "]";
    }

}
