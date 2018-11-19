package my.listyoutubechannel;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
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
        final VideoListItem videoListItem = getItem(i);
        viewHolder.bind(videoListItem, createClickListener(videoListItem.getId()));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    private View.OnClickListener createClickListener(String videoId) {
        return view -> {
            VideoListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment direction =
                    VideoListFragmentDirections.actionPlantListFragmentToPlantDetailFragment(videoId);
            Navigation.findNavController(view).navigate(direction);
        };
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
