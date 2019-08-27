package serdar.oz.loodostestapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import serdar.oz.loodostestapp.apiresponses.movieDetail.MovieDetail;
import serdar.oz.loodostestapp.apiresponses.trending.Trending;

public interface MovieApi {

    @GET("3/trending/{media_type}/{time_window}")
    Call<Trending> getTrendingList(@Path("media_type") String mediaType, @Path("time_window") String timeWindow, @Query("api_key") String apiKey);


    @GET("3/movie/{movie_id}")
    Call<MovieDetail> getMovieDetail(@Path("movie_id") long movieId, @Query("api_key") String apiKey);

}
