package com.example.mhmdreza_j.mobile_p2.network;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mhmdreza_j.mobile_p2.Comment;
import com.example.mhmdreza_j.mobile_p2.CommentActivity;
import com.example.mhmdreza_j.mobile_p2.MainActivity;
import com.example.mhmdreza_j.mobile_p2.Post;
import com.example.mhmdreza_j.mobile_p2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Utility {
    public static final String POST_ID = "POST_ID";

    public static View getListViewItem(final Context context, ViewGroup viewGroup, final Post post) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_view, viewGroup);
        TextView titleTextView = inflate.findViewById(R.id.title);
        TextView bodyTextView = inflate.findViewById(R.id.body);
        titleTextView.setText(post.getTitle());
        bodyTextView.setText(post.getBody());
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCommentActivity(context, post);
            }
        });
        return inflate;
    }

    public static View getCommentListViewItem(final Context context, ViewGroup viewGroup, final Comment comment) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_view, viewGroup);
        TextView nameTextView = inflate.findViewById(R.id.name);
        TextView bodyTextView = inflate.findViewById(R.id.body);
        nameTextView.setText(comment.getName());
        bodyTextView.setText(comment.getBody());
        return inflate;
    }

    private static void openCommentActivity(Context context, Post post) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra(POST_ID, post.getPostId());
    }

}
