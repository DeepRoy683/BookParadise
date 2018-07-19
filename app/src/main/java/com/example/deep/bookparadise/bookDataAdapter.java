package com.example.deep.bookparadise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Deep on 08-02-2018.
 */

public class bookDataAdapter extends ArrayAdapter<bookData> {
public bookDataAdapter(Context context, List<bookData> BookData){
   super(context,0,BookData);
}
public View getView(int position , View convertView, ViewGroup parent){
    View listItemView = convertView;
    if(listItemView==null){
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
    }
    bookData currentbookData = getItem(position);

    TextView title = (TextView)listItemView.findViewById(R.id.title_of_book);
    title.setText(currentbookData.getBookName());
    TextView author = (TextView)listItemView.findViewById(R.id.author_of_book);
    author.setText(currentbookData.getAuthorName());
//    CircleImageView image= (CircleImageView)listItemView.findViewById(R.id.book_image);
//    image.setImageURI(Uri.parse(currentbookData.getImageUrl()));
     return listItemView;
}
}
