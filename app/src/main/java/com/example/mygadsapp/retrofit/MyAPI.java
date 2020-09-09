package com.example.mygadsapp.retrofit;

import android.database.Observable;

import com.example.mygadsapp.models.LearnerLeadersModel;
import com.example.mygadsapp.models.SkillIQModel;
import com.example.mygadsapp.models.SubmitForm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyAPI {

    @GET("/api/hours")
    Call<List<LearnerLeadersModel>> getHours();

    @GET("/api/skilliq")
    Call<List<SkillIQModel>> getSkilliq();

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<String> postUser(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String fname,
            @Field("entry.2006916086") String lname,
            @Field("entry.284483984") String link
            );

}
