package com.gildedrose;

class OtherItems extends GildedRoseItems {

    Item item ; 

    OtherItems(Item item){
        this.item = item;
    }

    @Override
    protected void updateQuality( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    @Override
    protected void update(Item item){
        updateQuality(this.item);
        if (sellInUnder0(this.item)){
            updateQuality(this.item);
        }
    }

    
}