package com.studio.ligament.wongnog.view.components;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.activities.UserProfileActivity;
import com.studio.ligament.wongnog.data.models.User;
import com.studio.ligament.wongnog.view.Transition;

public class RecipeUserView extends FrameLayout {

//    @Bind(R.id.user_image)
//    ImageView userImageView;
//    @Bind(R.id.user_name_text)
//    TextView userNameTextView;

    public RecipeUserView(Context context) {
        super(context);
        setup();
    }

    public RecipeUserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public RecipeUserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_recipe_user, this);
        ButterKnife.bind(this);
    }

    public void setUser(User user) {
//        userNameTextView.setText(user.name());
//        userImageView.setImageDrawable(getResources().getDrawable(R.drawable.user));
        setOnClickListener(view -> {
            Activity activity = (Activity) getContext();
            UserProfileActivity.launch(activity, user, Transition.PUSH_RIGHT_TO_LEFT);
        });
    }
}
