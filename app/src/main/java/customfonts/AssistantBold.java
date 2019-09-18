package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


public class AssistantBold extends TextView {

    public AssistantBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AssistantBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AssistantBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "../res/font/assistant_bold.ttf");
            setTypeface(tf);
        }
    }

}