package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tilson on 28/02/2018.
 */

public class Stop {
    /**
     * Definimos una variable double
     */
    @SerializedName("lat")
    @Expose
    private double lat;
    /**
     * Definimos una variable double
     */
    @SerializedName("lng")
    @Expose
    private double lng;

    /**
     * Obtenemos una variable double
     *
     * @return
     */
    public double getLat() {
        return lat;
    }

    /**
     * Cambiamos el valor de la variable lat
     *
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Obtenemos una variable double
     *
     * @return
     */
    public double getLng() {
        return lng;
    }

    /**
     * Cambiamos el valor de la variable lng
     *
     * @param lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * Obtenemos una variable String
     *
     * @return
     */
    @Override
    public String toString() {
        return "Stop{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
