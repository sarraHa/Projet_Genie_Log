package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String conjured = "Conjured Mana Cake";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";


    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQuality( Item item ) {
        item.quality = item.quality + 1;
    }

    private void updateSellin( Item item ) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateAgedBrie(Item agedBrie ){

        // Aged Brie quality < 50
        if(agedBrie.quality < 50){
            updateQuality(agedBrie);
            updateSellin( agedBrie );
        
        }else{
            updateSellin(agedBrie);   
        }
        
        if(agedBrie.sellIn < 0 && agedBrie.quality < 50){
            updateQuality(agedBrie);
        }
    }


    private void updateBackstage(Item backstage ){


   
    }




    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if( items[i].name.equals(agedBrie)){
                updateAgedBrie( items[i]);
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (items[i].quality > 0) {

                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // si c'est un produit ordinaire
                        items[i].quality = items[i].quality - 1;
                    }
                }

            } else {
                                
                if (items[i].quality < 50) {

                    
                    // update quality Backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //items[i].quality = items[i].quality + 1;
                        updateQuality(items[i]);

                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                updateQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                updateQuality(items[i]);
                            }
                        }
                    }

                }
            }


            // update sellIn of all products unless Sulfuras and aged Brie
            // update sellIn Backstage passes
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && !items[i].name.equals(agedBrie)) {

                updateSellin(items[i]);
            }


            // if sellin < 0
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {

                        // Backstage when sellIn < 0 => 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } 
            }
        }
    }
}