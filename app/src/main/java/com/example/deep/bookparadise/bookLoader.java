package com.example.deep.bookparadise;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * Created by Deep on 09-02-2018.
 */

public class bookLoader extends AsyncTaskLoader<List<bookData>> {
    private String mUrl;
    private static final String LOG_TAG = bookLoader.class.getSimpleName();

    public bookLoader(Context context, String url) {

        super(context);
        Log.i(LOG_TAG,"TEST: bookLoader() called...");
        // TODO: Finish implementing this constructor
        mUrl = url;

    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"TEST: onStartLoading() called...");

        forceLoad();

    }

    @Override
    public List<bookData> loadInBackground() {
        Log.i(LOG_TAG,"TEST: loadInBackground() called...");

        // TODO: Implement this method
        if (mUrl == null) {
            return null;
        }
        List<bookData> result = QueryUtils.fetchBookData(mUrl);

        return result;

    }
}