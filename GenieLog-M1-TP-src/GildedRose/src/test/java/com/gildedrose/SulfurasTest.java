package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SulfurasTest {

    @Test
    void qualityWhenSellInEqualto() {                
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 80;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;
    }
    
    @Test
    void qualityWhenNegativeSellIn() {                
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 20;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;
    }
}