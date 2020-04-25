package patitas.com.pe.veteriapp.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import patitas.com.pe.veteriapp.R;

public class DividingLineDecoration extends RecyclerView.ItemDecoration {
    private Drawable dividingLine;

    public DividingLineDecoration(Context context) {
        dividingLine = ContextCompat.getDrawable(context, R.drawable.dividing_line);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + dividingLine.getIntrinsicHeight();

            dividingLine.setBounds(left, top, right, bottom);
            dividingLine.draw(c);
        }
    }
}

