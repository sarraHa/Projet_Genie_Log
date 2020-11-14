package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AgedBrieTest{

    @Test
    void increaseQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality + 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( 1 ));
    }

    
    @Test
    void SellInNegative() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 9) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality + 2;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( -3 ));
    }

    @Test
    void qualityNotsuperiorto50() {            
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 1)) ;
    }

    @Test
    void qualityNotsuperiorto50SellInNegative() {            
        Item[] items = new Item[] { new Item("Aged Brie", -4, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( -5)) ;
    }

    @Test
    void AgedBrieQualitySuperiorto50() {        
        Item[] items = new Item[] { new Item("Aged Brie", -10, 60) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality ;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }
}
    