package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tilson on 28/02/2018.
 */

public class Schools {
    @SerializedName("response")
    @Expose
    private boolean response;
    @SerializedName("school_buses")
    @Expose
    private List<SchoolBus> schoolBuses = null;

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public List<SchoolBus> getSchoolBuses() {
        return schoolBuses;
    }

    public void setSchoolBuses(List<SchoolBus> schoolBuses) {
        this.schoolBuses = schoolBuses;
    }

    @Override
    public String toString() {
        return "Schools{" +
                "response=" + response +
                ", schoolBuses=" + schoolBuses +
                '}';
    }
}
