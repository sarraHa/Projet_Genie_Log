package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";

    public static final int qualityMaximumValue = 50;
    public static final int qualityMinimumValue =  0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            
            updateSellin( item );
            switch(item.name) {
                case sulfuras:
                    break;
                case agedBrie:
                    AgedBrie agedBrie = new AgedBrie(item);
                    agedBrie.updateAgedBrie();
                    //updateAgedBrie(item);
                    break;
                case backstage:
                    updateBackstage(item);
                    break;
                case conjured:
                    updateConjured(item);
                    break;
                default:
                    updateOtherItems(item); 
            }
              
        }
    }

    private void updateQuality( Item item ) {
        if(qualityUnderMaxValue(item)){
            item.quality = item.quality + 1;        
        }
    }

    private void updateQualityOtherItems( Item item ) {
        if (item.quality > qualityMinimumValue) {
            item.quality = item.quality - 1;
        }
    }

    private void updateSellin( Item item ) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    private boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
    }

    private void setQualityTo0(Item backstage){
        backstage.quality = backstage.quality - backstage.quality;
    }

    private void updateAgedBrie(Item agedBrie ){
        updateQuality(agedBrie);
        if(sellInUnder0(agedBrie)){
            updateQuality(agedBrie);
        }
    }

    private void updateBackstage(Item backstage ){
        updateQuality(backstage);
        if (backstage.sellIn < 11) { updateQuality(backstage); }
        if (backstage.sellIn < 6) { updateQuality(backstage); }
        if (sellInUnder0(backstage)) { setQualityTo0(backstage); }
    }

    private void updateOtherItems( Item item){
        updateQualityOtherItems(item);
        if (sellInUnder0(item)){
            updateQualityOtherItems(item);
        }
    }

    private void updateConjured( Item conjured){
        updateOtherItems(conjured);
        updateQualityOtherItems(conjured);
    }

}