package fernandeztilson.com.testdomiciliosandroid.services;

import fernandeztilson.com.testdomiciliosandroid.models.Schools;
import fernandeztilson.com.testdomiciliosandroid.models.Stops;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tilson on 28/02/2018.
 */

public interface SchoolService {
    @GET("10yg1t")
    Call<Schools> getSchoolsList();

    @GET("{stop}")
    Call<Stops> getStopsList(@Path("stop") String stop);
}
