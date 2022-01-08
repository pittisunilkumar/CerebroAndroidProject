package com.example.cerebro;


import java.util.Date;

public class Root {
    public boolean success;
    public Data data;
    public Date lastRefreshed;
    public Date lastOriginUpdate;

    public Root(boolean success, Data data, Date lastRefreshed, Date lastOriginUpdate) {
        this.success = success;
        this.data = data;
        this.lastRefreshed = lastRefreshed;
        this.lastOriginUpdate = lastOriginUpdate;
    }

    public Root() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Date getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(Date lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public Date getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(Date lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }
}
