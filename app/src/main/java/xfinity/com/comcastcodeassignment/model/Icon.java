package xfinity.com.comcastcodeassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Icon class is used to define the icon
 */
public class Icon implements Serializable {

    @SerializedName("URL")
    @Expose
    private String url;

    public Icon() {

    }

    public Icon(String url) {
        super();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
