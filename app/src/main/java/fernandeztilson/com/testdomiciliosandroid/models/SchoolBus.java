package fernandeztilson.com.testdomiciliosandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tilson on 28/02/2018.
 */

public class SchoolBus {
    /**
     * Definimos una variable int
     */
    @SerializedName("id")
    @Expose
    private int id;
    /**
     * Definimos una variable String
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * Definimos una variable String
     */
    @SerializedName("description")
    @Expose
    private String description;
    /**
     * Definimos una variable String
     */
    @SerializedName("stops_url")
    @Expose
    private String stopsUrl;
    /**
     * Definimos una variable String
     */
    @SerializedName("img_url")
    @Expose
    private String imgUrl;

    /**
     * Obtenemos el valor de la variable id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Cambiamos el valor de la variable id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtenemos el valor de la variable name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Cambiamos el valor de la variable name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtenemos el valor de la variable description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambiamos el valor de la variable description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtenemos el valor de la variable stopsUrl
     * @return
     */
    public String getStopsUrl() {
        return stopsUrl;
    }

    /**
     * Cambiamos el valor de la variable stopsUrl
     * @param stopsUrl
     */
    public void setStopsUrl(String stopsUrl) {
        this.stopsUrl = stopsUrl;
    }

    /**Obtenemos el valor de la variable imgUrl
     *
     * @return
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Cambiamos el valor de la variable imgUrl
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * Obtenemos una variable String
     * @return
     */
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
