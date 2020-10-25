package com.gildedrose;

class Backstage extends GildedRoseItems {
    Item backstage ; 

    Backstage(Item item){
        this.backstage = item; 
    }

    @Override
    protected void update( Item item){
        updateQuality(item);
        if (item.sellIn < 11) { updateQuality(item); }
        if (item.sellIn < 6) { updateQuality(item); }
        if (sellInUnder0(item)) { setQualityTo0(item); }
    }

}