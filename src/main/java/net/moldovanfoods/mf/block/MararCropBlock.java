package net.moldovanfoods.mf.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
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

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = getAge(state);
        int newAge = Math.min(getMaxAge(), age + 1);
        level.setBlockAndUpdate(pos, state.setValue(getAgeProperty(), newAge));
    }
}
