package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tilson on 28/02/2018.
 */

public class Stops {
    @SerializedName("response")
    @Expose
    private boolean response;
    @SerializedName("stops")
    @Expose
    private List<Stop> stops = null;
    @SerializedName("estimated_time_milliseconds")
    @Expose
    private int estimatedTimeMilliseconds;
    @SerializedName("retry_time_milliseconds")
    @Expose
    private int retryTimeMilliseconds;

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public int getEstimatedTimeMilliseconds() {
        return estimatedTimeMilliseconds;
    }

    public void setEstimatedTimeMilliseconds(int estimatedTimeMilliseconds) {
        this.estimatedTimeMilliseconds = estimatedTimeMilliseconds;
    }

    public int getRetryTimeMilliseconds() {
        return retryTimeMilliseconds;
    }

    public void setRetryTimeMilliseconds(int retryTimeMilliseconds) {
        this.retryTimeMilliseconds = retryTimeMilliseconds;
    }

    @Override
    public String toString() {
        return "Stops{" +
                "response=" + response +
                ", stops=" + stops +
                ", estimatedTimeMilliseconds=" + estimatedTimeMilliseconds +
                ", retryTimeMilliseconds=" + retryTimeMilliseconds +
                '}';
    }
}
