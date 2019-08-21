/*
 * written by Daniel Ashcroft
 */

package ecco.onestopshop.models.UserData;

import java.util.Arrays;

/**
 * MyList is a list of strings to copy to with POST.
 */
public class MyList {
    private String[] strings;

    public MyList() {
    }

    public MyList(String[] strings) {
        this.strings = strings;
    }

    public String[] getStrings() {
        return strings;
    }
    public String getString(int index){
        return strings[index];
    }
    public int getLength(){
        return strings.length;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "UserTechnologyList{" +
                "technologies=" + Arrays.toString(strings) +
                '}';
    }
}
