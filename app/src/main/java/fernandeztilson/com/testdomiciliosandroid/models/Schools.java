package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tilson on 28/02/2018.
 */

public class Schools {
    /**
     * Definimos una variable boolean
     */
    @SerializedName("response")
    @Expose
    private boolean response;
    /**
     * Definimos un objeto List<SchoolBus>
     */
    @SerializedName("school_buses")
    @Expose
    private List<SchoolBus> schoolBuses = null;

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
     * Obtenemos un objeto List<SchoolBus>
     *
     * @return
     */
    public List<SchoolBus> getSchoolBuses() {
        return schoolBuses;
    }

    /**
     * Cambiamos el valor del objeto schoolBuses
     *
     * @param schoolBuses
     */
    public void setSchoolBuses(List<SchoolBus> schoolBuses) {
        this.schoolBuses = schoolBuses;
    }

    /**
     * Ottenemos una variable String
     *
     * @return
     */
    @Override
    public String toString() {
        return "Schools{" +
                "response=" + response +
                ", schoolBuses=" + schoolBuses +
                '}';
    }
}
