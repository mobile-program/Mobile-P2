package com.example.mhmdreza_j.mobile_p2.network;

import com.example.mhmdreza_j.mobile_p2.Comment;
import com.example.mhmdreza_j.mobile_p2.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface PostService {
    @GET("posts")
    Call<PostsModel> getPosts();
    @GET("posts/{id}/comments")
    Call<CommentsModel> getPostComments(@Path("id") int id);
}
