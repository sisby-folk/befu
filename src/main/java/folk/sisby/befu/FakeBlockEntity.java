package folk.sisby.befu;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class FakeBlockEntity extends BlockEntity {
	public Block storedBlock;

	public FakeBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityFixerUpper.FAKE_BLOCK_ENTITY, pos, state);
	}

	public static void tick(World world, BlockPos pos, BlockState state, FakeBlockEntity be) {
		if (be.storedBlock != null) {
			world.removeBlockEntity(pos);
			world.setBlockState(pos, be.storedBlock.getDefaultState());
			world.updateNeighbors(pos, be.storedBlock);
			be.storedBlock = null;
		}
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		Registry.BLOCK.getOrEmpty(Identifier.tryParse(nbt.getString("Block"))).ifPresent(b -> this.storedBlock = b);
	}
}
