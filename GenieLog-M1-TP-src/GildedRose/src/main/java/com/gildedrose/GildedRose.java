package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            
            //updateSellin( item );
            GildedRoseItems gildedRoseItem = getItemByName(item);
            gildedRoseItem.update(item);
        }
    }

    private GildedRoseItems getItemByName(Item item){
        switch(item.name) {
            case sulfuras:
                Sulfuras sulfuras = new Sulfuras(item);
                return sulfuras;
            case agedBrie:
                AgedBrie agedBrie = new AgedBrie(item);
                return agedBrie;
            case backstage:
                Backstage backstage = new Backstage(item);
                return backstage;
            case conjured:
                Conjured conjured = new Conjured(item);
                return conjured;
            default:
                OtherItems otherItems = new OtherItems(item);
                return otherItems;
        }
    }


 //   private void updateSellin( Item item ) {
   //     item.sellIn = item.sellIn - 1;
    //}

}