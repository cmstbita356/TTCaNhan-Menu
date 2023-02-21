package com.example.btmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ActionMode mActionMode;
    PopupMenu popupMenu;

    ActionMode.Callback mActionModeCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            switch (item.getItemId()) {
                case R.id.contexttual_menu_share:
                    intent.putExtra("contextualmenu", "share");
                    mode.finish();
                    startActivity(intent);
                    return true;
                case R.id.contexttual_menu_delete:
                    intent.putExtra("contextualmenu", "delete");
                    mode.finish();
                    startActivity(intent);
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) return false;
                mActionMode = startActionMode(mActionModeCallBack);
                textView.setSelected(true);
                return true;
            }
        });

        Button button_popup = findViewById(R.id.button_popup);
        popupMenu = new PopupMenu(this, button_popup);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        button_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                switch (item.getItemId()) {
                    case R.id.popup_item1:
                        intent.putExtra("popupmenu", "item1");
                        startActivity(intent);
                        return true;
                    case R.id.popup_item2:
                        intent.putExtra("popupmenu", "item2");
                        startActivity(intent);
                        return true;
                    case R.id.popup_item3:
                        intent.putExtra("popupmenu", "item3");
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        int id = item.getItemId();
        switch (id) {
            case R.id.item2:
                intent.putExtra("optionmenu", "item2");
                startActivity(intent);
                return true;
            case R.id.supitem1:
                intent.putExtra("optionmenu", "subitem1");
                startActivity(intent);
                return true;
            case R.id.supitem2:
                intent.putExtra("optionmenu", "subitem2");
                startActivity(intent);
                return true;
            default:
                return false;

        }

    }
}