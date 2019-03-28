package training.weirdshop;

public class WeirdShop {
    private Item[] items;

    public WeirdShop(Item[] items) {
        this.items = items;
    }


    public boolean isBrie(Item item) {
        boolean itemIsBrie = false;
        if (item.name.equals("Aged-Brie")) {
            itemIsBrie = true;
        }
        return itemIsBrie;
    }

    public boolean isBackstagePass(Item item) {
        boolean itemIsBackstagePass = false;
        if (item.name.equals("Backstage Pass")) {
            itemIsBackstagePass = true;
        }
        return itemIsBackstagePass;
    }

    public boolean isGoldCoin(Item item) {
        boolean itemIsGoldCoin = false;
        if (item.name.equals("Gold Coin")) {
            itemIsGoldCoin = true;
        }
        return itemIsGoldCoin;
    }

    public boolean notMaxQaul(Item item) {
        boolean notMaxQual = false;
        if (item.quality < 50) {
            notMaxQual = true;
        }
        return notMaxQual;
    }


}
