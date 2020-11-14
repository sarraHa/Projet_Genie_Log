package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BackstageTest{

    @Test
	void mustNotBeEqualToNull() {
        assertThat(new Backstage(), is(notNullValue()));
    }

    @Test
    void qualityNotsuperiorto50() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 4)) ;
    }

    @Test
    void increaseQuality() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 21;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 14)) ;
    }

    @Test
    void qualityWhen10DaysLeft() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 22;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 8)) ;
    }

    @Test
    void qualityWhen5DaysLeft() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 10 + 3;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;
    }

    @Test
    void qualityAfterConcert() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( -1)) ;
    }

    @Test
    void qualityNotSuperiorto50() {                
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;
    }
}