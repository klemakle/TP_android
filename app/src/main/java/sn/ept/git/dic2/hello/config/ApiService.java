package sn.ept.git.dic2.hello.config;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import sn.ept.git.dic2.hello.Models.Personne;

public interface ApiService {
    @GET("/api/{key}/personnes")
    public Call<List<Personne>> getAllPersonnes(@Path("key") String key);

    @GET("/api/{key}/personnes/{email}")
    public Call<List<Personne>> getOnePersonne(@Path("key") String key, @Path("email") String email);

    @PUT("/api/{key}/personnes")
    public Call<Personne> addPersonne(@Path("key") String key, @Body Personne newPersonne);

    @PUT("/api/{key}/personnes/{email}")
    public Call<Personne> updatePersonne(@Path("key") String key, @Path("email") String email, @Body Personne personne);

    @DELETE("api/{key}/personnes/{email}")
    public Call<Void> deletePersonne(@Path("key") String key, @Path("email") String email);
}
