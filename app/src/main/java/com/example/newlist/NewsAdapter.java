package com.example.newlist;
 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.ImageView;
 import android.widget.TextView;

 import androidx.recyclerview.widget.RecyclerView;

 import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter <NewsAdapter.ViewHolder > {

    private List<MainActivity.News> mNewsData;
    private Context mContext;
    private int resourceId;

    public NewsAdapter(Context context , int resourceId , List<MainActivity.News> data) {
         this.mContext = context;
         this.mNewsData = data;
         this.resourceId = resourceId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
         View view = LayoutInflater.from(mContext)
         .inflate(resourceId , parent , false);

         ViewHolder holder = new ViewHolder(view);
         return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder , int position) {
         MainActivity.News news = mNewsData.get(position);
         holder.tvTitle.setText(news.getTitle());
         holder.tvAuthor.setText(news.getAuthor());

         if (news.getImageId() != -1) {
            holder.ivImage.setImageResource(news.getImageId());
         }
    }

    @Override
    public int getItemCount() {
        return mNewsData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
        ImageView ivImage;

        public ViewHolder(View view) {
            super(view);

            tvTitle = view.findViewById(R.id.tv_title);
            tvAuthor = view.findViewById(R.id.tv_subtitle);
            ivImage = view.findViewById(R.id.iv_image);
        }
    }

}
