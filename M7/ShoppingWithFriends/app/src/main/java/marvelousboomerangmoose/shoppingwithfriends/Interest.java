package marvelousboomerangmoose.shoppingwithfriends;

import java.util.ArrayList;

/**
 * Holds a list of the items the user is interested in.
 */
public class Interest {
    private ArrayList interestList;

    public Interest(ArrayList interestList) {
        this.interestList = interestList;
    }

    /**
     * Gets the list of items the user is interested in.
     * @return the user's interested items
     */
    public ArrayList getInterestList() {
        return interestList;
    }

    /**
     * Sets the user's list of interested items.
     * @param interestList the user's list of interested items
     */
    public void setInterestList(ArrayList interestList) {
        this.interestList = interestList;
    }
}
