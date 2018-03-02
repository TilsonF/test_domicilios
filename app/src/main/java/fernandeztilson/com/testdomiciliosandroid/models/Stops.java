package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tilson on 28/02/2018.
 */

public class Stops {
    /**
     * Definimos una variable boolean
     */
    @SerializedName("response")
    @Expose
    private boolean response;
    /**
     * Definimos un objeto List<Stop>
     */
    @SerializedName("stops")
    @Expose
    private List<Stop> stops = null;
    /**
     * Definimos una variable int
     */
    @SerializedName("estimated_time_milliseconds")
    @Expose
    private int estimatedTimeMilliseconds;
    /**
     * Definimos una variable int
     */
    @SerializedName("retry_time_milliseconds")
    @Expose
    private int retryTimeMilliseconds;

    /**
     * Obtenemos una variable boolean
     *
     * @return
     */
    public boolean isResponse() {
        return response;
    }

    /**
     * Cambiamos el valor de la variable response
     *
     * @param response
     */
    public void setResponse(boolean response) {
        this.response = response;
    }

    /**
     * Obtenemos un objeto List<Stop>
     *
     * @return
     */
    public List<Stop> getStops() {
        return stops;
    }

    /**
     * Cambiamos el valor del objeto List<Stops>
     *
     * @param stops
     */
    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    /**
     * Obtenemos una variable int
     *
     * @return
     */
    public int getEstimatedTimeMilliseconds() {
        return estimatedTimeMilliseconds;
    }

    /**
     * Cambiamos el valor de la variable estimatedTimeMilliseconds
     *
     * @param estimatedTimeMilliseconds
     */
    public void setEstimatedTimeMilliseconds(int estimatedTimeMilliseconds) {
        this.estimatedTimeMilliseconds = estimatedTimeMilliseconds;
    }

    /**
     * Obtenemos una variable int
     *
     * @return
     */
    public int getRetryTimeMilliseconds() {
        return retryTimeMilliseconds;
    }

    /**
     * Cambiamos el valor de la variable retryTimeMilliseconds
     *
     * @param retryTimeMilliseconds
     */
    public void setRetryTimeMilliseconds(int retryTimeMilliseconds) {
        this.retryTimeMilliseconds = retryTimeMilliseconds;
    }

    /**
     * Obtenemos una variable String
     *
     * @return
     */
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
