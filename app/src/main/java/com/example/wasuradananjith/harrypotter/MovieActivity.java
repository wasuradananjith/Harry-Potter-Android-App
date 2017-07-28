package com.example.wasuradananjith.harrypotter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieActivity extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Harry Potter and the Sorcerer's Stone",
            "Harry Potter and the Chamber of Secrets",
            "Harry Potter and the Prisoner of Azkaban",
            "Harry Potter and the Goblet of Fire",
            "Harry Potter and the Order of the Phoenix",
            "Harry Potter and the Half Blood Prince",
            "Harry Potter and the Deathly Hallows Part 1",
            "Harry Potter and the Deathly Hallows Part 2"
    };

    Integer[] imgid={
            R.drawable.hp1,
            R.drawable.hp2,
            R.drawable.hp3,
            R.drawable.hp4,
            R.drawable.hp5,
            R.drawable.hp6,
            R.drawable.hp7,
            R.drawable.hp8
    };

    String[] years={
            "2001",
            "2002",
            "2004",
            "2005",
            "2007",
            "2009",
            "2010",
            "2011"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadMain = new Intent(getBaseContext(),MainActivity.class);
                startActivity(loadMain);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                finish();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid, years);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        // Register the ListView  for Context menu
        registerForContextMenu(list);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                PopupMenu popup = new PopupMenu(MovieActivity.this, list);
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MovieActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                popup.show();
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.web:
                Uri uri = Uri.parse("https://en.wikipedia.org/wiki/Harry_Potter_(film_series)"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
                break;
            case  R.id.trailer:
                Uri uri2 = Uri.parse("https://www.youtube.com/watch?v=K1KPcXRMMo4"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
                //Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}
