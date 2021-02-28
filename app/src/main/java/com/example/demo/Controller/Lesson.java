package com.example.demo.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Lesson extends AppCompatActivity {
    LessonListAdapter adapter;
    ImageButton quizButton;
    ImageButton repeatButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        Intent lessonIntent = getIntent();
        lessonName.setText(lessonIntent.getStringExtra("lessonName"));



        String[] examples = lessonToExamples.get(lessonIntent.getStringExtra("lessonName"));
        ImageView exampleImage;
        TextView exampleDescription;
        int imageRes;
        String answer;
        int[] imagesId = new int[] {R.id.imageLeft, R.id.imageMid, R.id.imageRight};
        int[] descriptionId = new int[] {R.id.myImageViewTextLeft, R.id.myImageViewTextMid, R.id.myImageViewTextRight};
        for (int i = 0; i < 3; i++) {
            exampleImage = (ImageView) findViewById(imagesId[i]);
            exampleDescription = (TextView) findViewById(descriptionId[i]);
            answer = examples[i];
            imageRes = getResources().getIdentifier(String.format("@drawable/%s", answer), null, getPackageName());
            exampleImage.setImageResource(imageRes);
            exampleDescription.setText(answer);

        }

        buttonVisibility();
    }

    Map<String, String[]> lessonToExamples= new HashMap<String, String[]>() {{
        put("c", new String[] {"cat", "canary", "cake"});
        //put("c", new String[] {"celery", "face", "balance"});
        put("g", new String[] {"goose", "goat", "gold"});
        //put("g", new String[] {"frog", "plug", "bug"});
        //put("g", new String[] {"giraffe", "gingerbread man", "fridge"});

        put("scr", new String[] {"scrub", "scratch", "scream"});
        put("spl", new String[] {"split", "splat", "splash"});
        put("spr", new String[] {"spread", "spruce", "sprain"});
        put("str", new String[] {"strong", "straw", "string"});

        put("gh", new String[] {"high", "right", "eight"});
        put("kn", new String[] {"knot", "knee", "knit"});
        put("sc", new String[] {"scent", "scene", "science"});
        put("wr", new String[] {"wrap", "write", "wrong"});

        put("ai", new String[] {"tail", "nail", "rainbow"});
        put("au", new String[] {"haul", "gauze", "faucet"});
        put("aw", new String[] {"saw", "hawk", "paws"});
        put("ay", new String[] {"jay", "ray", "play"});
        put("ea", new String[] {"eat", "beak", "leaf"});
        //put("ea", new String[] {"head", "bear", "pears"});
        put("ee", new String[] {"bee", "tree", "jeep"});
        put("ew", new String[] {"flew", "blew", "chew"});
        put("oa", new String[] {"goat", "boat", "coat"});
        put("oi", new String[] {"coin", "point", "choice"});
        put("oo", new String[] {"zoo", "moon", "hoof"});
        //put("oo", new String[] {"cook", "woof", "foot"});
        put("ou", new String[] {"house", "mouth", "proud"});
        put("ow", new String[] {"blow", "snow", "throw"});
        //put("ow", new String[] {"owl", "cow", "town"});
        put("oy", new String[] {"boy", "toys", "oyster"});

        put("ar", new String[] {"arm", "stars", "barn"});
        //put("ar", new String[] {"bare", "mare", "hare"});
        put("er", new String[] {"fern", "tiger", "zipper"});
        put("ir", new String[] {"bird", "girl", "shirt"});
        put("or", new String[] {"corn", "horns", "orca"});
        //put("or", new String[] {"work", "worms", "tractor"});
        put("ur", new String[] {"burn", "surf", "nurse"});

        put("a", new String[] {"sofa", "zebra", "afraid"});
        put("e", new String[] {"camel", "oven", "kitten"});
        put("i", new String[] {"rabbit", "pencil", "robin"});
        put("o", new String[] {"lion", "oven", "wagon"});
        put("u", new String[] {"bug", "bus", "cut"});

    }};

    public void onHome(View view) {
        Intent home = new Intent(Lesson.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) { onBackPressed(); }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }
}
