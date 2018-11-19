package my.listyoutubechannel;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import my.listyoutubechannel.data.CommentItem;
import my.listyoutubechannel.databinding.CommentListItemBinding;

/**
 * Created by ilian.
 */
public class CommentListAdapter
        extends PagedListAdapter<CommentItem, CommentListAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;

    CommentListAdapter() {
        super(CommentItem.DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public CommentListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        CommentListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                                                                 R.layout.comment_list_item,
                                                                 viewGroup,
                                                                 false);

        return new CommentListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final CommentItem commentListItem = getItem(i);
        viewHolder.bind(commentListItem);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CommentListItemBinding binding;

        ViewHolder(@NonNull CommentListItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(CommentItem commentListItem) {
            binding.setItem(commentListItem);
            binding.executePendingBindings();
        }
    }
}
