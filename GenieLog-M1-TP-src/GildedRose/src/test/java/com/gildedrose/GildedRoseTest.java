package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {


    //Tester le SellIn d'un produit ordinaire ( sellIn > 0)
    @Test
    void sellInProduitOrdinaire() {
        
        // name, sellIn, quality
        
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        System.out.println("name, sellIn, quality");
        int expectedSellIn = app.items[0].sellIn - 1;
        app.updateQuality();

        assertThat(app.items[0].sellIn, is( expectedSellIn ));
    }

    //Tester la quality d'un produit ordinaire ( sellIn > 0)
    @Test
    void qualityProduitOrdinaire() {        
        // name, sellIn, quality

        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }

    //"Aged Brie" augmente sa qualité (`quality`) plus le temps passe.
    @Test
    void qualityAgedBrie() {

        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality + 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }

    @Test
    void sellInAgedBrie() {     

        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        int expectedSellIn = app.items[0].sellIn - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedSellIn ));
    }

    
    //La qualité (`quality`) d'un produit ne peut jamais être négative.
    @Test
    void testNegativeQuality() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        ( assertThat(app.items[0].quality, is( expectedQuality )) & 1);
    }


 
}
