package my.listyoutubechannel;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import my.listyoutubechannel.data.VideoListItem;
import my.listyoutubechannel.databinding.VideoListItemBinding;

/**
 * Created by ilian.
 */
public class VideoListAdapter extends PagedListAdapter<VideoListItem, VideoListAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    VideoListAdapter() {
        super(VideoListItem.DIFF_CALLBACK);
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
        viewHolder.bind(getItem(i), createClickListener());
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    private View.OnClickListener createClickListener() {
        return view -> Log.d("VideoListAdapter", "onClick: video");
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        VideoListItemBinding binding;

        ViewHolder(@NonNull VideoListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(VideoListItem videoListItem, View.OnClickListener clickListener) {
            binding.setClickListener(clickListener);
            binding.setItem(videoListItem);
            binding.executePendingBindings();
        }
    }
}
