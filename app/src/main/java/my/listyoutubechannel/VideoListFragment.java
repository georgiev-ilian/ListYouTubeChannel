package my.listyoutubechannel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view = inflater.inflate(R.layout.fragment_video_list, container, false);

        VideoListViewModelFactory factory = InjectorUtils.provideVideoListViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(VideoListViewModel.class);

        adapter = new VideoListAdapter();
        final RecyclerView recyclerView = view.findViewById(R.id.channel_list);
        recyclerView.setAdapter(adapter);

        viewModel.getListLiveData().observe(this, adapter::submitList);

        setHasOptionsMenu(false);

        return view;
    }
}
