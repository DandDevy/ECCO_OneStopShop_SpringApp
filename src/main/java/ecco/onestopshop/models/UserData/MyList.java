/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.UserData;

import java.util.Arrays;
import java.util.List;

/**
 * MyList is a list of strings to copy to with POST.
 */
public class MyList {
    private List strings;

    public MyList() {
    }

    public MyList(List strings) {
        this.strings = strings;
    }

    public List getStrings() {
        return strings;
    }
    public String getString(int index){
        return (String) strings.get(index);
    }
    public int getLength(){
        return strings.size();
    }

    public void setStrings(List strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "strings=" + strings +
                '}';
    }
}
