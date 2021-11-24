package interfaces;

import java.util.List;

import model.ApiModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<ApiModel>> getList();
}
