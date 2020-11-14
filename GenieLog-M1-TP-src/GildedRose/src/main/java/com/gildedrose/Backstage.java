package com.gildedrose;

class Backstage extends GildedRoseItems {

    @Override
    protected void update( Item item){
        updateSellin(item);
        updateQuality(item);
        if (item.sellIn < 11) { updateQuality(item); }
        if (item.sellIn < 6) { updateQuality(item); }
        if (sellInUnder0(item)) { setQualityTo0(item); }
    }

}