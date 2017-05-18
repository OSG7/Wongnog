package com.studio.ligament.wongnog.data.models;

/**
 * Created by Ligament on 18/5/2560.
 */
import android.media.Image;
import android.widget.ImageView;

import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class UserFirebase {

    public String username;
    public String email;
    public ImageView imageView;

    public UserFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UserFirebase(String username, String email, ImageView imageView) {
        this.username = username;
        this.email = email;
        this.imageView = imageView;
    }

}
// [END blog_user_class]
