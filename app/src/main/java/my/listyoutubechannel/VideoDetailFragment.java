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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import my.listyoutubechannel.data.Constants;
import my.listyoutubechannel.databinding.FragmentVideoDetailBinding;
import my.listyoutubechannel.util.Duration;
import my.listyoutubechannel.util.InjectorUtils;

import static my.listyoutubechannel.util.ViewUtil.setTextWithSpanLabel;

/**
 * Created by ilian.
 */
public class VideoDetailFragment extends Fragment {

    private static final String ARG_ITEM_ITEM = "item_id";

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
        setupViewModel(videoId, binding);

        binding.setLifecycleOwner(this);

        setHasOptionsMenu(false);

        return binding.getRoot();
    }

    private void setupViewModel(String videoId, FragmentVideoDetailBinding binding) {
        VideoDetailViewModelFactory factory = InjectorUtils.provideVideoDetailViewModelFactory(
                videoId);

        CommentListAdapter adapter = new CommentListAdapter();
        binding.commentList.setAdapter(adapter);

        VideoDetailViewModel viewModel = ViewModelProviders.of(this, factory).get(
                VideoDetailViewModel.class);

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

    public static VideoDetailFragment newInstance(String videoId) {
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ITEM, videoId);

        VideoDetailFragment fragment = new VideoDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @BindingAdapter("app:datePublishedText")
    public static void setDatePublished(TextView view, String datePublishedText) {
        if (datePublishedText != null && !datePublishedText.isEmpty()) {
            String text;

            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                                                               Locale.getDefault());
                SimpleDateFormat to = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());

                Date date = format.parse(datePublishedText);
                text = to.format(date);
            } catch (ParseException e) {
                text = datePublishedText;
            }

            String label =
                    view.getContext().getResources().getString(R.string.label_video_date_published);
            setTextWithSpanLabel(view, label, text);
        }
    }

    @BindingAdapter("app:commentTextDisplayText")
    public static void setCommentTextDisplayText(TextView view, String commentTextDisplayText) {
        view.setText(Html.fromHtml(commentTextDisplayText));
        view.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @BindingAdapter("app:durationText")
    public static void setDurationText(TextView view, String durationText) {
        if (durationText != null && !durationText.isEmpty()) {
            String label =
                    view.getContext().getResources().getString(R.string.label_video_duration);
            setTextWithSpanLabel(view, label, Duration.parse(durationText).toString());
        }
    }
}
