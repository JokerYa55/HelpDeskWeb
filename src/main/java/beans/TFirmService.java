package beans;
// Generated 06.07.2017 21:54:31 by Hibernate Tools 4.3.1



/**
 * TFirmService generated by hbm2java
 */
public class TFirmService  implements java.io.Serializable {


     private long id;
     private long FFirmId;
     private long FServiceId;

    public TFirmService() {
    }

    public TFirmService(long id, long FFirmId, long FServiceId) {
       this.id = id;
       this.FFirmId = FFirmId;
       this.FServiceId = FServiceId;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public long getFFirmId() {
        return this.FFirmId;
    }
    
    public void setFFirmId(long FFirmId) {
        this.FFirmId = FFirmId;
    }
    public long getFServiceId() {
        return this.FServiceId;
    }
    
    public void setFServiceId(long FServiceId) {
        this.FServiceId = FServiceId;
    }




}


