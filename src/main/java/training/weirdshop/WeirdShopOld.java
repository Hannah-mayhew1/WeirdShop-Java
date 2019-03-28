package training.weirdshop;

class WeirdShopOld {
    private Item[] items;

    public WeirdShopOld(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (int i = 0; i < items.length; i++)
            if (isPremiumItem(items[i])) {

            }
            if (isSpecialItem(items[i])) {
                if (isBrie(items[i])) {
                    updateQualityBrie(items[i]);
                } if (isBackstagePass(items[i])) {
                    updateQualityBackstagePass(items[i]);
                }
            } else {
                updateQualOther(items[i]);
            }
    }

    public boolean isPremiumItem(Item item) {
        boolean is
    }

    public boolean isSpecialItem(Item item) {
        boolean isSpecialItem = false;
        if ((item.name.equals("Aged Brie")) || (item.name.equals("Backstage Pass")) || (item.name.equals("Gold Coin"))) {
            isSpecialItem = true;
        }
        return isSpecialItem;
    }

    public boolean isBrie(Item item) {
        boolean itemIsBrie = false;
        if (item.name.equals("Aged Brie")) {
            itemIsBrie = true;
        }
        return itemIsBrie;
    }

    public void updateQualityBrie(Item item) {
        decSellIn(item);
        incQualByOne(item);
    }

    public boolean isBackstagePass(Item item) {
        boolean itemIsBackstagePass = false;
        if (item.name.equals("Backstage Pass")) {
            itemIsBackstagePass = true;
        }
        return itemIsBackstagePass;
    }

    public void updateQualityBackstagePass(Item item) {
        decSellIn(item);
        if(notMaxQaul(item)) {
            if (item.sellIn < 0) {
                item.quality = 0;
            } else if (item.sellIn <= 5) {
                item.quality = item.quality + 3;
            } else if (item.sellIn <= 10) {
                item.quality = item.quality + 2;
            } else {
                incQualByOne(item);
            }
        }
    }

    public boolean isGoldCoin(Item item) {
        boolean itemIsGoldCoin = false;
        if (item.name.equals("Gold Coin")) {
            itemIsGoldCoin = true;
        }
        return itemIsGoldCoin;
    }

    public void updateQualOther(Item item) {
        decSellIn(item);
        if(notMaxQaul(item) && (item.quality > 0)) {
            if (item.sellIn < 0) {
                item.quality = item.quality - 2;
            } else {
                decQualByOne(item);
            }
        }
    }

    public boolean notMaxQaul(Item item) {
        boolean notMaxQual = false;
        if (item.quality < 50) {
            notMaxQual = true;
        }
        return notMaxQual;
    }

    public void incQualByOne(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void decQualByOne(Item item) {
        item.quality = item.quality - 1;
    }

    public void decSellIn(Item item) {
        item.sellIn = item.sellIn -1;
    }
}