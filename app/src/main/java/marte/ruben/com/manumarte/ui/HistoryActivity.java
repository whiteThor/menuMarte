package marte.ruben.com.manumarte.ui;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Stack;

import marte.ruben.com.manumarte.R;;
import marte.ruben.com.manumarte.model.Page;
import marte.ruben.com.manumarte.model.Story;

public class HistoryActivity extends AppCompatActivity {

    TextView mTextViewContent ;
    ImageView mImageViewContent;
    Button mButtonChoice1;
    Button mButtonChoice2;
    Story mStory = new Story();
    Stack<Integer> pageStack = new Stack<Integer>();
    String name ;
    final String TAG = HistoryActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mTextViewContent = findViewById(R.id.textViewContentHistory) ;
        mImageViewContent = findViewById(R.id.imageViewContentHistory);
        mButtonChoice1 = findViewById(R.id.choiceButton1);
        mButtonChoice2 = findViewById(R.id.choiceButton2);
        name = getIntent().getStringExtra(getString(R.string.key));
        if(name.isEmpty()){
            name = getString(R.string.Guest_Text);
        }

        loadPage(0);
    }

    private void loadPage(int numPage) {
        pageStack.push(numPage);
        Page page =  mStory.getPage(numPage);
        Drawable drawable = ContextCompat.getDrawable(this,page.getImageId());
        mImageViewContent.setImageDrawable(drawable);

        String text = getText(page.getTextId()).toString() ;
        text = String.format(text, name);
        mTextViewContent.setText(text);
        if(page.isFinalPage()){
            mButtonChoice1.setVisibility(View.INVISIBLE);
            mButtonChoice2.setText(R.string.Nueva_aventura);
            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(0);
                }
            });
        }else {
            loadButton(page);
        }

    }

    private void loadButton(final Page page) {
        mButtonChoice1.setVisibility(View.VISIBLE);
        mButtonChoice2.setVisibility(View.VISIBLE);
        mButtonChoice1.setText(getText(page.getChoise1().getTextId()));
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPage(page.getChoise1().getNextPage());
            }
        });

        mButtonChoice2.setText(getText(page.getChoise2().getTextId()));
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPage(page.getChoise2().getNextPage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()) {
            super.onBackPressed();
        }else{
            loadPage(pageStack.pop());
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Story story = new Story();
        MenuItem menuItem = menu.add(1,R.string.acerca,Menu.NONE, R.string.acerca);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem.setIcon(R.drawable.ic_adb_black_24dp);
        menuItem.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);


        for (Page p : story.pages) {
            menu.add(1,p.getMenu(),Menu.NONE,p.getMenu());

        }
        menu.add(2, 0, Menu.NONE, "Exit");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
  /*      Toast.makeText(HistoryActivity.this, item.getItemId()+"",Toast.LENGTH_LONG).show();
        Toast.makeText(HistoryActivity.this, item.getTitle()+"",Toast.LENGTH_LONG).show(); */


        switch (item.getItemId()){
            case R.string.cap0:
                loadPage(0);
                return true;
            case R.string.cap1:
                loadPage(1);
                return true;
            case R.string.cap2:
                loadPage(2);
                return true;
            case R.string.cap3:
                loadPage(3);
                return true;
            case R.string.cap4:
                loadPage(4);
                return true;
            case R.string.cap5:
                loadPage(5);
                return true;
            case R.string.cap6:
                loadPage(6);
                return true;
            case 0:
                super.onBackPressed();
                return true;
            case R.string.acerca:
                acercaDe();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void acercaDe() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
        builder.setTitle(R.string.acerca_title);
        builder.setMessage(R.string.acerca_text);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        Log.d("HistoryActivity.class","Entro acerca de");

    }
}
