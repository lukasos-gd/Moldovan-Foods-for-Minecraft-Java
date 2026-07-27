package net.moldovanfoods.mf.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.moldovanfoods.mf.registry.ModItems;

public class MararCropBlock extends CropBlock {

    public MararCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.MARAR_SEEDS;
    }

    @Override
    protected int getMaxAge() {
        return 4;
    }
}
