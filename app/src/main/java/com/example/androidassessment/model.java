package com.example.androidassessment;

public class model {

    private String status;
    private String title ;
    private String imageURL ;
    private String success_url ;

    public model ( String status , String title , String imageURL , String success_url ) {
        this.status = status;
        this.title = title;
        this.imageURL = imageURL;
        this.success_url = success_url;
    }

    @Override
    public String toString () {
        return "model{" +
                "status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", success_url='" + success_url + '\'' +
                '}';
    }

    public String getStatus () {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getImageURL () {
        return imageURL;
    }

    public void setImageURL ( String imageURL ) {
        this.imageURL = imageURL;
    }

    public String getSuccess_url () {
        return success_url;
    }

    public void setSuccess_url ( String success_url ) {
        this.success_url = success_url;
    }
}
