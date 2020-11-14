package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ConjuredTest{

    @Test
    void qualityDegradesTwiceAsMuch() {                
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 6 - 2;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3-1)) ;
    }

    @Test
    void qualityWhenSellInUnder0() {              
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 7) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 7 - 2 - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 0-1)) ;
    }
    
    @Test
    void qualityWhenUnder0() {                
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 5-1)) ;
    }
}