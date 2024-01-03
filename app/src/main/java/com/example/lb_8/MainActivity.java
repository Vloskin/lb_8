package com.example.lb_8;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.ContextMenu);
        registerForContextMenu(textView);


        Button button = findViewById(R.id.popupMenuButton);
        button.setOnClickListener(viewClickListener);


    }
// Create Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getItemId() == R.id.menu_item1 ) {
            Toast.makeText(this, "Выбран пункт 1", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menu_item2) {
            Toast.makeText(this, "Выбран пункт 2", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menu_item3) {
            Toast.makeText(this, "Выбран пункт 3", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }


    //create Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Пункт 1");
        menu.add(0, 1, 1, "Пункт 2");
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {


        if(item.getItemId() == 0 ) {
            Toast.makeText(this, "Выбран пункт 1", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == 1) {
            Toast.makeText(this, "Выбран пункт 2", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }

//Create popup menu
View.OnClickListener viewClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showPopupMenu(v);
    }
};

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popup_menu);

        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        if(item.getItemId() == R.id.menu1 ) {
                            Toast.makeText(getApplicationContext(), "Выбран пункт 1", Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.menu2) {
                            Toast.makeText(getApplicationContext(), "Выбран пункт 2", Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.menu3) {
                            Toast.makeText(getApplicationContext(), "Выбран пункт 3", Toast.LENGTH_SHORT).show();
                        }
                                return false;
                    }
                });
        popupMenu.show();
    }
}