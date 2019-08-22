package serdar.oz.loodostestapp.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.loodostestapp.R;
import serdar.oz.loodostestapp.model.MovieList;
import serdar.oz.loodostestapp.util.GlideUtil;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private final Context context;
    private final List<MovieList.Type> movieList;
    private final IMovieAdapter iMovieAdapter;


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivPoster)
        ImageView ivPoster;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvYear)
        TextView tvYear;
        @BindView(R.id.cvMovie)
        CardView cvMovie;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

    public MovieListAdapter(Context context, List<MovieList.Type> movieList, IMovieAdapter iMovieAdapter) {
        this.movieList = movieList;
        this.iMovieAdapter = iMovieAdapter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        MovieList.Type movie = movieList.get(position);
        try {
            if (movie.getPoster() != null && !movie.getPoster().isEmpty())
                Glide.with(context).applyDefaultRequestOptions(GlideUtil.glideOptions(context)).load(movie.getPoster()).into(holder.ivPoster);
            holder.tvTitle.setText(movie.getTitle());
            holder.tvType.setText(movie.getYear());
            holder.tvYear.setText(movie.getType().toUpperCase());
            holder.cvMovie.setOnClickListener(view -> iMovieAdapter.onMovieClicked(movieList.get(position).getİmdbID(), holder.ivPoster));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return (movieList == null) ? 0 : movieList.size();
    }

}