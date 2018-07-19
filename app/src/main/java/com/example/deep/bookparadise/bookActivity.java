package com.example.deep.bookparadise;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;



public class bookActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<bookData>> {
    private bookDataAdapter madapter;
    private List<bookData> mdata;
    private ListView bookListView;
    private Button searchIt;
    public static final String LOG_TAG = bookActivity.class.getSimpleName();
    private EditText search;
    private String searchSequence="";
    private boolean isClicked=false;
    private int mLoaderManagerId=1;

    private static  String BOOK_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        final LoaderManager mLoaderManager=getSupportLoaderManager();

            Log.i(LOG_TAG,"TEST: onCreate() called..."+mLoaderManager);
            setContentView(R.layout.activity_main);
            searchIt = (Button)findViewById(R.id.search_button);
        search = (EditText)findViewById(R.id.search_text);
        bookListView = (ListView)findViewById(R.id.list);

        searchIt =(Button)findViewById(R.id.search_button);
        searchIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!search.getText().equals(""))
                {
                    mLoaderManager.restartLoader(mLoaderManagerId, null,bookActivity.this);
                 mLoaderManager.initLoader(mLoaderManagerId,null,bookActivity.this);

                      }
            }
        });





    }
    String SEARCH_STATE="savedStateSearch";
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(SEARCH_STATE,search.getText().toString());
    }

    @Override
    public Loader<List<bookData>> onCreateLoader(int id, Bundle args) {
        Log.i(LOG_TAG,"TEST: onCreateLoader() called...");

        String[] searchTerms = search.getText().toString().split(" ");
        Uri baseUri = Uri.parse(BOOK_REQUEST_URL);
        for(int i =0;i<searchTerms.length;i++){
            searchSequence += searchTerms[i];
            if(i!=searchTerms.length-1)
                searchSequence +="+";
        }

        return new bookLoader(bookActivity.this, BOOK_REQUEST_URL+"="+searchSequence+"&maxResults=40");

    }


    @Override
    public void onLoadFinished(Loader<List<bookData>> loader, List<bookData> data) {
        Log.i(LOG_TAG,"TEST: onLoadFinished() called...");

        mdata = data;

        madapter = new bookDataAdapter(bookActivity.this, data);

        bookListView.setAdapter(madapter);

 }

    @Override
    public void onLoaderReset(Loader<List<bookData>> loader) {
        Log.i(LOG_TAG,"TEST: onLoaderReset() called...");

        madapter.clear();

          }


}

