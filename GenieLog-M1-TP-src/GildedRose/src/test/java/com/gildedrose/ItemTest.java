package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ItemTest{


/*#################################### Other Items testes #################################*/

    // Tester le nom sellIN , quality
    @Test
    void testProperties(){
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        assertThat(app.items[0].name, is( "+5 Dexterity Vest" ));
        assertThat(app.items[0].sellIn, is( 10));
        assertThat(app.items[0].quality, is(20));
    }

}