package com.gildedrose;

class AgedBrie extends GildedRoseItems {
    Item agedBrie ; 

    AgedBrie(Item item){
        this.agedBrie = item; 
    }

    public void updateAgedBrie( ){
        updateQuality(this.agedBrie);
        if(sellInUnder0(this.agedBrie)){
            updateQuality(this.agedBrie);
        }
    }
}