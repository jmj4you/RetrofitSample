package in.easy2rent.jmj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jomon on 24/2/16.
 */
public interface GitHubClient {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
            @Path( "owner") String owner,
            @Path( "repo") String repo
    );

    // https://api.github.com/search/users?q=jmj4y
//    https://api.github.com/users/basil2style
    @GET("/users/{user}")
    Call<User> GetUser(@Query( "user") String owner
    );

    @GET("agent/list")
    Call<ApiResults> GetAgent();
}
