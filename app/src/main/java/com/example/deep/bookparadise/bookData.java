package com.example.deep.bookparadise;

/**
 * Created by Deep on 08-02-2018.
 */

/**
 * *class storing the attributes of a book object
 */
public class bookData {
    /**
     * stores the book name of a bookData object
     */
    private String mBookName;
    /**
     * stores the author's name of a book object if present
     */
    private String mAuthorName;
    /**
     * stores the Image attribute of an book  if present
     */
//    private String mImageUrl;

    /**
     * constructor to store the attributes of the bookData object using the following parameters:
     * @param BookName
     * @param AuthorName
//     * @param ImageUrl
     */

    public bookData(String BookName,String AuthorName/* ,String ImageUrl*/){
        mBookName = BookName;
        mAuthorName = AuthorName;
//        mImageUrl = ImageUrl;
    }

    /**
     *
     * Returns the name of the book
     */
    public String getBookName(){
        return mBookName;
    }

    /**
     *
     * Returns the authors name
     */
    public String getAuthorName(){
        return mAuthorName;
    }

    /**
     *
     * Returns the ImageUrl of the book
     */
//        public String getImageUrl(){
//        return mImageUrl;
//    }
}
