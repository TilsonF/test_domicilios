package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tilson on 28/02/2018.
 */

public class SchoolBus {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("stops_url")
    @Expose
    private String stopsUrl;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStopsUrl() {
        return stopsUrl;
    }

    public void setStopsUrl(String stopsUrl) {
        this.stopsUrl = stopsUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "SchoolBus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stopsUrl='" + stopsUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
