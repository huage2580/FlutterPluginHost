package com.hua.flutterpluginhost;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMain;
    Button btnPage2;
    Button btnCache;
    Button btnToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = findViewById(R.id.btn_main);
        btnPage2 = findViewById(R.id.btn_page2);
        btnCache = findViewById(R.id.btn_cache);
        btnToken = findViewById(R.id.btn_token);
        btnMain.setOnClickListener(v -> {
            startActivity(
                    FlutterActivity
                            .withNewEngine()
                            .initialRoute("home")
                            .build(this)
            );
        });
        btnPage2.setOnClickListener(v -> {
            startActivity(
                    FlutterActivity
                            .withNewEngine()
                            .initialRoute("page2")
                            .build(this)
                            .setClass(this,FlutterHostActivity.class)
            );
        });
        btnCache.setOnClickListener(v -> {
            startActivity(FlutterActivity
                    .withCachedEngine("flutter")
                    .build(this));
        });
        btnToken.setOnClickListener(v -> {
            startActivity(
                    FlutterActivity
                            .withNewEngine()
                            .initialRoute("home?hello=world")
                            .build(this)
                            .putExtra("background_mode","transparent")
//                            .setClass(this,FlutterHostActivity.class)
            );
        });
    }
}
