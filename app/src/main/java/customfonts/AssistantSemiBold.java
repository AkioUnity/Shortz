package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class AssistantSemiBold extends TextView {

    public AssistantSemiBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AssistantSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AssistantSemiBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/assistant_semibold.ttf");
            setTypeface(tf);
        }
    }

}