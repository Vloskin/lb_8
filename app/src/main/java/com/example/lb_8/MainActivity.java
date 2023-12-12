package com.example.lb_8;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOptionsMenu();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        registerForContextMenu(button2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.item_settings1)
        {
            Toast.makeText(this, "Пункт 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.item_settings2)
        {
            Toast.makeText(this, "Пункт 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_context1)
        {
            Toast.makeText(this, "Пункт 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.item_context2)
        {
            Toast.makeText(this, "Пункт 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            return super.onContextItemSelected(item);
        }
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId() == R.id.item_context1)
                {
                    Toast.makeText(MainActivity.this, "Пункт 1", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if (item.getItemId() == R.id.item_context2)
                {
                    Toast.makeText(MainActivity.this, "Пункт 2", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else
                {
                    return false;
                }

            }
        });
        popupMenu.show();
    }
}