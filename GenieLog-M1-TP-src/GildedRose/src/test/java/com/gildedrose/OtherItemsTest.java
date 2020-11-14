package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OtherItemsTest{

    @Test
    void sellInOrdinaryProduct() {            
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality - 1;
        int expectedSellIn = app.items[0].sellIn - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( expectedSellIn ));
    }
        
    @Test
    void ordinaryItemWithNegativeSellInAndNegativeQuality() {        
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, -5) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }

    @Test
    void testNegativeQuality() {                
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
    }

    @Test
    void qualitywhensellinisnegativ() {                
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -2, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 20-2;
        int expectedSellIn= -2 -1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
        assertThat(app.items[0].sellIn, is( expectedSellIn )) ;
    }

    @Test
    void qualitywhenSellIn0() {

        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 2) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 2-2;
        int expectedSellIn= 0-1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
        assertThat(app.items[0].sellIn, is( expectedSellIn )) ;
    }
}