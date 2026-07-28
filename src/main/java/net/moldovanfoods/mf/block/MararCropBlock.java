package net.moldovanfoods.mf.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.moldovanfoods.mf.registry.ModItems;

public class MararCropBlock extends CropBlock {

    public MararCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.MARAR_SEEDS;
    }
}
