package com.filkom.aryodimas.bookit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailFragment extends Fragment implements View.OnClickListener{

    private TextView tv_movie_tittle,tv_movie_summary;
    private Button btn_book;
    private ImageView iv_movie_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv_movie_summary = view.findViewById(R.id.tv_summary_movie);
        tv_movie_tittle = view.findViewById(R.id.tv_movie_title);
        btn_book = view.findViewById(R.id.btn_book);
        iv_movie_image = view.findViewById(R.id.iv_movie_img);

        Bundle args = getArguments();
        if (args != null) {
            tv_movie_tittle.setText(args.get("MOVIE_TITLE").toString());
            tv_movie_summary.setText(args.get("MOVIE_SUMMARY").toString());
            Picasso.with(this.getContext()).load(args.get("MOVIE_IMAGE").toString()).fit().
                    into(iv_movie_image);
        }

        btn_book.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_book){
            Intent intent = new Intent(this.getContext(), BookFilmActivity.class);
                intent.putExtra("title", tv_movie_tittle.getText());
                intent.putExtra("duration", this.getContext().getString(R.string.movie_duration));
                startActivity(intent);
        }
    }
}
