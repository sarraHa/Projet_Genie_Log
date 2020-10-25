package com.gildedrose;

class Backstage extends GildedRoseItems {
    Item backstage ; 

    Backstage(Item item){
        this.backstage = item; 
    }

    public void updateBackstage(){
        updateQuality(backstage);
        if (this.backstage.sellIn < 11) { updateQuality(this.backstage); }
        if (this.backstage.sellIn < 6) { updateQuality(this.backstage); }
        if (sellInUnder0(this.backstage)) { setQualityTo0(this.backstage); }
    }

}