package com.example.mhmdreza_j.mobile_p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mhmdreza_j.mobile_p2.network.CommentsModel;
import com.example.mhmdreza_j.mobile_p2.network.PostProvider;
import com.example.mhmdreza_j.mobile_p2.network.Utility;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout listView = findViewById(R.id.listView);
        setContentView(R.layout.activity_comment);
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        int postID = getIntent().getExtras().getInt(Utility.POST_ID);
        PostProvider provider = new PostProvider();
        provider.getService().getPostComments(postID).enqueue(new Callback<CommentsModel>() {
            @Override
            public void onResponse(Call<CommentsModel> call, Response<CommentsModel> response) {
                if (response.body() == null) return;
                ArrayList<Comment> comments = response.body().getComments();
                for (Comment comment:comments) {
                    View commentListViewItem = Utility.getCommentListViewItem(getParent(), listView, comment);
                    listView.addView(commentListViewItem);
                }
            }

            @Override
            public void onFailure(Call<CommentsModel> call, Throwable t) {

            }
        });
    }
}
