package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BackstageTest{


    @Test
	void mustNotBeEqualToNull() {
        assertThat(new Backstage(), is(notNullValue()));
    }

 //################ Backstage testes ##########################"/
    
    //- La qualité d'un produit n'est jamais de plus de 50.
    @Test
    void qualityNotsuperiorto50() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 4)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 21;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 14)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_1() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 21;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 14)) ;

    }



    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_2() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 22;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 8)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_3() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 10 + 3;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }


    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    //la quality ne peut pas etre plus de 50
    @Test
    void qualityBackstageAfterConcert() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( -1)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    //la quality ne peut pas etre plus de 50
    @Test
    void qualityBackstagePassesSuperiorto50() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }
    
    //################ end Backstage testes ##########################"/


}