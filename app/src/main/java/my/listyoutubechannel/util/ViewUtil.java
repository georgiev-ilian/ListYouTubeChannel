package my.listyoutubechannel.util;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.TextView;

/**
 * Created by ilian.
 */
public final class ViewUtil {

    public static void setTextWithSpanLabel(TextView view, String label, String textString) {
        if (textString == null) {
            return;
        }

        final StyleSpan bold = new StyleSpan(android.graphics.Typeface.BOLD);
        final StyleSpan italic = new StyleSpan(android.graphics.Typeface.ITALIC);

        String text = label + " " + textString;

        final SpannableStringBuilder sb = new SpannableStringBuilder(text);
        sb.setSpan(bold, 0, label.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        sb.setSpan(italic, label.length(), text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        view.setText(sb);
    }
}
