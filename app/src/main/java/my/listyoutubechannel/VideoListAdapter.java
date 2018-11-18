package my.listyoutubechannel;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import my.listyoutubechannel.data.VideoListItem;
import my.listyoutubechannel.data.service.Item;
import my.listyoutubechannel.databinding.VideoListItemBinding;

/**
 * Created by ilian.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    private List<Item> videoList;

    private LayoutInflater layoutInflater;

    VideoListAdapter(List<Item> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        VideoListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                                                               R.layout.video_list_item,
                                                               viewGroup,
                                                               false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = videoList.get(i);
        viewHolder.bind(item, createClickListener());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    private View.OnClickListener createClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("VideoListAdapter", "onClick: video");
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        VideoListItemBinding binding;

        ViewHolder(@NonNull VideoListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(Item item, View.OnClickListener clickListener) {
            binding.setClickListener(clickListener);
            VideoListItem videoListItem = new VideoListItem(item.getSnippet().getTitle(),
                                                            item.getSnippet()
                                                                .getThumbnails()
                                                                .getMedium()
                                                                .getUrl());
            binding.setItem(videoListItem);

            binding.executePendingBindings();
        }
    }
}
