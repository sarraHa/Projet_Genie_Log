package com.gildedrose;

class Conjured extends GildedRoseItems{

   // Item conjured ; 

    //Conjured(Item item){
      //  this.conjured = item; 
    //}

    @Override
    protected void updateQuality( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    @Override
    protected void update( Item item){
        updateSellin(item);
        updateQuality(item);
        if (sellInUnder0(item)){
            updateQuality(item);
        }
        updateQuality(item);
    }

}