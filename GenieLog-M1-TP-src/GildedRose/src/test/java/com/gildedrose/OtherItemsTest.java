package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OtherItemsTest{



    //Tester le SellIn d'un produit ordinaire ( sellIn > 0)
    @Test
    void sellInProduitOrdinaire() {
        
        // name, sellIn, quality
        
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality - 1;
        int expectedSellIn = app.items[0].sellIn - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( expectedSellIn ));
    }

    //Tester la quality d'un produit ordinaire ( sellIn < 0) et qualité < 0
        
    @Test
    void ordinaryItemWithNegativeSellInAndNegativeQuality() {        
        // name, sellIn, quality

        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, -5) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }

    //La qualité (`quality`) d'un produit ne peut jamais être négative.
    @Test
    void testNegativeQuality() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
    }

    //- Une fois que la date de péremption est passée, la qualité se dégrade deux fois plus rapidement.
    @Test
    void qualitywhensellinisnegativ() {
                
        // name, sellIn, quality
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
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 2) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 2-2;
        int expectedSellIn= 0-1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
        assertThat(app.items[0].sellIn, is( expectedSellIn )) ;
    }



}