package com.gildedrose;


public abstract class GildedRoseItems {

    protected static final int QUALITYMAXVALUE = 50;
    protected static final int QUALITYMINVALUE =  0;

    GildedRoseItems() {
    }

    protected final void updateSellin(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected final boolean sellInUnder0(Item item) {
        return item.sellIn < 0;
    }

    protected final boolean qualityUnderMaxValue(Item item) {
        return item.quality < QUALITYMAXVALUE;
    }

    protected void updateQuality(Item item) {
        if (qualityUnderMaxValue(item)) {
            item.quality = item.quality + 1;        
        }
    }

    protected final void setQualityTo0(Item backstage) {
        backstage.quality = backstage.quality - backstage.quality;
    }

    protected void update(Item item) {
        updateSellin(item);
        updateQuality(item);
        if (sellInUnder0(item)) {
            updateQuality(item);
        }
    }   
}
