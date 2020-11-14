package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SulfurasTest {

 /*################ Sulfuras testes ######################################*/
    
    //"Sulfuras", étant un objet légendaire, n'a pas de date de péremption et ne perd jamais en qualité (`quality`)
    //Juste une précision, un produit ne peut jamais voir sa qualité augmenter au-dessus de 50, cependant "Sulfuras" est un objet légendaire et comme tel sa qualité est de 80 et il ne change jamais.

    @Test
    void qualitySulfuras() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 80;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;

    }


    @Test
    void qualitySulfurasWithNegativeSellIn() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 20;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;

    }
   // @Test
  /*  void test1() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 20;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }
    */

    /*################ End Sulfuras testes ######################################*/



}