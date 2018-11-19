package my.listyoutubechannel;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import my.listyoutubechannel.data.Constants;
import my.listyoutubechannel.databinding.FragmentVideoListBinding;
import my.listyoutubechannel.util.InjectorUtils;

/**
 * Created by ilian.
 */
public class VideoListFragment extends Fragment {

    private VideoListViewModel viewModel;

    private VideoListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentVideoListBinding binding = DataBindingUtil.inflate(inflater,
                                                                   R.layout.fragment_video_list,
                                                                   container,
                                                                   false);

        VideoListViewModelFactory factory = InjectorUtils.provideVideoListViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(VideoListViewModel.class);

        binding.setLifecycleOwner(this);

        adapter = new VideoListAdapter();
        binding.channelList.setAdapter(adapter);

        viewModel.getListLiveData().observe(this, adapter::submitList);

        setHasOptionsMenu(false);

        viewModel.getProgressLoadStatus().observe(this, status -> {
            if (Objects.requireNonNull(status).equalsIgnoreCase(Constants.LOADING)) {
                binding.progress.setVisibility(View.VISIBLE);
            } else if (status.equalsIgnoreCase(Constants.LOADED)) {
                binding.progress.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }
}
