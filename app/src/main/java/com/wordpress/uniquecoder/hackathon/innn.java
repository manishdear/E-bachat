package com.wordpress.uniquecoder.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.TableRow;
import android.widget.TextView;

public class innn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innn);
        LinearLayout layout = findViewById(R.id.lay);
        TableLayout ti = new TableLayout(this);
        TableRow head = new TableRow(this);
        for (int i = 0; i < 9; i++) {
            TextView col_head = new TextView(this);

            switch (i) {
                case 0:
                    col_head.setText("S. No.");
                    break;
                case 1:
                    col_head.setText("Name");
                    break;
                case 2:
                    col_head.setText("Qty.");
                    break;
                case 3:
                    col_head.setText("Rate");
                    break;
                case 4:
                    col_head.setText("CGST");
                    break;
                case 5:
                    col_head.setText("SGST");
                    break;
                case 6:
                    col_head.setText("Units");
                    break;
                case 7:
                    col_head.setText("Total");
                    break;
                case 8:
                    col_head.setText("HSN");
                    break;
            }
            col_head.setPadding(8, 4, 8, 4);
            head.addView(col_head);
        }
        ti.addView(head);
        layout.addView(ti);

    }}
