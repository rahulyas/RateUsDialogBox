package com.example.rateusdialogbox;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;

public class RateusDialog extends Dialog {

    public RateusDialog(@NonNull Context context) {
        super(context);
    }

    AppCompatButton rate,later;
    AppCompatRatingBar ratingBar;
    ImageView imagerating;

    private float userRate = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus_dialog);

        rate = findViewById(R.id.ratenow);
        later = findViewById(R.id.later);
        ratingBar = findViewById(R.id.ratingbar);
        imagerating = findViewById(R.id.rating_image);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });

        later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hide rating dialog
                dismiss();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating <=1){
                    imagerating.setImageResource(R.drawable.angrey);
                }else if(rating <=2){
                    imagerating.setImageResource(R.drawable.sad);
                }else if (rating <=3){
                    imagerating.setImageResource(R.drawable.wipe);
                }else if(rating <=4){
                    imagerating.setImageResource(R.drawable.simle);
                }else if (rating <=5){
                    imagerating.setImageResource(R.drawable.simle);
                }

                // animate emoji image
                animateImage(imagerating);

                // select rating by user
                userRate = rating;
            }
        });
    }

    private void animateImage(ImageView imagerating){

        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,0,1f
                ,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        imagerating.startAnimation(scaleAnimation);

    }
}
