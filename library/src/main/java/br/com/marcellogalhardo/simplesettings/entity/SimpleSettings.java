package br.com.marcellogalhardo.simplesettings.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleSettings implements Parcelable {

    public static final String BASE_URL = "SimpleSettings.BaseUrl";
    public static final String TIMEOUT = "SimpleSettings.Timeout";
    public static final String DEFAULT_BASE_URL = "SimpleSettings.DefaultBaseUrl";
    public static final String DEFAULT_TIMEOUT = "SimpleSettings.DefaultTimeout";
    public static final Parcelable.Creator<SimpleSettings> CREATOR = new Parcelable.Creator<SimpleSettings>() {
        @Override
        public SimpleSettings createFromParcel(Parcel source) {
            return new SimpleSettings(source);
        }

        @Override
        public SimpleSettings[] newArray(int size) {
            return new SimpleSettings[size];
        }
    };
    private String baseUrl;
    private int timeout;

    private SimpleSettings(Builder builder) {
        baseUrl = builder.baseUrl;
        timeout = builder.timeout;
    }

    protected SimpleSettings(Parcel in) {
        this.baseUrl = in.readString();
        this.timeout = in.readInt();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getTimeoutAsText() {
        return String.valueOf(timeout);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.baseUrl);
        dest.writeInt(this.timeout);
    }

    public static final class Builder {
        private String baseUrl;
        private int timeout;

        public Builder() {
        }

        public Builder baseUrl(String val) {
            baseUrl = val;
            return this;
        }

        public Builder timeout(int val) {
            timeout = val;
            return this;
        }

        public SimpleSettings build() {
            return new SimpleSettings(this);
        }
    }
}
