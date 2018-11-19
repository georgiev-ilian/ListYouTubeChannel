package my.listyoutubechannel;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import my.listyoutubechannel.data.Constants;
import my.listyoutubechannel.databinding.FragmentVideoDetailBinding;
import my.listyoutubechannel.util.InjectorUtils;

import static my.listyoutubechannel.util.ViewUtil.setTextWithSpanLabel;

/**
 * Created by ilian.
 */
public class VideoDetailFragment extends Fragment {

    private static final String ARG_ITEM_ITEM = "item_id";

    private VideoDetailViewModel viewModel;

    private CommentListAdapter adapter;

    public static VideoDetailFragment newInstance(String videoId) {
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ITEM, videoId);

        VideoDetailFragment fragment = new VideoDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentVideoDetailBinding binding = DataBindingUtil.inflate(inflater,
                                                                     R.layout.fragment_video_detail,
                                                                     container,
                                                                     false);
        String videoId = VideoDetailFragmentArgs.fromBundle(getArguments()).getVideoId();
        setupViemModel(videoId, binding);

        binding.setLifecycleOwner(this);

        setHasOptionsMenu(false);

        return binding.getRoot();
    }

    private void setupViemModel(String videoId, FragmentVideoDetailBinding binding) {
        VideoDetailViewModelFactory factory = InjectorUtils.provideVideoDetailViewModelFactory(
                videoId);

        adapter = new CommentListAdapter();
        binding.commentList.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this, factory).get(VideoDetailViewModel.class);

        viewModel.getListLiveData().observe(this, adapter::submitList);
        viewModel.getVideoDetail().observe(this, binding::setVideoDetail);

        viewModel.getProgressLoadStatus().observe(this, status -> {
            if (Objects.requireNonNull(status).equalsIgnoreCase(Constants.LOADING)) {
                binding.progress.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase(Constants.LOADED)) {
                binding.progress.setVisibility(View.GONE);
            }
        });
    }

    @BindingAdapter("app:datePublishedText")
    public static void setDatePublished(TextView view, String datePublishedText) {
        if (datePublishedText != null) {
            setTextWithSpanLabel(view, datePublishedText);
        }
    }

    @BindingAdapter("app:commentTextDisplayText")
    public static void setCommentTextDisplayText(TextView view, String commentTextDisplayText) {
        view.setText(Html.fromHtml(commentTextDisplayText));
        view.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
