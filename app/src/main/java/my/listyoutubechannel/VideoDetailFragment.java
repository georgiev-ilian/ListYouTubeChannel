package my.listyoutubechannel;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ilian.
 */
public class VideoDetailFragment extends Fragment {

    private static final String ARG_ITEM_ITEM = "item_id";

    public static VideoDetailFragment newInstance(String videoId) {
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_ITEM, videoId);

        VideoDetailFragment fragment = new VideoDetailFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
