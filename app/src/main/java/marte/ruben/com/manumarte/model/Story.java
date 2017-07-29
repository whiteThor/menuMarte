package marte.ruben.com.manumarte.model;


import marte.ruben.com.manumarte.R;
/**
 * Created by Ruben Vilchez on 08/07/2017.
 */

public class Story {

   public final Page[] pages;

    public Story() {
        pages = new Page[7];

        pages[0] = new Page(R.drawable.page0,
                R.string.page0,
                new Choice(R.string.page0_choice1,1),
                new Choice(R.string.page0_choice2,2),
                R.string.cap0);

        pages[1] = new Page(R.drawable.page1,
                R.string.page1,
                new Choice(R.string.page1_choice1, 3),
                new Choice(R.string.page1_choice2, 4),
                R.string.cap1);

        pages[2] = new Page(R.drawable.page2,
                R.string.page2,
                new Choice(R.string.page2_choice1, 4),
                new Choice(R.string.page2_choice2, 6),
                R.string.cap2);

        pages[3] = new Page(R.drawable.page3,
                R.string.page3,
                new Choice(R.string.page3_choice1, 4),
                new Choice(R.string.page3_choice2, 5),
                R.string.cap3);

        pages[4] = new Page(R.drawable.page4,
                R.string.page4,
                new Choice(R.string.page4_choice1, 5),
                new Choice(R.string.page4_choice2, 6),
                R.string.cap3);

        pages[5] = new Page(R.drawable.page5, R.string.page5, R.string.cap5);

        pages[6] = new Page(R.drawable.page6, R.string.page6, R.string.cap6);
    }

    public Page getPage(int pageNumber) {
        if(pageNumber >=pages.length){
            pageNumber=0;
        }
        return pages[pageNumber];
    }
}
